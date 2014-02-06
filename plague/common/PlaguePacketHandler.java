package plague.common;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PlaguePacketHandler implements IPacketHandler

{

public PlaguePacketHandler() {
	
}

@Override
public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
{

if (packet.channel.equals(Plague.CHANNEL)) {
handleExtendedProperties(packet, player);
}
}

private void handleExtendedProperties(Packet250CustomPayload packet, Player player)
{
DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
PlagueExtendedPlayer props = PlagueExtendedPlayer.get((EntityPlayer) player);


try {
props.setMaxDNAPoints(inputStream.readInt());
props.setCurrentDNAPoints(inputStream.readInt());
} catch (IOException e) {
e.printStackTrace();
return;
}

System.out.println("[PLAGUE PACKET] DNA Points from packet: " + props.getCurrentDNAPoints() + "/" + props.getMaxDNAPoints());
}
}