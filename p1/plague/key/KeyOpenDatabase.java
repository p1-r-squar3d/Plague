package p1.plague.key;

import java.util.EnumSet;

import p1.plague.packet.PlaguePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyOpenDatabase extends KeyHandler {

	public static String label = "Open Database";
	public static boolean keyPressedDatabase = false;
	private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);

	public KeyOpenDatabase(KeyBinding[] keyBindings, boolean[] repeatings) {
		super(keyBindings, repeatings);
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		Minecraft mc = Minecraft.getMinecraft();

		EntityClientPlayerMP player = FMLClientHandler.instance().getClient().thePlayer;
		player.sendQueue.addToSendQueue(PlaguePacket.getPacket((byte) PlagueKeybinds.PlagueKeyMap.get(kb.keyCode).byteValue()));

		if (mc.currentScreen.equals(null)) {
			this.keyPressedDatabase = true;
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		this.keyPressedDatabase = false;
	}

	@Override
	public EnumSet<TickType> ticks() {
		return tickTypes;
	}
}
