package plague.client.tab;

import net.minecraft.creativetab.CreativeTabs;
import plague.client.block.PlagueBlocks;
import plague.common.assets.StringColor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabPlagueBlocks extends CreativeTabs {
	
public TabPlagueBlocks(int position, String tabID) {
super(position, tabID);
}
@SideOnly(Side.CLIENT)
public int getTabIconItemIndex()
//Item Show Case
{
return PlagueBlocks.blockSyringeScannerBasicIdle.blockID;
}

public String getTranslatedTabLabel()
{
//Creative Tab In-Game Name	
	return StringColor.dark_red + "Plague " + StringColor.dark_gray + "Blocks";
}
}
