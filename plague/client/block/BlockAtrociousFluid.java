package plague.client.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import plague.client.fluid.PlagueFluids;
import plague.common.Plague;

public class BlockAtrociousFluid extends BlockFluidClassic{

public BlockAtrociousFluid(int id) {
		super(id, PlagueFluids.fluidAtrocious, Material.water);
		setCreativeTab(Plague.tabPlagueBlocks);
		setUnlocalizedName("BlockAtrociousFluid");
		setDensity(10);
}

public void registerIcons(IconRegister iconRegister) {
	blockIcon = iconRegister.registerIcon(Plague.TEXTURE + "atrocious_fluid");
	}
}