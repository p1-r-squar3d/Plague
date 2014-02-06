package plague.client.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import plague.common.Plague;

public class ItemGlassPanel extends Item {

private String unLocalizedName = this.getClass().getName();
	
public ItemGlassPanel(int par1) {
	super(par1);
	setUnlocalizedName(unLocalizedName);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "glass_panel");
}
}