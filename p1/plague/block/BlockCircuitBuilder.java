package p1.plague.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import p1.plague.Plague;
import p1.plague.block.tileentity.TileEntityCircuitBuilder;
import p1.plague.block.tileentity.TileEntitySyringeScannerBasic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCircuitBuilder extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private Icon workbenchIconTop;
	@SideOnly(Side.CLIENT)
	private Icon workbenchIconFront;

	public BlockCircuitBuilder(int par1) {
		super(par1, Material.wood);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? Block.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(Plague.TEXTURE + "CircuitBuilder");
		this.workbenchIconTop = par1IconRegister.registerIcon(Plague.TEXTURE + "CircuitBuilder");
		this.workbenchIconFront = par1IconRegister.registerIcon(Plague.TEXTURE + "CircuitBuilder");
	}

	public TileEntity createNewTileEntity(World par1World) {
		return new TileEntityCircuitBuilder();
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int var6, float var7, float var8, float var9) {
		
		if (par1World.isRemote) {
			return true;
		}
		else if (!par5EntityPlayer.isSneaking()) {
			TileEntityCircuitBuilder var10 = (TileEntityCircuitBuilder) par1World.getBlockTileEntity(par2, par3, par4);
			if (var10 != null) {
				par5EntityPlayer.openGui(Plague.instance, 10, par1World, par2, par3, par4);
			}
			return true;
		}
		else {
			return false;
		}
	}
}