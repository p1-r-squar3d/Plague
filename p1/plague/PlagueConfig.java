package p1.plague;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class PlagueConfig {

	public static int itemSyringeBasic;
	public static int itemSyringeBasic_Blood;
	public static int itemSyringeAdvanced_Blood;
	public static int itemUVScannerBasic;
	public static int itemBlockirusDeployerBasic;
	public static int itemSyringeAdvanced;
	public static int itemUVScannerAdvanced;
	public static int itemBlockirusDeployerAdvanced;

	public static int itemCylinder;
	public static int itemTesttube;
	public static int itemDropper;
	public static int itemGlassStrip;
	public static int itemGlassPanel;

	public static int itemRubber;

	public static int itemSyringePlunger;
	public static int itemSyringeNeedle;
	public static int itemSyringeTube;

	public static int itemSecretThing;
	public static int itemBattery;

	public static int blockBasicSyringeScanner;
	public static int blockAdvancedSyringeScanner;
	public static int blockAtrocious;
	public static int blockAtrociousFluid;
	public static int oreAluminium;

	public static int itemStubDNAMerger1;
	public static int itemStubDNAMerger2;
	public static int itemStubSyringeScanner;

	public static void loadConfig(FMLPreInitializationEvent c) {
		Configuration config = new Configuration(c.getSuggestedConfigurationFile());

		config.load();

		// item
		itemSyringeBasic = config.getItem("Basic Syringe", 9000).getInt();
		itemSyringeBasic_Blood = config.getItem("Basic Syringe Blood", 9001).getInt();
		itemUVScannerBasic = config.getItem("Basic UV Scanner", 9002).getInt();
		itemBlockirusDeployerBasic = config.getItem("blockirus_deploy.basic", 9003).getInt();
		itemSyringeAdvanced = config.getItem("syringe.advanced", 9004).getInt();
		itemUVScannerAdvanced = config.getItem("uvscanner.advanced", 9005).getInt();
		itemBlockirusDeployerAdvanced = config.getItem("blockirus_deploy.advanced", 9006).getInt();
		// item
		itemCylinder = config.getItem("cylinder", 9007).getInt();
		itemTesttube = config.getItem("testtube", 9008).getInt();
		itemDropper = config.getItem("dropper", 9009).getInt();
		itemGlassStrip = config.getItem("glass_strip", 9010).getInt();
		itemGlassPanel = config.getItem("glass_panel", 9011).getInt();

		itemSyringePlunger = config.getItem("syringe.plunger", 9012).getInt();
		itemSyringeNeedle = config.getItem("syringe.needle", 9013).getInt();
		itemSyringeTube = config.getItem("syringe.tube", 9014).getInt();

		itemRubber = config.getItem("rubber", 9015).getInt();

		itemSyringeAdvanced_Blood = config.getItem("syringe.advanced.blood", 9016).getInt();
		itemSecretThing = config.getItem("secreeeet", 9017).getInt();

		itemBattery = config.getItem("battery", 9018).getInt();
		// block
		blockBasicSyringeScanner = config.getBlock("Basic Syringe Scanner", 2000).getInt();
		blockAdvancedSyringeScanner = config.getBlock("Advanced Syringe Scanner", 2001).getInt();
		blockAtrocious = config.getBlock("Atrocious Blauwk", 2002).getInt();
		oreAluminium = config.getBlock("Aluminium Ore", 2003).getInt();
		itemStubDNAMerger1 = config.get("item", "itemStubDNAMerger1", 286).getInt();
		itemStubDNAMerger2 = config.get("item", "itemStubDNAMerger2", 287).getInt();
		itemStubSyringeScanner = config.get("item", "itemStubSyringeScanner", 288).getInt();
		config.save();
	}

}