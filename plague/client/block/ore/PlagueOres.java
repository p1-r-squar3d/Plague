package plague.client.block.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import plague.common.PlagueConfig;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PlagueOres {

public static Block oreAluminium;
public static Block oreSiliconium;

@EventHandler
public static void load(FMLPreInitializationEvent c) {
	
	PlagueConfig pC = new PlagueConfig();
	pC.loadConfig(c);
	
	oreAluminium = new BlockOreAluminium(pC.oreAluminium, Material.rock);
	
	GameRegistry.registerBlock(oreAluminium, "ore.aluminium");
	
	LanguageRegistry.instance().addStringLocalization("ore.aluminium", "Aluminium Ore");
}
}
