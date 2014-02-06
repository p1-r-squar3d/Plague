package plague.client.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import plague.client.item.metadata.ItemBloodSyringeAdvanced;
import plague.client.item.metadata.ItemBloodSyringeBasic;
import plague.client.item.metadata.ItemRubber;
import plague.common.PlagueConfig;
import plague.common.assets.StringColor;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PlagueItems {
	
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
	
	itemBattery = new ItemBattery(pC.itemBattery);
	
	LanguageRegistry.addName(itemSyringeBasic, "Syringe [-/-]");
	LanguageRegistry.addName(itemUVScannerBasic, "UV Scanner");
	LanguageRegistry.addName(itemSyringeAdvanced, StringColor.light_cyan + "Syringe");
	LanguageRegistry.addName(itemUVScannerAdvanced, StringColor.light_cyan + "UV Scanner");
	LanguageRegistry.addName(itemBlockirusDeployerBasic, "Blockirus Deployer");
	LanguageRegistry.addName(itemBlockirusDeployerAdvanced, StringColor.light_cyan + "Blockirus Deployer");
	
	LanguageRegistry.addName(itemCylinder, "Cylinder");
	LanguageRegistry.addName(itemTesttube, "Test tube");
	LanguageRegistry.addName(itemDropper, "Dropper");
	LanguageRegistry.addName(itemGlassStrip, "Glass Strip");
	
	LanguageRegistry.addName(itemSyringePlunger, "Syringe Plunger");
	LanguageRegistry.addName(itemSyringeNeedle, "Syringe Needle");
	LanguageRegistry.addName(itemSyringeTube, "Syringe Tube");
	
	LanguageRegistry.addName(itemSecretThing, "IMMMAAAA SECRRRRREEEEEEEEEET.... DONT RIGHT CLICK");
	LanguageRegistry.addName(itemBattery, "Battery");
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
	
	LanguageRegistry.instance().addStringLocalization("item.rubber.rubberRaw.name", StringColor.DEFAULT + "Rubber");
	LanguageRegistry.instance().addStringLocalization("item.rubber.rubberSynthetic.name", StringColor.light_cyan + "Rubber");
	LanguageRegistry.instance().addStringLocalization("item.rubber.rubberCompressed.name", StringColor.light_yellow + "Rubber");
	LanguageRegistry.instance().addStringLocalization("item.rubber.rubberMelted.name", StringColor.dark_black + "Rubber");
	
	
}
}
