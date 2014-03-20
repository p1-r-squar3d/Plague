package p1.plague.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import p1.plague.block.PlagueBlocks;
import p1.plague.block.container.ContainerCircuitBuilder;
import p1.plague.block.container.ContainerDNAMergerBasic;
import p1.plague.block.container.ContainerSyringeScannerBasic;
import p1.plague.block.tileentity.TileEntityCircuitBuilder;
import p1.plague.block.tileentity.TileEntityDNAMergerBasic;
import p1.plague.block.tileentity.TileEntitySyringeScannerBasic;
import p1.plague.gui.GUICircuitBuilder;
import p1.plague.gui.GUIDNAMergerBasic;
import p1.plague.gui.GUISyringeScannerBasic;
import cpw.mods.fml.common.network.IGuiHandler;

public class PlagueGUIHandler implements IGuiHandler {
	
	public PlagueGUIHandler() {

	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if (entity != null) {
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
				case 10:
					if (entity instanceof TileEntityCircuitBuilder) {
						return new ContainerCircuitBuilder(player.inventory, world, x, y, z, (TileEntityCircuitBuilder) entity);
					}
					return null;
				default:
					return null;
			}
		}
		else {
			/* stub method for non entity blocks */
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		if (entity != null) {
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
				case 10:
					if (entity instanceof TileEntityCircuitBuilder) {
						return new GUICircuitBuilder(player.inventory, world, x, y, z, (TileEntityCircuitBuilder) entity);
					}
					return null;
				default:
					return null;
			}
		}
		else {
			/* stub method for non entity blocks */
		}
		return null;
	}
}
