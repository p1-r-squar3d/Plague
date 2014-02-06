package plague.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import plague.client.slot.SlotDNAMerger;
import plague.client.tileentity.TileEntityDNAMergerBasic;

public class ContainerDNAMergerBasic extends Container
{
    private TileEntityDNAMergerBasic merger;
	private int lastCookTime;
	private int lastBurnTime;

    public ContainerDNAMergerBasic(InventoryPlayer inventoryplayer, TileEntityDNAMergerBasic tileentityMerger)
    {
       
        merger = tileentityMerger;
        /**input**/
        this.addSlotToContainer(new Slot(tileentityMerger, 0, 48, 32));
        this.addSlotToContainer(new Slot(tileentityMerger, 1, 88, 32));
        /**output old slot 3**/
        this.addSlotToContainer(new SlotDNAMerger(inventoryplayer.player, tileentityMerger, 2, 122, 33));
        /** power old slot 4**/
        this.addSlotToContainer(new Slot(tileentityMerger, 3, 24, 137));
        /**upgrade slot**/
        this.addSlotToContainer(new Slot(tileentityMerger, 4, 132, 137));
        this.addSlotToContainer(new Slot(tileentityMerger, 5, 150, 137));
        this.addSlotToContainer(new Slot(tileentityMerger, 6, 168, 137));
int i;
        for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventoryplayer, j + i * 9 + 9, 24 + j * 18, 166 + i * 18));
			}
		}
		/**hotbar**/
		for (i = 0; i < 9; ++i)
		{
					/**24 is LEFT TO RIGHT postioning... 18 is spacing... 255 is UP TO DOWN positioning**/
			this.addSlotToContainer(new Slot(inventoryplayer, i, 24 + i * 18, 255 - 30));
		}
	}
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.merger.mergerCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 4, this.merger.power);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
    	super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if (this.lastCookTime != this.merger.mergerCookTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, this.merger.mergerCookTime);
			}

			if (this.lastBurnTime != this.merger.power)
			{
				icrafting.sendProgressBarUpdate(this, 1, this.merger.power);
			}
		}

		this.lastCookTime = this.merger.mergerCookTime;
		this.lastBurnTime = this.merger.power;
	}


    public void updateProgressBar(int i, int j)
    {
    	if (i == 0)
		{
			this.merger.mergerCookTime = j;
		}

		if (i == 1)
		{
			this.merger.power = j;
		}
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }
            }
            else if (par2 >= 3 && par2 < 30)
            {
                if (!mergeItemStack(itemstack1, 30, 39, false))
                {
                    return null;
                }
            }
            else if (par2 >= 30 && par2 < 39)
            {
                if (!mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
            }
            else
            {
                return null;
            }
        }

        return itemstack;
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return merger.isUseableByPlayer(entityplayer);
    }
}