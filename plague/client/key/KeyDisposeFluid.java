package plague.client.key;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import plague.client.item.metadata.ItemBloodSyringeBasic;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyDisposeFluid extends KeyHandler
{
         private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
        
         public KeyDisposeFluid(KeyBinding[] keyBindings, boolean[] repeatings)
         {
                 super(keyBindings, repeatings);
         }
         @Override
         public String getLabel()
         {
                 return "Dispose syringe fluid";
         }
         @Override
         public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
         {
        	 Minecraft mc = Minecraft.getMinecraft();
        	 
        	 if (mc.currentScreen == null) {
        		 ItemBloodSyringeBasic.keyPressed_keyDisposeFluid = true;  
        	 }  
         }
         @Override
         public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
         {
        	 ItemBloodSyringeBasic.keyPressed_keyDisposeFluid = false;
         }
         @Override
         public EnumSet<TickType> ticks()
         {
                 return tickTypes;
         }
}