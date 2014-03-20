package p1.plague.block.ore;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import p1.plague.Plague;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BlockOreAluminium extends Block {

	public BlockOreAluminium(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(100);
		setResistance(100);
		setUnlocalizedName(PlagueOres.UN[0]);
		setCreativeTab(Plague.tabPlagueBlocks);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Plague.TEXTURE + "aluminiumOre");
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return PlagueOres.oreAluminium.blockID;
	}
}
