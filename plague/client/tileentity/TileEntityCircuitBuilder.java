package plague.client.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCircuitBuilder extends TileEntity{
	
	public boolean hash = false;
	public boolean ready = false;
	public boolean installed = false;
	
	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
	   super.writeToNBT(par1);
	   par1.setBoolean("IsButtonHashed", hash);
	   par1.setBoolean("IsCBReady", ready);
	   par1.setBoolean("IsCBInstalled", installed);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
	   super.readFromNBT(par1);
	   this.hash = par1.getBoolean("IsButtonHashed");
	   this.ready = par1.getBoolean("IsCBReady");
	   this.installed = par1.getBoolean("IsCBInstalled");
	}
}
