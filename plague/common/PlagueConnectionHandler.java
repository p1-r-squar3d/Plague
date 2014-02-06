package plague.common;

import plague.common.assets.StringColor;
import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class PlagueConnectionHandler implements IConnectionHandler {
	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {

	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {

	}

	@Override
	public void connectionOpened(NetHandler netClientHandler,
			MinecraftServer server, INetworkManager manager) {

	}

	@Override
	public void connectionClosed(INetworkManager manager) {

	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) {
		 Minecraft.getMinecraft().thePlayer.addChatMessage(StringColor.dark_purple + "Welcome back, " + StringColor.light_cyan + Minecraft.getMinecraft().thePlayer.username.toString() + StringColor.dark_purple + "!");
		 Minecraft.getMinecraft().thePlayer.addChatMessage("Intel: ["+StringColor.light_yellow+Minecraft.getSystemTime() * 0.001+"s"+StringColor.DEFAULT+"]");
		 Minecraft.getMinecraft().thePlayer.addChatMessage("Infection Rate: 0%");
         Minecraft.getMinecraft().thePlayer.addChatMessage("Infected: 0");
         Minecraft.getMinecraft().thePlayer.addChatMessage("Deaths: 0");

	}

}
