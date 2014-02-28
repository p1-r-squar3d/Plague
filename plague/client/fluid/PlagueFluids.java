package plague.client.fluid;

import plague.client.block.BlockAtrociousFluid;
import plague.common.assets.StringColor;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PlagueFluids {
	
public static int fluidId = 1000;
public static Fluid fluidAtrocious;
public static Block fluidBlockAtrocious;

public static void load() {
	fluidAtrocious = new Fluid("fluidname").setBlockID(fluidId);
	FluidRegistry.registerFluid(fluidAtrocious);
	
	fluidBlockAtrocious = new BlockAtrociousFluid(fluidId, fluidAtrocious, Material.water);
	GameRegistry.registerBlock(fluidBlockAtrocious, "Atrocious Fluid");
}
}