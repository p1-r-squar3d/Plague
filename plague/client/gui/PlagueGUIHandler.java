package plague.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import plague.client.container.ContainerDNAMergerBasic;
import plague.client.container.ContainerSyringeScannerBasic;
import plague.client.tileentity.TileEntityDNAMergerBasic;
import plague.client.tileentity.TileEntitySyringeScannerBasic;
import plague.common.Plague;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

	public class PlagueGUIHandler implements IGuiHandler {
		public PlagueGUIHandler() {
			
		}

		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			TileEntity entity = world.getBlockTileEntity(x, y, z);

			if(entity != null){
				switch (id) {
					case 8:
						if (entity instanceof TileEntitySyringeScannerBasic) {
							return new ContainerSyringeScannerBasic(player.inventory, (TileEntitySyringeScannerBasic) entity);
						}
						return null;
					case 9:
						if (entity instanceof TileEntityDNAMergerBasic) {
							return new ContainerDNAMergerBasic(player.inventory, (TileEntityDNAMergerBasic) entity);
						}
						return null;
					default:
						return null;
				}
			}
			
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			TileEntity entity = world.getBlockTileEntity(x, y, z);

			if(entity != null){
				switch (id) {
					case 8:
						if (entity instanceof TileEntitySyringeScannerBasic) {
							return new GUISyringeScannerBasic(player.inventory, (TileEntitySyringeScannerBasic) entity);
						}
						return null;
					case 9:	
						if (entity instanceof TileEntityDNAMergerBasic) {
							return new GUIDNAMergerBasic(player.inventory, (TileEntityDNAMergerBasic) entity);
						}
						return null;
					default:
						return null;
				}
			}

			return null;
		}	
	}
