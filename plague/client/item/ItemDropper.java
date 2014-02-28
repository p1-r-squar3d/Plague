package plague.client.item;

import plague.common.Plague;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemDropper extends Item {

public ItemDropper(int par1) {
	super(par1);
	setUnlocalizedName(PlagueItems.UN[8]);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "dropper");
	}
}
