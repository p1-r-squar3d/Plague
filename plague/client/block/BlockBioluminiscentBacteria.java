/**package plague.client.block;

import java.util.Random;

import plague.common.Plague;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBioluminiscentBacteria extends BlockOre{

	public BlockBioluminiscentBacteria(int par1, Material par2Material) {
		super(par1);
		setCreativeTab(Plague.tabPlagueBlocks);
		setStepSound(soundStoneFootstep);
		setHardness(2.0F);
		setResistance(2.0F);
		setLightValue(1.0F);
	}
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == PlagueOres.blockBioluminiscentBacteria.blockID ? Item.coal.itemID : this.blockID;
    }

}
**/