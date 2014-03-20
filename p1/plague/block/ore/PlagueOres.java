package p1.plague.block.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import p1.plague.PlagueConfig;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PlagueOres {

	public static Block oreAluminium;
	public static Block oreSiliconium;

	public static String UN_PREFIX = "tile.";
	public static String UN_SUFFIX = ".name";

	public static String[] UN = { "oreAluminium" };

	@EventHandler
	public static void load(FMLPreInitializationEvent c) {

		PlagueConfig pC = new PlagueConfig();
		pC.loadConfig(c);

		oreAluminium = new BlockOreAluminium(pC.oreAluminium, Material.rock);

		GameRegistry.registerBlock(oreAluminium, "Aluminium Ore");
		LanguageRegistry.instance().addStringLocalization(
				UN_PREFIX + UN[0] + UN_SUFFIX, "Aluminium Ore");
	}
}
