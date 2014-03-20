package p1.plague.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import p1.plague.Plague;



public class ItemBlockirusDeployerBasic extends Item {
	
public ItemBlockirusDeployerBasic(int par1) {
	super(par1);
	setUnlocalizedName(PlagueItems.UN[2]);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
	setMaxDamage(500);
}
@Override
public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B){
l.add("Basic");	
l.add("[Empty]");
}
public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
{
	
         if(!par3World.isRemote)
         {
                par3World.setBlock(par4, par5, par6, Block.bedrock.blockID);
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
         }
         else
                return false;
		}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon("lesslyepic:blockirus_deploy_bas");
	}
}