package plague.client.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import plague.client.item.metadata.ItemBloodSyringeAdvanced;
import plague.client.item.metadata.ItemBloodSyringeBasic;
import plague.client.item.metadata.ItemCircuitParts;
import plague.client.item.metadata.ItemRubber;
import plague.common.PlagueConfig;
import plague.common.assets.StringColor;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PlagueItems {
	
	/**item declarations**/
	
	public static Item itemSyringeBasic;
	public static Item itemSyringeSingleUse;
	public static Item itemUVScannerBasic;
	public static Item itemBlockirusDeployerBasic;
	public static Item itemBloodSyringeBasic;
	public static Item itemSyringeAdvanced;
	public static Item itemUVScannerAdvanced;
	public static Item itemBlockirusDeployerAdvanced;
	public static Item itemBloodSyringeAdvanced;
	public static Item itemCylinder;
	public static Item itemTesttube;
	public static Item itemDropper;
	public static Item itemGlassStrip;
	public static Item itemGlassPanel;
	public static Item itemRubber;
	public static Item itemSyringePlunger;
	public static Item itemSyringeNeedle;
	public static Item itemSyringeTube;
	public static Item itemWire;
	public static Item itemBattery;	
	public static Item itemImpure;
	public static Item itemSecretThing;
	public static Item itemCircuitParts;
	
	/**unlocalized names**/
	
	public static String UN_PREFIX = "item.";
	public static String UN_SUFFIX = ".name";
	
	public static String[] UN =  { "syringeBasic", "uvScannerBasic", "blockirusDep", "syringeAdv",
								   "uvScannerAdv", "blockirusDepAdv", "cylinder", "testTube", 
								   "dropper", "glassStrip", "glassPanel", "syringePlunger", "syringeNeedle", 
								   "syringeTube" 
								 };
	
@EventHandler	
public static void load(FMLPreInitializationEvent c) {
	
	PlagueConfig pC = new PlagueConfig();
	pC.loadConfig(c);
	
	itemSyringeBasic = new ItemSyringeBasic(pC.itemSyringeBasic, true);
	itemBloodSyringeBasic = new ItemBloodSyringeBasic(pC.itemSyringeBasic_Blood);
	itemBloodSyringeAdvanced = new ItemBloodSyringeAdvanced(pC.itemSyringeAdvanced_Blood);
	itemUVScannerBasic = new ItemUVScannerBasic(pC.itemUVScannerBasic);
	itemBlockirusDeployerBasic = new ItemBlockirusDeployerBasic(pC.itemBlockirusDeployerBasic);
	itemSyringeAdvanced = new ItemSyringeAdvanced(pC.itemSyringeAdvanced);
	itemUVScannerAdvanced = new ItemUVScannerAdvanced(pC.itemUVScannerAdvanced);
	itemBlockirusDeployerAdvanced = new ItemBlockirusDeployerAdvanced(pC.itemBlockirusDeployerAdvanced);
	itemCylinder = new ItemCylinder(pC.itemCylinder);
	itemTesttube = new ItemTesttube(pC.itemTesttube);
	itemDropper = new ItemDropper(pC.itemDropper);
	itemGlassStrip = new ItemGlassStrip(pC.itemGlassStrip);
	itemGlassPanel = new ItemGlassPanel(pC.itemGlassPanel);
	itemRubber = new ItemRubber(pC.itemRubber);
	itemSyringePlunger = new ItemSyringePlunger(pC.itemSyringePlunger);
	itemSyringeNeedle = new ItemSyringeNeedle(pC.itemSyringeNeedle);
	itemSyringeTube = new ItemSyringeTube(pC.itemSyringeTube);
	itemSecretThing = new ItemSecretThing(pC.itemSecretThing);
	itemBattery = new ItemBattery(pC.itemBattery, 1000);
	itemCircuitParts = new ItemCircuitParts(1001);
	
	GameRegistry.registerItem(itemSyringeBasic, "Syringe");
	GameRegistry.registerItem(itemUVScannerBasic, "UV Scanner");
	GameRegistry.registerItem(itemSyringeAdvanced, StringColor.light_cyan + "Syringe");
	GameRegistry.registerItem(itemUVScannerAdvanced, StringColor.light_cyan + "UV Scanner");
	GameRegistry.registerItem(itemBlockirusDeployerBasic, "Blockirus Deployer");
	GameRegistry.registerItem(itemBlockirusDeployerAdvanced, StringColor.light_cyan + "Blockirus Deployer");
	GameRegistry.registerItem(itemCylinder, "Cylinder");
	GameRegistry.registerItem(itemTesttube, "Test tube");
	GameRegistry.registerItem(itemDropper, "Dropper");
	GameRegistry.registerItem(itemGlassStrip, "Glass Strip");
	GameRegistry.registerItem(itemGlassPanel, "Glass Panel");
	GameRegistry.registerItem(itemSyringePlunger, "Syringe Plunger");
	GameRegistry.registerItem(itemSyringeNeedle, "Syringe Needle");
	GameRegistry.registerItem(itemSyringeTube, "Syringe Tube");
	GameRegistry.registerItem(itemBattery, "Battery");
	
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[0] + UN_SUFFIX, "Syringe [-/-]");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[1] + UN_SUFFIX, "Basic UV Scanner");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[2] + UN_SUFFIX, "Basic Blockirus Deployer");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[3] + UN_SUFFIX, "Syringe [-/-/-/-]");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[4] + UN_SUFFIX, "Advanced UV Scanner");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[5] + UN_SUFFIX, "Advanced Blockirus Deployer");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[6] + UN_SUFFIX, "Cylinder");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[7] + UN_SUFFIX, "Test tube");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[8] + UN_SUFFIX, "Dropper");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[9] + UN_SUFFIX, "Glass Strip");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[10] + UN_SUFFIX, "Glass Panel");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[11] + UN_SUFFIX, "Syringe Plunger");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[12] + UN_SUFFIX, "Syringe Needle");
	LanguageRegistry.instance().addStringLocalization(UN_PREFIX + UN[13] + UN_SUFFIX, "Syringe Tube");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.blaze.name", "Syringe"+StringColor.dark_red+" [b/01]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.caveSpider.name", "Syringe"+StringColor.dark_red+" [b/02]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.creeper.name", "Syringe"+StringColor.dark_red+" [b/03]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.enderman.name", "Syringe"+StringColor.light_purple+" [b/04]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.ghast.name", "Syringe"+StringColor.dark_red+" [b/05]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.ironGolem.name", "Syringe"+StringColor.light_green+" [b/06]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.pigZombie.name", "Syringe"+StringColor.dark_red+" [b/07]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.silverfish.name", "Syringe"+StringColor.dark_red+" [b/08]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.skeleton.name", "Syringe"+StringColor.dark_red+" [b/09]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.slime.name", "Syringe"+StringColor.dark_red+" [b/10]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.snowMan.name", "Syringe"+StringColor.light_green+" [b/11]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.spider.name", "Syringe"+StringColor.dark_red+" [b/12]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.witch.name", "Syringe"+StringColor.dark_red+" [b/13]");		
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.bat.name", "Syringe"+StringColor.dark_cyan+" [b/14]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.chicken.name", "Syringe"+StringColor.dark_cyan+" [b/15]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.cow.name", "Syringe"+StringColor.dark_cyan+" [b/16]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.horse.name", "Syringe"+StringColor.dark_cyan+" [b/17]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.mooshroom.name", "Syringe"+StringColor.dark_cyan+" [b/18]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.ocelot.name", "Syringe"+StringColor.dark_cyan+" [b/19]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.pig.name", "Syringe"+StringColor.dark_cyan+" [b/20]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.sheep.name", "Syringe"+StringColor.dark_cyan+" [b/21]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.squid.name", "Syringe"+StringColor.dark_cyan+" [b/22]");
	LanguageRegistry.instance().addStringLocalization("item.metadataBloodSyringe.villager.name", "Syringe"+StringColor.dark_yellow+" [b/23]");
	LanguageRegistry.instance().addStringLocalization("item.rubber.rubberRaw.name", StringColor.DEFAULT + "Raw Rubber");
	LanguageRegistry.instance().addStringLocalization("item.rubber.rubberSynthetic.name", StringColor.light_cyan + "Synthetic Rubber");
	LanguageRegistry.instance().addStringLocalization("item.rubber.rubberCompressed.name", StringColor.light_yellow + "Compressed Rubber");
	LanguageRegistry.instance().addStringLocalization("item.rubber.rubberMelted.name", StringColor.dark_black + "Melted Rubber");
	LanguageRegistry.instance().addStringLocalization("item.circuitParts.pfCapacitor.name", "Plastic Film Capacitor");
	LanguageRegistry.instance().addStringLocalization("item.circuitParts.cCapacitor.name", "Ceramic Capacitor");
	LanguageRegistry.instance().addStringLocalization("item.circuitParts.eCapacitor.name", "Electrolytic Capacitor");
	LanguageRegistry.instance().addStringLocalization("item.circuitParts.PICircuit.name", "Packaged Integrated Circuit");
	LanguageRegistry.instance().addStringLocalization("item.circuitParts.resistor.name", "Resistor");
	LanguageRegistry.instance().addStringLocalization("item.circuitParts.blankCircuitBoard.name", "Blank Circuit Board");
	
	
}
}
