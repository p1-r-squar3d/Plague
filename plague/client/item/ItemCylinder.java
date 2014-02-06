package plague.client.item;

import plague.common.Plague;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemCylinder extends Item {

private String unLocalizedName = this.getClass().getName();
	
public ItemCylinder(int par1) {
	super(par1);
	setUnlocalizedName(unLocalizedName);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "cylinder");
	}
}
