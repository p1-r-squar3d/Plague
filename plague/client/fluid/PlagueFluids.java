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
	
public static Fluid fluidAtrocious;
public static int idFluidAtrocious = 1007;
public static Block blockAtrociousFluid;

public static Material materialAtrocious;	
public static void load() {
	fluidAtrocious = new Fluid("atrocious").setBlockID(1007);
	FluidRegistry.registerFluid(fluidAtrocious);
	materialAtrocious = new Material(MapColor.dirtColor);
	
	blockAtrociousFluid = new BlockAtrociousFluid(PlagueFluids.idFluidAtrocious);
	LanguageRegistry.instance().addStringLocalization("tile.BlockAtrociousFluid.name", "Atrocious Fluid");
	GameRegistry.registerBlock(blockAtrociousFluid, StringColor.dark_red + "Atrocious Fluid");
}
}
