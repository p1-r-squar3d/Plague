package plague.client.tileentity;

import plague.client.gui.GUISyringeScannerBasic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IPowered {

/**
 * Sets the localized GUI name.
*/
void setGuiDisplayName(String par1Str);
/*
 * Reads NBT for the machine to be independent.
 */
void readFromNBT(NBTTagCompound par1NBTTagCompound);
/**
* Return true if item is a fuel source (getItempower() > 0).
*/
boolean isItemFuel(ItemStack par0ItemStack);
/**
 * Returns default power starting value (0 by default).
 */

/**
* Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
* fuel.
*/
int getItemPower(ItemStack par0ItemStack);

/**
* Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack.
*/
void smeltItem();


@SideOnly(Side.CLIENT)

/**
	* Returns an integer between 0 and the passed value representing how close the current item is to being completely
	* cooked
	*/
int getCookProgressScaled(int par1);


int getPowerRemainingScaled(int par1);

/**
* Returns true if the furnace is currently burning
*/
boolean hasPower();

/**
 * Checks if it is scanning.
 */
boolean isScanning();
/**
 * Checks if the power is drained or whatnot.
 */
boolean isPowerDrained();

}

