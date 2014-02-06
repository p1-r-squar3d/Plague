package plague.client.item;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import plague.common.Plague;
import plague.common.assets.StringColor;

public class ItemSecretThing extends Item { 

private String unLocalizedName = this.getClass().getName();
private String username = "lol";
public ItemSecretThing(int par1) {
	super(par1);
	setUnlocalizedName(unLocalizedName);
	setMaxStackSize(1);
	setCreativeTab(Plague.tabPlagueItems);
	setMaxDamage(1000);

}
@Override
public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B){
l.add(StringColor.light_yellow + "Hello there," + Minecraft.getMinecraft().thePlayer.username.toString());	
l.add(StringColor.light_yellow + "We would like to thank you for downloading our mod!");
l.add(StringColor.light_yellow + "Please stay tuned for more mods :)");
l.add(StringColor.light_yellow + "===================================================");
l.add(StringColor.light_yellow + "EKAMUESOHWL");
}

public void registerIcons(IconRegister iconRegister) {
	itemIcon = iconRegister.registerIcon(Plague.TEXTURE + "syringe");
	}
}
