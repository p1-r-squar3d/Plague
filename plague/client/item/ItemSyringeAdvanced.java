package plague.client.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import plague.common.Plague;
import plague.common.assets.StringColor;

public class ItemSyringeAdvanced extends Item { 

private String unLocalizedName = this.getClass().getName();
	
public ItemSyringeAdvanced(int par1) {
	super(par1);
	setUnlocalizedName(unLocalizedName);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
	setMaxDamage(1000);

}
@Override
public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B){
l.add(StringColor.light_cyan + "Advanced");	
l.add("[Empty]");
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "syringe");
	}
}
