package plague.common;

import java.io.IOException;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.MinecraftForge;
import plague.client.block.PlagueBlocks;
import plague.client.core.ClientProxy;
import plague.client.event.EventSyringe;
import plague.client.fluid.PlagueFluids;
import plague.client.gui.GUIOverlayDNAPoints;
import plague.client.gui.PlagueGUIHandler;
import plague.client.item.PlagueItems;
import plague.client.key.PlagueKeybinds;
import plague.client.pathogen.Pathogen;
import plague.client.recipe.PlagueRecipes;
import plague.client.tab.TabPlagueBlocks;
import plague.client.tab.TabPlagueItems;
import plague.client.tileentity.PlagueTileEntities;
import plague.common.core.CommonProxy;
import plague.common.misc.PathogenBacteria;
import plague.common.misc.PathogenFungus;
import plague.common.misc.PathogenParasite;
import plague.common.misc.PathogenVirus;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;


@NetworkMod(clientSideRequired = true,serverSideRequired = true, channels = {Plague.CHANNEL}, packetHandler = PlaguePacketHandler.class)
@Mod(modid = Plague.ID, version = Plague.VERSION, name = Plague.NAME)

public class Plague
{

public final static String ID = "plague";
public final static String NAME = "P l a g u e";
public final static String VERSION = "Alpha 0.1.0";
public final static String CHANNEL = "Plague";
public final static String LOG = "Plague";
public final static String RESOURCE = ID.toLowerCase() + "/textures/";
public final static String TEXTURE = ID.toLowerCase() + ":";
	  
public static Block blockImpure;
public static ItemFood foodImpure;

public static CreativeTabs tabPlagueBlocks = new TabPlagueBlocks(CreativeTabs.getNextID(),"plagueClient");
public static CreativeTabs tabPlagueItems = new TabPlagueItems(CreativeTabs.getNextID(), "plagueClient");

public static Pathogen bacteria = new PathogenBacteria(1);
public static Pathogen virus = new PathogenVirus(2);
public static Pathogen fungus = new PathogenFungus(3);
public static Pathogen parasite = new PathogenParasite(4);

@Instance(value = ID)
public static Plague instance;

@SidedProxy(clientSide = "plague.client.core.ClientProxy", serverSide = "plague.common.core.CommonProxy")
public static CommonProxy proxy;

@EventHandler
public void preInit(FMLPreInitializationEvent c)throws IOException
{
	PlagueLog.init();
	PlagueLog.log(Level.INFO, "Starting " + LOG + " PRE-initialization event.");
	
	ClientProxy.registerRenderInformation();
	
	PlagueItems.load(c);
	PlagueBlocks.load(c);
	PlagueFluids.load();
	
	PlagueLog.log(Level.INFO, LOG + " PRE-initialization event was successful.");
}

@EventHandler
public void init(FMLInitializationEvent e)
{
	PlagueLog.log(Level.INFO, "Starting " + LOG + " initialization event.");
	
	MinecraftForge.EVENT_BUS.register(new EventSyringe());
	NetworkRegistry.instance().registerGuiHandler(Plague.instance, new PlagueGUIHandler());
	NetworkRegistry.instance().registerConnectionHandler(new PlagueConnectionHandler());
	PlagueTileEntities.load();
	PlagueRecipes.load();
	PlagueKeybinds.load();
	
	PlagueLog.log(Level.INFO, LOG + " initialization event was successful.");
}

@EventHandler
public void postInit(FMLPostInitializationEvent e)
{
	PlagueLog.log(Level.INFO, "Starting " + LOG + " POST-initialization event.");
	
	MinecraftForge.EVENT_BUS.register(new GUIOverlayDNAPoints(Minecraft.getMinecraft()));
	
	PlagueLog.log(Level.INFO, LOG + " POST-initialization event was successful.");
	PlagueLog.log(Level.INFO, "All Plague peripherals loaded successfully.");
	
	Pathogen.printRegisteredPathogen(4);
}
}
