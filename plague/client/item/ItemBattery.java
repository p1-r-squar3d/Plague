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

public ItemBattery(int par1) {
	super(par1);
	setCreativeTab(Plague.tabPlagueItems);
	setUnlocalizedName("battery");
	}

public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
	if( par1ItemStack.stackTagCompound == null )
	{	
    par1ItemStack.setTagCompound( new NBTTagCompound( ) );
	par1ItemStack.stackTagCompound.setInteger("Power", 0);
	}
}
public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
{
	PlagueExtendedPlayer.get(par2EntityPlayer).replenishDNAPoints();
    return true;
}

public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
{
	if( par1ItemStack.stackTagCompound == null ){
    par1ItemStack.setTagCompound( new NBTTagCompound( ) );
	}
	if( par1ItemStack.stackTagCompound.hasKey( "Power" ) ) {
    par3List.add( par1ItemStack.stackTagCompound.getInteger("Power") + " / 1000 EU");
}
else
{
    par3List.add("---- / ---- EU");
}
}
}