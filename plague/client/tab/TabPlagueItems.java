package plague.client.tab;

import net.minecraft.creativetab.CreativeTabs;
import plague.client.item.PlagueItems;
import plague.common.assets.StringColor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabPlagueItems extends CreativeTabs {
	
public TabPlagueItems(int position, String tabID) {
super(position, tabID);
}
@SideOnly(Side.CLIENT)
public int getTabIconItemIndex()
{
	return PlagueItems.itemSyringeBasic.itemID;
}

public String getTranslatedTabLabel()
{
return StringColor.dark_red + "Plague " + StringColor.dark_gray + "Items";
}
}
