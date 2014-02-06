package plague.client.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import plague.common.Plague;

public class ItemSyringeTube extends Item {
	
private String unLocalizedName = this.getClass().getName();

public ItemSyringeTube(int par1) {
	super(par1);
	setUnlocalizedName(unLocalizedName);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "syringe_tube");
	}
}