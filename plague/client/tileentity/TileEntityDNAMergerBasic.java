package plague.client.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import plague.client.block.BlockDNAMergerBasic;
import plague.client.block.BlockSyringeScannerBasic;
import plague.client.recipe.DNAMergerRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityDNAMergerBasic extends TileEntity implements IInventory, IPowered
{
	private ItemStack[] slots = new ItemStack[7];
	private int[] slotArray1 = new int []{0,1};
    public int mergerBurnTime;
    public int currentItemBurnTime;
    public int mergerCookTime;
    public int power;
    public int maxPower = 10000;
    public int scanProgress;
    public int scanSpeed = 100;
    private String customName;

    public TileEntityDNAMergerBasic()
    {
        slots = new ItemStack[7];
        currentItemBurnTime = 0;
        mergerCookTime = 0;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return slots.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int i)
    {
        return slots[i];
    }

    public void setInventorySlotConatainers(int i, ItemStack itemstack)
    {
        slots[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        slots = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound1.getByte("Slot");

            if (byte0 >= 0 && byte0 < slots.length)
            {
                slots[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        mergerBurnTime = nbttagcompound.getShort("BurnTime");
        power = nbttagcompound.getShort("power");
        mergerCookTime = nbttagcompound.getShort("CookTime");
        currentItemBurnTime = getItemPower(slots[1]);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("power", (short)this.power);
        nbttagcompound.setShort("BurnTime", (short)mergerBurnTime);
        nbttagcompound.setShort("CookTime", (short)mergerCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < slots.length; i++)
        {
            if (slots[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                slots[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbttagcompound.setTag("Items", nbttaglist);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    public int getCookProgressScaled(int i)
    {
    	return this.mergerBurnTime * i / this.scanSpeed;
    }

    public int getPowerRemainingScaled(int i)
    {
    	return this.power * i / this.maxPower;
    }

    public boolean isBurning()
    {
    	return this.mergerCookTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean flag = power > 0;
        boolean flag1 = false;
        
        if (hasPower() && isScanning()){
    		this.power--;
    		scanProgress++;
    		}
    	if (canSmelt() == false) {
    		scanProgress = 0;
    	}
    	if (power > maxPower) {
			power = 10000;
		}
    	
        if (!worldObj.isRemote)
        {
        	if (this.power < this.maxPower && this.getItemPower(this.slots[3]) > 0){
        		this.power += getItemPower(this.slots[3]);
        		
        		flag1 = true;
            	
        		if (this.slots[3] != null){
                		this.slots[3].stackSize--;

                		if (this.slots[3].stackSize == 0){
                    		this.slots[3] = this.slots[3].getItem().getContainerItemStack(slots[3]);
                		}
            	}                
        	}

            if (hasPower() && canSmelt())
            {
            	++this.mergerCookTime;

            	if (this.mergerCookTime == this.scanSpeed)
            	{
                	this.mergerCookTime = 0;
                	this.smeltItem();
               	flag1 = true;
            	}
        	}
        }

        	else
        	{
            	this.mergerCookTime = 0;
        	}

            if (flag != (power > 0))
            {
            	flag1 = true;
            		BlockDNAMergerBasic.updateFurnaceBlockState(this.power > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
        		}	

        if (flag1)
        {
            onInventoryChanged();
        }
    }

    private boolean canSmelt()
    {
        if (slots[0] == null || slots[1] == null)
        {
            return false;
        }

        ItemStack itemstack = DNAMergerRecipes.getSmeltingResult(slots[0].getItem().itemID, slots[1].getItem().itemID);

        if (itemstack == null)
        {
            return false;
        }

        if (slots[2] == null)
        {
            return true;
        }

        if (!slots[2].isItemEqual(itemstack))
        {
            return false;
        }

        if (slots[2].stackSize < getInventoryStackLimit() && slots[2].stackSize < slots[2].getMaxStackSize())
        {
            return true;
        }
        else
        {
            return slots[2].stackSize < itemstack.getMaxStackSize();
        }
    }

    public void smeltItem()
    {
        if (!canSmelt())
        {
            return;
        }

        ItemStack itemstack = DNAMergerRecipes.getSmeltingResult(slots[0].getItem().itemID, slots[1].getItem().itemID);

        if (slots[2] == null)
        {
            slots[2] = itemstack.copy();
        }
        else if (slots[2].itemID == itemstack.itemID)
        {
            slots[2].stackSize++;
        }

        for (int i = 0; i < 2; i++)
        {
            if (slots[i].stackSize <= 0)
            {
                slots[i] = new ItemStack(slots[i].getItem().setFull3D());
            }
            else
            {
                slots[i].stackSize--;
            }

            if (slots[i].stackSize <= 0)
            {
                slots[i] = null;
            }
        }
    }

    public int getItemPower(ItemStack itemstack)
    {
    if (itemstack == null){
    	return 0;
	}else{
		int i = itemstack.getItem().itemID;
	
		if (i == Item.redstone.itemID) return 10;
		if (i == Item.glowstone.itemID) return 11;
		if (i == Item.diamond.itemID) return 10000;
    	return 0;
	}
}

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }
        else
        {
            return entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
        }
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int i, int j)
    {
        if (slots[i] != null)
        {
            if (slots[i].stackSize <= j)
            {
                ItemStack itemstack = slots[i];
                slots[i] = null;
                return itemstack;
            }

            ItemStack itemstack1 = slots[i].splitStack(j);

            if (slots[i].stackSize == 0)
            {
                slots[i] = null;
            }

            return itemstack1;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        slots[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "container.dnamerger";
    }

    public void openChest()
    {
    }

    public void closeChest()
    {
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int i)
    {
        if (slots[i] != null)
        {
            ItemStack itemstack = slots[i];
            slots[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
	public boolean isInvNameLocalized()
	{
	    return (this.customName != null) && (this.customName.length() > 0);
	}

	public void setCustomName(String name) 
	{
	    this.customName = name;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i == 2 ? false : (i == 1 ? isItemFuel(itemstack) : true);
	}

	@Override
	public void setGuiDisplayName(String par1Str) {
		
	}

	@Override
	public boolean isItemFuel(ItemStack par0ItemStack) {

		return getItemPower(par0ItemStack) > 0;
	}


	@Override
	public boolean hasPower() {
		return this.power > 0;
	}

	@Override
	public boolean isScanning() {
		scanProgress++;
		return this.mergerCookTime > 0;
	}

	@Override
	public boolean isPowerDrained() {
		return false;
	}
}