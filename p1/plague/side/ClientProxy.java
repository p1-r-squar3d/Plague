package p1.plague.side;

import p1.plague.block.tileentity.TileEntitySyringeScannerBasic;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	
@SideOnly(Side.CLIENT)
public static void registerRenderInformation() {
	
}
}
