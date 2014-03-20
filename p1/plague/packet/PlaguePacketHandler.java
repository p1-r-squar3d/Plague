package p1.plague.packet;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import p1.plague.key.KeyDisposeFluid;
import p1.plague.key.KeyOpenDatabase;
import p1.plague.key.PlagueKeybinds;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PlaguePacketHandler implements IPacketHandler {
	/** Packet IDs */
	public static final byte PACKET_KEY_PRESS = 1;

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		byte packetType;
		try {
			packetType = inputStream.readByte();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		switch (packetType) {
			case PACKET_KEY_PRESS:
				handlePacketKeyPress(packet, (EntityPlayer) player, inputStream);
				break;
		}
	}
	/**
	 * Handles packet pertaining to keybind presses
	 * @author p1-r_squar3d
	 */
	private void handlePacketKeyPress(Packet250CustomPayload packet, EntityPlayer player, DataInputStream inputStream) {
		byte key;
		try {
			key = inputStream.readByte();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		switch (key) {
			case PlagueKeybinds.DISPOSEFLUID:
				KeyDisposeFluid.keyPressedDispose = true;
				break;
			case PlagueKeybinds.OPENDATABASE:
				KeyOpenDatabase.keyPressedDatabase = true;
		}
	}
}