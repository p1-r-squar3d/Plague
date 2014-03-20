package p1.plague.key;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.Configuration;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry;

public class PlagueKeybinds {
	public static final int DISPOSEFLUID = 0, OPENDATABASE = 1;
	private static final String[] desc = { "Dispose Syringe Fluid", "Open Database" };
	private static final int[] keyValues = { Keyboard.KEY_G, Keyboard.KEY_Y };
	public static final Map<Integer, Integer> PlagueKeyMap = new HashMap<Integer, Integer>();

	public static void load(Configuration config) {
		KeyBinding[] key = new KeyBinding[desc.length];
		boolean[] repeat = new boolean[desc.length];

		for (int i = 0; i < desc.length; ++i) {
			key[i] = new KeyBinding(desc[i], config.get(KeyDisposeFluid.label, desc[i], keyValues[i]).getInt());
			key[i] = new KeyBinding(desc[i], config.get(KeyOpenDatabase.label, desc[i], keyValues[i]).getInt());
			repeat[i] = false;
			PlagueKeyMap.put(key[i].keyCode, i);
		}
		KeyBindingRegistry.registerKeyBinding(new KeyDisposeFluid(key, repeat));
		KeyBindingRegistry.registerKeyBinding(new KeyOpenDatabase(key, repeat));
	}
}