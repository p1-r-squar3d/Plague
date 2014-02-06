package plague.common;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class PlagueConfig
{

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
	
	public static int itemStubDNAMerger1;
	public static int itemStubDNAMerger2;
	public static int itemStubSyringeScanner;
	
public static void loadConfig(FMLPreInitializationEvent c)
{
	Configuration config = new Configuration(c.getSuggestedConfigurationFile()); //Gets the file

	config.load();
	
//item
	itemSyringeBasic = config.getItem("Basic Syringe", 6000).getInt();
	itemSyringeBasic_Blood = config.getItem("Basic Syringe Blood", 6001).getInt();
	itemUVScannerBasic = config.getItem("Basic UV Scanner", 6002).getInt();
	itemBlockirusDeployerBasic = config.getItem("blockirus_deploy.basic", 6003).getInt();	
	itemSyringeAdvanced = config.getItem("syringe.advanced", 6004).getInt();
	itemUVScannerAdvanced = config.getItem("uvscanner.advanced", 6005).getInt();
	itemBlockirusDeployerAdvanced = config.getItem("blockirus_deploy.advanced", 6006).getInt();	
//item
	itemCylinder = config.getItem("cylinder", 6007).getInt();
	itemTesttube = config.getItem("testtube", 6008).getInt();
	itemDropper = config.getItem("dropper", 6009).getInt();
	itemGlassStrip = config.getItem("glass_strip", 6010).getInt();
	itemGlassPanel = config.getItem("glass_panel", 6011).getInt();
	
	itemSyringePlunger = config.getItem("syringe.plunger", 6012).getInt();
	itemSyringeNeedle = config.getItem("syringe.needle", 6013).getInt();
	itemSyringeTube = config.getItem("syringe.tube", 6014).getInt();
	
	itemRubber = config.getItem("rubber", 6015).getInt();
	
	itemSyringeAdvanced_Blood = config.getItem("syringe.advanced.blood", 6016).getInt();
	itemSecretThing = config.getItem("secreeeet", 6017).getInt();
	
	itemBattery = config.getItem("battery", 6018).getInt();
//block	
	blockBasicSyringeScanner = config.getBlock("Basic Syringe Scanner", 2000).getInt();
	blockAdvancedSyringeScanner = config.getBlock("Advanced Syringe Scanner", 2001).getInt();
	blockAtrocious = config.getBlock("Atrocious Blauwk", 2002).getInt();
	
	itemStubDNAMerger1 = config.get("item", "itemStubDNAMerger1", 286).getInt();
	itemStubDNAMerger2 = config.get("item", "itemStubDNAMerger2", 287).getInt();
	itemStubSyringeScanner = config.get("item", "itemStubSyringeScanner", 288).getInt();
	config.save();
}


}