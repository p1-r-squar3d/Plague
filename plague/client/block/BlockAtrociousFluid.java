package plague.client.block;

import plague.common.Plague;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAtrociousFluid extends BlockFluidClassic {

        @SideOnly(Side.CLIENT)
        protected Icon stillIcon;
        @SideOnly(Side.CLIENT)
        protected Icon flowingIcon;
        
        public BlockAtrociousFluid(int id, Fluid fluid, Material material) {
                super(id, fluid, material);
                setUnlocalizedName("atrocious.fluid");
                setCreativeTab(Plague.tabPlagueBlocks);
        }
        
        @Override
        public Icon getIcon(int side, int meta) {
                return (side == 0 || side == 1)? stillIcon : flowingIcon;
        }
        @SideOnly(Side.CLIENT)
        @Override
        public void registerIcons(IconRegister register) {
                stillIcon = register.registerIcon("modid:fluidStill");
                flowingIcon = register.registerIcon("modid:fluidFlowing");
        }
        
        @Override
        public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
                if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
                return super.canDisplace(world, x, y, z);
        }
        
        @Override
        public boolean displaceIfPossible(World world, int x, int y, int z) {
                if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
                return super.displaceIfPossible(world, x, y, z);
        }
        
}