package p1.plague.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import p1.plague.Plague;

public class ItemGlassStrip extends Item {
	
public ItemGlassStrip(int par1) {
	super(par1);
	setUnlocalizedName(PlagueItems.UN[9]);
	setMaxStackSize(64);
	setCreativeTab(Plague.tabPlagueItems);
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "glass_strip");
}
}