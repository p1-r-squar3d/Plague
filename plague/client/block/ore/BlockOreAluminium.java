package plague.client.block.ore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import plague.common.Plague;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockOreAluminium extends Block{

	public BlockOreAluminium(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(1000);
		setResistance(1000);
		setUnlocalizedName("ore.aluminium");
		setCreativeTab(Plague.tabPlagueBlocks);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		blockIcon = iconRegister.registerIcon(Plague.TEXTURE + "syringe_scanner_bas_side");
	}
}
