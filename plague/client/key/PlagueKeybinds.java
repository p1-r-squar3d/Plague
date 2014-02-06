package plague.client.key;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import net.minecraft.client.settings.KeyBinding;

public class PlagueKeybinds {
	static KeyBinding[] keyDisposeFluid = {new KeyBinding("Dispose syringe fluid", Keyboard.KEY_G)};
    static boolean[] repeat = {false};
    
public static void load() {
	KeyBindingRegistry.registerKeyBinding(new KeyDisposeFluid(keyDisposeFluid, repeat));
   }
}
