package plague.client.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import plague.common.Plague;
import plague.common.PlagueExtendedPlayer;
import plague.common.assets.StringColor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBattery extends Item implements IPoweredItem{

public ItemBattery(int par1, int maxPower) {
	super(par1);
	setCreativeTab(Plague.tabPlagueItems);
	setUnlocalizedName("battery");
	setMaxDamage(maxPower);
	}
@Override
public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	int p = this.getMaxDamage() - this.getDamage(par1ItemStack);
	
	par3List.add(p + " / " + this.getMaxDamage() + " AMPz");
}
}