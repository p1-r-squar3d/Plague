package p1.plague.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import p1.plague.Plague;
import p1.plague.PlagueConfig;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PlagueBlocks {

	public static Block blockSyringeScannerBasicIdle;
	public static Block blockSyringeScannerBasicActive;
	public static Block blockSyringeScannerAdvanced;
	public static Block blockAtrocious;
	public static Block blockDNAMergerBasicIdle;
	public static Block blockDNAMergerBasicActive;
	public static Block blockCombustionChargerBasicIdle;
	public static Block blockCombustionChargerBasicActive;
	public static Block blockCircuitBuilder;

	public static String UN_PREFIX = "tile.";
	public static String UN_SUFFIX = ".name";

	public static String[] UN = { "" };

	@EventHandler
	public static void load(FMLPreInitializationEvent c) {

		PlagueConfig pC = new PlagueConfig();
		pC.loadConfig(c);

		blockSyringeScannerAdvanced = new BlockSyringeScannerAdvanced(pC.blockAdvancedSyringeScanner, Material.iron);
		blockAtrocious = new BlockAtrocious(pC.blockAtrocious, Material.grass);
		blockSyringeScannerBasicIdle = new BlockSyringeScannerBasic(1041, false).setUnlocalizedName("scanner_idle").setHardness(3.7F).setCreativeTab(Plague.tabPlagueBlocks);
		blockSyringeScannerBasicActive = new BlockSyringeScannerBasic(1042, true).setUnlocalizedName("scanner_active").setHardness(3.7F).setLightValue(0.9F);
		blockDNAMergerBasicIdle = new BlockDNAMergerBasic(1043, false).setUnlocalizedName("merger_idle").setHardness(3.7F).setCreativeTab(Plague.tabPlagueBlocks);
		blockDNAMergerBasicActive = new BlockDNAMergerBasic(1044, true).setUnlocalizedName("merger_active").setHardness(3.7F).setLightValue(0.9F);
		blockCombustionChargerBasicIdle = new BlockCombustionChargerBasic(1046, false).setUnlocalizedName("combacharger_idle").setHardness(3.7F).setCreativeTab(Plague.tabPlagueBlocks);
		blockCombustionChargerBasicActive = new BlockCombustionChargerBasic(1047, true).setUnlocalizedName("combacharger_active").setHardness(3.7F).setLightValue(0.9F);

		blockCircuitBuilder = new BlockCircuitBuilder(1045).setUnlocalizedName("circuit_builder").setCreativeTab(Plague.tabPlagueBlocks);

		GameRegistry.registerBlock(blockSyringeScannerAdvanced, "syringe_scanner.advanced.idle");
		GameRegistry.registerBlock(blockAtrocious, TooltipBlock.class, "Some Block");
		GameRegistry.registerBlock(blockSyringeScannerBasicIdle, "syringe_scanner.idle");
		GameRegistry.registerBlock(blockSyringeScannerBasicActive, "syringe_scanner.active");
		GameRegistry.registerBlock(blockDNAMergerBasicIdle, "merger.idle");
		GameRegistry.registerBlock(blockDNAMergerBasicActive, "merger.active");
		GameRegistry.registerBlock(blockCircuitBuilder, "circuit.builder");

		LanguageRegistry.instance().addStringLocalization("container.macerator", "Basic Syringe Scanner");
		LanguageRegistry.instance().addStringLocalization("container.dnamerger", "Basic DNA Merger");

		LanguageRegistry.instance().addStringLocalization("tile.scanner_idle.name", "Basic Syringe Scanner");
		LanguageRegistry.instance().addStringLocalization("tile.merger_idle.name", "Basic DNA Merger");

		LanguageRegistry.instance().addStringLocalization("tile.circuit_builder.name", "Circuit Builder");

	}
}
