package p1.plague.block.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCircuitBuilder extends TileEntity {

	public boolean ready = false;
	public boolean installed = false;

	public TileEntityCircuitBuilder() {
		
	}
	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setBoolean("IsCBReady", ready);
		par1.setBoolean("IsCBInstalled", installed);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.ready = par1.getBoolean("IsCBReady");
		this.installed = par1.getBoolean("IsCBInstalled");
	}
}
