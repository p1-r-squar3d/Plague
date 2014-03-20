package p1.plague;

import java.io.IOException;
import java.util.logging.Level;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import p1.plague.achievement.PlagueAchievements;
import p1.plague.block.PlagueBlocks;
import p1.plague.block.ore.PlagueOres;
import p1.plague.block.tileentity.PlagueTileEntities;
import p1.plague.ctab.TabPlagueBlocks;
import p1.plague.ctab.TabPlagueItems;
import p1.plague.event.EventSyringe;
import p1.plague.fluid.PlagueFluids;
import p1.plague.gui.GUIOverlayDNAPoints;
import p1.plague.handler.PlagueConnectionHandler;
import p1.plague.handler.PlagueGUIHandler;
import p1.plague.item.PlagueItems;
import p1.plague.key.PlagueKeybinds;
import p1.plague.packet.PlaguePacketHandler;
import p1.plague.recipe.PlagueRecipes;
import p1.plague.side.CommonProxy;
import p1.plague.worldgen.WorldGeneratorOre;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { Plague.CHANNEL }, packetHandler = PlaguePacketHandler.class)
@Mod(modid = Plague.ID, version = Plague.VERSION, name = Plague.NAME)
public class Plague {

	public final static String ID = "plague";
	public final static String NAME = "P l a g u e";
	public final static String VERSION = "Alpha 0.1.0";
	public final static String CHANNEL = "Plague";
	public final static String LOG = "Plague";
	public final static String RESOURCE = ID.toLowerCase() + "/textures/gui/";
	public final static String TEXTURE = ID.toLowerCase() + ":";

	public static CreativeTabs tabPlagueBlocks = new TabPlagueBlocks(CreativeTabs.getNextID(), "plagueClient");
	public static CreativeTabs tabPlagueItems = new TabPlagueItems(CreativeTabs.getNextID(), "plagueClient");

	@Instance(value = ID)
	public static Plague instance;

	@SidedProxy(clientSide = "p1.plague.side.ClientProxy", serverSide = "p1.plague.side.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent c) throws IOException {
		Configuration config = new Configuration(c.getSuggestedConfigurationFile());
		PlagueLog.init();
		PlagueLog.log(Level.INFO, "Starting " + LOG + " PRE-initialization event.");

		// ClientProxy.registerRenderInformation();

		PlagueItems.load(c);
		PlagueBlocks.load(c);
		PlagueOres.load(c);
		if (FMLCommonHandler.instance().getSide().isClient()) PlagueKeybinds.load(config);
		PlagueFluids.load();

		PlagueLog.log(Level.INFO, LOG + " PRE-initialization event was successful.");

	}

	@EventHandler
	public void init(FMLInitializationEvent e) {

		PlagueConfig pC = new PlagueConfig();
		
		PlagueLog.log(Level.INFO, "Starting " + LOG + " initialization event.");

		MinecraftForge.EVENT_BUS.register(new EventSyringe());

		GameRegistry.registerWorldGenerator(new WorldGeneratorOre());

		NetworkRegistry.instance().registerGuiHandler(Plague.instance, new PlagueGUIHandler());
		NetworkRegistry.instance().registerConnectionHandler(new PlagueConnectionHandler());

		PlagueTileEntities.load();
		PlagueRecipes.load();
		PlagueAchievements.load();

		PlagueLog.log(Level.INFO, LOG + " initialization event was successful.");

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		PlagueLog.log(Level.INFO, "Starting " + LOG + " POST-initialization event.");

		PlagueLog.log(Level.INFO, LOG + " POST-initialization event was successful.");
		PlagueLog.log(Level.INFO, "All Plague peripherals loaded successfully.");

	}
}
