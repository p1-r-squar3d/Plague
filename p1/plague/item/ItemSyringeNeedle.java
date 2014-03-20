package p1.plague.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import p1.plague.Plague;

public class ItemSyringeNeedle extends Item {

public ItemSyringeNeedle(int par1) {
	super(par1);
	setUnlocalizedName(PlagueItems.UN[12]);
	setMaxStackSize(64);
	setCreativeTab(Plague.tabPlagueItems);
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "syringe_needle");
	}
}
