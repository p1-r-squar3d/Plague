package plague.client.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import plague.common.Plague;

public class ItemGlassPanel extends Item {

public ItemGlassPanel(int par1) {
	super(par1);
	setUnlocalizedName(PlagueItems.UN[10]);
	setMaxStackSize(64);
	setCreativeTab(Plague.tabPlagueItems);
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "glass_panel");
}
}