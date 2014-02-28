package plague.client.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import plague.client.tileentity.TileEntityCircuitBuilder;
import plague.client.tileentity.TileEntitySyringeScannerBasic;
import plague.common.Plague;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCircuitBuilder extends Block{

@SideOnly(Side.CLIENT)
private Icon workbenchIconTop;
@SideOnly(Side.CLIENT)
private Icon workbenchIconFront;



public BlockCircuitBuilder(int par1)
{
super(par1, Material.wood);
}

@SideOnly(Side.CLIENT)
public Icon getIcon(int par1, int par2)
{
return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? Block.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
}

@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister par1IconRegister)
{
this.blockIcon = par1IconRegister.registerIcon(Plague.TEXTURE + "CircuitBuilder");
this.workbenchIconTop = par1IconRegister.registerIcon(Plague.TEXTURE + "CircuitBuilder");
this.workbenchIconFront = par1IconRegister.registerIcon(Plague.TEXTURE + "CircuitBuilder");
}

public TileEntity createNewTileEntity(World par1World)
{
	return new TileEntityCircuitBuilder();
}

public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
{
if (player.isSneaking()) {
	
}
if (!player.isSneaking())
{
player.addChatMessage("Not ready yet. :(");
return true;
}
else
{
return false;
}
}
}