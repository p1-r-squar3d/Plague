package p1.plague.tick;

import net.minecraft.client.Minecraft;

public class TimeCatcher {
	
	public TimeCatcher() {
		
	}
	
	public static int getTime() {
		Minecraft mc = Minecraft.getMinecraft();
		int x = (int) mc.theWorld.getWorldTime();
		return x;
	}
}
