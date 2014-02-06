package plague.client.tab;

import net.minecraft.creativetab.CreativeTabs;
import plague.client.item.PlagueItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabPlagueItems extends CreativeTabs {
	
public TabPlagueItems(int position, String tabID) {
super(position, tabID);
}
@SideOnly(Side.CLIENT)
public int getTabIconItemIndex()
//Item Show Case
{
	return PlagueItems.itemSyringeBasic.itemID;
}

public String getTranslatedTabLabel()
{
//Creative Tab In-Game Name	
return "Plague Items";
}
}
