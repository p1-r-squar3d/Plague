package plague.client.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import plague.common.Plague;

public class ItemSyringePlunger extends Item {

public ItemSyringePlunger(int par1) {
	super(par1);
	setUnlocalizedName(PlagueItems.UN[11]);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "syringe_plunger");
	}
}
