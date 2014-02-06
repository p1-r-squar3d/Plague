package plague.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import plague.client.recipe.SyringeScannerRecipes;
import plague.client.tileentity.TileEntitySyringeScannerBasic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

	public class ContainerSyringeScannerBasic extends Container
	{
		private TileEntitySyringeScannerBasic syringeScanner;
		private int lastCookTime;
		private int lastBurnTime;

		public ContainerSyringeScannerBasic(InventoryPlayer par1InventoryPlayer, TileEntitySyringeScannerBasic par2TileEntityFurnace)
		{
			this.syringeScanner = par2TileEntityFurnace;
			/**syringe**/
			this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 24, 51));
			/**power**/
			this.addSlotToContainer(new Slot(par2TileEntityFurnace, 1, 24, 137));
			/**upgrade slots**/
			this.addSlotToContainer(new Slot(par2TileEntityFurnace, 2, 114, 137));
			this.addSlotToContainer(new Slot(par2TileEntityFurnace, 3, 132, 137));
			this.addSlotToContainer(new Slot(par2TileEntityFurnace, 4, 150, 137));
			this.addSlotToContainer(new Slot(par2TileEntityFurnace, 5, 168, 137));
			/****/
			this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player, par2TileEntityFurnace, 6, 50, 50));
			int i;
/**main inventory**/
			for (i = 0; i < 3; ++i)
			{
				for (int j = 0; j < 9; ++j)
				{
					this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 24 + j * 18, 166 + i * 18));
				}
			}
			/**hotbar**/
			for (i = 0; i < 9; ++i)
			{
						/**24 is LEFT TO RIGHT postioning... 18 is spacing... 255 is UP TO DOWN positioning**/
				this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 24 + i * 18, 255 - 30));
			}
		}

		public void addCraftingToCrafters(ICrafting par1ICrafting)
		{
			super.addCraftingToCrafters(par1ICrafting);
			par1ICrafting.sendProgressBarUpdate(this, 0, this.syringeScanner.cookTime);
			par1ICrafting.sendProgressBarUpdate(this, 1, this.syringeScanner.power);
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

				if (this.lastCookTime != this.syringeScanner.cookTime)
				{
					icrafting.sendProgressBarUpdate(this, 0, this.syringeScanner.cookTime);
				}

				if (this.lastBurnTime != this.syringeScanner.power)
				{
					icrafting.sendProgressBarUpdate(this, 1, this.syringeScanner.power);
				}
			}

			this.lastCookTime = this.syringeScanner.cookTime;
			this.lastBurnTime = this.syringeScanner.power;
		}

		@SideOnly(Side.CLIENT)
		public void updateProgressBar(int par1, int par2)
		{
			if (par1 == 0)
			{
				this.syringeScanner.cookTime = par2;
			}

			if (par1 == 1)
			{
				this.syringeScanner.power = par2;
			}
		}

		public boolean canInteractWith(EntityPlayer par1EntityPlayer)
		{
			return this.syringeScanner.isUseableByPlayer(par1EntityPlayer);
		}

		/**
		 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
		 */
		public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
		{
			ItemStack itemstack = null;
			Slot slot = (Slot)this.inventorySlots.get(par2);

			if (slot != null && slot.getHasStack())
			{
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();

				if (par2 == 2)
				{
					if (!this.mergeItemStack(itemstack1, 3, 39, true))
					{
						return null;
					}

					slot.onSlotChange(itemstack1, itemstack);
				}
				else if (par2 != 1 && par2 != 0)
				{
					if (SyringeScannerRecipes.getSmeltingResult(par2)!= null)
					{
						if (!this.mergeItemStack(itemstack1, 0, 1, false))
						{
							return null;
						}
					}
					else if (TileEntitySyringeScannerBasic.isItemFuel(itemstack1))
					{
						if (!this.mergeItemStack(itemstack1, 1, 2, false))
						{
							return null;
						}
					}
					else if (par2 >= 3 && par2 < 30)
					{
						if (!this.mergeItemStack(itemstack1, 30, 39, false))
						{
							return null;
						}
					}
					else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
					{
						return null;
					}
				}
				else if (!this.mergeItemStack(itemstack1, 3, 39, false))
				{
					return null;
				}

				if (itemstack1.stackSize == 0)
				{
					slot.putStack((ItemStack)null);
				}
				else
				{
					slot.onSlotChanged();
				}

				if (itemstack1.stackSize == itemstack.stackSize)
				{
					return null;
				}

				slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
			}

			return itemstack;
		}
	}
