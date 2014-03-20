package p1.plague.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import p1.plague.Plague;

public class ItemTesttube extends Item {

public ItemTesttube(int par1) {
	super(par1);
	setUnlocalizedName(PlagueItems.UN[7]);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "test_tube");
	}
}
