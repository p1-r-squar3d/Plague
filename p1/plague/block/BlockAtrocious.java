package p1.plague.block;

import java.util.Random;

import p1.plague.Plague;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;

public class BlockAtrocious extends Block {

	public BlockAtrocious(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(100);
		setResistance(100);
		setUnlocalizedName("block.atrocious");
		setCreativeTab(Plague.tabPlagueBlocks);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		if (!par1World.isRemote) {
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4
					&& par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2) {
				par1World.setBlock(par2, par3, par4,
						PlagueBlocks.blockAtrocious.blockID);
			} else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9) {
				for (int l = 0; l < 4; ++l) {
					int i1 = par2 + par5Random.nextInt(3) - 1;
					int j1 = par3 + par5Random.nextInt(5) - 3;
					int k1 = par4 + par5Random.nextInt(3) - 1;
					int l1 = par1World.getBlockId(i1, j1 + 1, k1);

					if (par1World.getBlockId(i1, j1, k1) == Block.grass.blockID
							&& par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4
							&& par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						par1World.setBlock(i1, j1, k1,
								PlagueBlocks.blockAtrocious.blockID);
					}
				}
			}
		}
	}
}