package p1.plague.packet;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.network.packet.Packet250CustomPayload;

public class PlaguePacket {
	public static Packet250CustomPayload getPacket(byte key) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(2);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeByte(PlaguePacketHandler.PACKET_KEY_PRESS);
			outputStream.writeByte(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Packet250CustomPayload("PlaguePacketHandler", bos.toByteArray());
	}
}