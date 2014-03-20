package p1.plague.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import p1.plague.Plague;

public class ItemSyringeBasic extends Item {
	
public ItemSyringeBasic(int par1, boolean canHoldFluid_confir) {
	super(par1);
	setUnlocalizedName(PlagueItems.UN[0]);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
	setMaxDamage(50);
}

@Override
public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B){
l.add("Basic");
l.add("[Empty]");
}
public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "syringe");
	}
}