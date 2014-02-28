package plague.common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PlagueExtendedPlayer implements IExtendedEntityProperties{

	public final static String EXT_PROP_NAME = "PlagueExtendedPlayer";
	private static EntityPlayer player;
	private static int maxDNAPoints;
	
	public static final int DNAPOINTS_WATCHER = 0;
	
	public PlagueExtendedPlayer(EntityPlayer player)
	{
	
	this.player = player;
	this.player.getDataWatcher().addObject(DNAPOINTS_WATCHER, this.maxDNAPoints);
	this.maxDNAPoints = 100;
	}
	
	public static void sync()
	{
	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
	DataOutputStream outputStream = new DataOutputStream(bos);

	try {
	outputStream.writeInt(maxDNAPoints);
	outputStream.writeInt(player.getDataWatcher().getWatchableObjectInt(DNAPOINTS_WATCHER));
	} catch (Exception ex) {
	ex.printStackTrace();
	}

	Packet250CustomPayload packet = new Packet250CustomPayload("tutchannel", bos.toByteArray());

	if (!player.worldObj.isRemote) {
	EntityPlayerMP player1 = (EntityPlayerMP) player;
	PacketDispatcher.sendPacketToPlayer(packet, (Player) player1);
	}
	}
	
	public static final void register(EntityPlayer player)
	{
	player.registerExtendedProperties(PlagueExtendedPlayer.EXT_PROP_NAME, new PlagueExtendedPlayer(player));
	}
	
	public static final PlagueExtendedPlayer get(EntityPlayer player)
	{
	return (PlagueExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		properties.setInteger("DefaultDNAPoints", this.player.getDataWatcher().getWatchableObjectInt(DNAPOINTS_WATCHER));
		properties.setInteger("MaxDNAPoints", this.maxDNAPoints);
		
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		
		this.player.getDataWatcher().updateObject(DNAPOINTS_WATCHER, properties.getInteger("DefaultDNAPoints"));
		this.maxDNAPoints = properties.getInteger("MaxDNAPoints");
		
		System.out.println("[PLAGUE PROPS] DNA Points Power from NBT: " + this.DNAPOINTS_WATCHER + " / " + this.maxDNAPoints);
	}

	@Override
	public void init(Entity entity, World world) {
		
	}
	
	public boolean consumeDNAPoints(int amount)
	{
		int dnaPoints = this.player.getDataWatcher().getWatchableObjectInt(DNAPOINTS_WATCHER);

		boolean sufficient = amount <= dnaPoints;
		dnaPoints -= (amount < dnaPoints ? amount : dnaPoints);

		this.player.getDataWatcher().updateObject(DNAPOINTS_WATCHER, dnaPoints);

		return sufficient;
	}

	public final void replenishDNAPoints()
	{
		this.player.getDataWatcher().updateObject(DNAPOINTS_WATCHER, this.maxDNAPoints);
	}

	public final int getCurrentDNAPoints()
	{
		return this.player.getDataWatcher().getWatchableObjectInt(DNAPOINTS_WATCHER);
	}
	
	public final int getMaxDNAPoints()
	{
		return this.maxDNAPoints;
	}
	public final void setCurrentDNAPoints(int amount)
	{
		this.player.getDataWatcher().updateObject(DNAPOINTS_WATCHER, (amount < this.maxDNAPoints ? amount : this.maxDNAPoints));
	}
	
	public void setMaxDNAPoints(int amount)
	{
	this.maxDNAPoints = (amount > 0 ? amount : 0);
	this.sync();
	}
}