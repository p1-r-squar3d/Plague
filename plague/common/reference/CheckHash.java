package plague.common.reference;

import net.minecraft.client.Minecraft;

public class CheckHash {

public CheckHash() {
	
}
public static void checkFunc(String hash) {
	Minecraft mc = Minecraft.getMinecraft();
	String hH = "Function Check: ";
	System.out.println(hH + hash + " [TRUE]");
	
	mc.thePlayer.sendChatMessage(hH + hash + " [TRUE]");
}
}
