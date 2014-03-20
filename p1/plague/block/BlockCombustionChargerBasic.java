package p1.plague.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import p1.plague.Plague;
import p1.plague.block.tileentity.TileEntityCombustionChargerBasic;
import p1.plague.block.tileentity.TileEntitySyringeScannerBasic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCombustionChargerBasic extends BlockContainer {

	private final Random syringeScannerRand = new Random();

	private final boolean isActive;

	private static boolean keepSyringeScannerInventory;
	@SideOnly(Side.CLIENT)
	private Icon blockIconFront;
	private Icon blockIconTop;
	private Icon blockIconSide;
	private Icon blockIconBottom;

	public BlockCombustionChargerBasic(int id, boolean isActive) {
		super(id, Material.rock);

		this.isActive = isActive;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Plague.TEXTURE + "syringe_scanner_bas_side");
		this.blockIconFront = iconRegister.registerIcon(Plague.TEXTURE + (this.isActive ? "syringe_scanner_bas_front_lit" : "syringe_scanner_bas_front_idle"));
		this.blockIconTop = iconRegister.registerIcon(Plague.TEXTURE + "syringe_scanner_bas_top");// top
		this.blockIconBottom = iconRegister.registerIcon(Plague.TEXTURE + "syringe_scanner_bas_bottom");// bottom
	}

	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2) {
		return par1 == 0 ? this.blockIconBottom : par1 == 1 ? this.blockIconTop : (par1 != par2 ? this.blockIcon : this.blockIconFront);
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3) {
		return PlagueBlocks.blockCombustionChargerBasicIdle.blockID;
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}

	/**
	 * set a blocks direction
	 */
	private void setDefaultDirection(World par1World, int par2, int par3, int par4) {
		if (!par1World.isRemote) {
			int l = par1World.getBlockId(par2, par3, par4 - 1);
			int i1 = par1World.getBlockId(par2, par3, par4 + 1);
			int j1 = par1World.getBlockId(par2 - 1, par3, par4);
			int k1 = par1World.getBlockId(par2 + 1, par3, par4);
			byte b0 = 3;

			if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1]) {
				b0 = 3;
			}

			if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l]) {
				b0 = 2;
			}

			if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1]) {
				b0 = 5;
			}

			if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1]) {
				b0 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		}
		else if (!par5EntityPlayer.isSneaking()) {
			TileEntityCombustionChargerBasic var10 = (TileEntityCombustionChargerBasic) par1World.getBlockTileEntity(par2, par3, par4);
			if (var10 != null) {
				par5EntityPlayer.openGui(Plague.instance, 8, par1World, par2, par3, par4);
			}
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Update which block ID the furnace is using depending on whether or not it
	 * is burning
	 */
	public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4) {
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
		keepSyringeScannerInventory = true;

		if (par0) {
			par1World.setBlock(par2, par3, par4, PlagueBlocks.blockCombustionChargerBasicActive.blockID);
		}
		else {
			par1World.setBlock(par2, par3, par4, PlagueBlocks.blockCombustionChargerBasicIdle.blockID);
		}

		keepSyringeScannerInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

		if (tileentity != null) {
			tileentity.validate();
			par1World.setBlockTileEntity(par2, par3, par4, tileentity);
		}
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World par1World) {
		return new TileEntitySyringeScannerBasic();
	}

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if (l == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}

		if (l == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}

		if (l == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}

		if (par6ItemStack.hasDisplayName()) {
			((TileEntitySyringeScannerBasic) par1World.getBlockTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
		}
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
		if (!keepSyringeScannerInventory) {
			TileEntitySyringeScannerBasic TileEntitySyringeScannerBasic = (TileEntitySyringeScannerBasic) par1World.getBlockTileEntity(par2, par3, par4);

			if (TileEntitySyringeScannerBasic != null) {
				for (int j1 = 0; j1 < TileEntitySyringeScannerBasic.getSizeInventory(); ++j1) {
					ItemStack itemstack = TileEntitySyringeScannerBasic.getStackInSlot(j1);

					if (itemstack != null) {
						float f = this.syringeScannerRand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.syringeScannerRand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.syringeScannerRand.nextFloat() * 0.8F + 0.1F;

						while (itemstack.stackSize > 0) {
							int k1 = this.syringeScannerRand.nextInt(21) + 10;

							if (k1 > itemstack.stackSize) {
								k1 = itemstack.stackSize;
							}

							itemstack.stackSize -= k1;
							EntityItem entityitem = new EntityItem(par1World, (double) ((float) par2 + f), (double) ((float) par3 + f1), (double) ((float) par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}

							float f3 = 0.05F;
							entityitem.motionX = (double) ((float) this.syringeScannerRand.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.syringeScannerRand.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double) ((float) this.syringeScannerRand.nextGaussian() * f3);
							par1World.spawnEntityInWorld(entityitem);
						}
					}
				}

				par1World.func_96440_m(par2, par3, par4, par5);
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	/**
	 * If this returns true, then comparators facing away from this block will
	 * use the value from getComparatorInputOverride instead of the actual
	 * redstone signal strength.
	 */
	public boolean hasComparatorInputOverride() {
		return true;
	}

	/**
	 * If hasComparatorInputOverride returns true, the return value from this is
	 * used instead of the redstone signal strength when this block inputs to a
	 * comparator.
	 */
	public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5) {
		return Container.calcRedstoneFromInventory((IInventory) par1World.getBlockTileEntity(par2, par3, par4));
	}

	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return PlagueBlocks.blockSyringeScannerBasicIdle.blockID;
	}

}
