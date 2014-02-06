package plague.client.core;

import plague.client.tileentity.TileEntitySyringeScannerBasic;
import plague.common.core.CommonProxy;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	
@SideOnly(Side.CLIENT)
public static void registerRenderInformation() {
}
}
