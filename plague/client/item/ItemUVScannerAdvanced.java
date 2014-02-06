package plague.client.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import plague.common.Plague;

public class ItemUVScannerAdvanced extends Item {

private String unLocalizedName = this.getClass().getName();
	
public ItemUVScannerAdvanced(int par1) {
	super(par1);
	setUnlocalizedName(unLocalizedName);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
}
@Override
public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B){
l.add("\u00a7BAdvanced");	
l.add("[Empty]");
}
public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "uv_scanner_adv");
	}
}
