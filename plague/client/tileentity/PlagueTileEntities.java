package plague.client.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class PlagueTileEntities {

public static void load() {
	GameRegistry.registerTileEntity(TileEntitySyringeScannerBasic.class, "SyringeScannerBasic");
	GameRegistry.registerTileEntity(TileEntityDNAMergerBasic.class,"MergerBasic");
}
}
