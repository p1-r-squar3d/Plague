package plague.client.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import plague.common.Plague;

public class ItemSyringeNeedle extends Item {

public ItemSyringeNeedle(int par1) {
	super(par1);
	setUnlocalizedName(PlagueItems.UN[12]);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "needle");
	}
}
