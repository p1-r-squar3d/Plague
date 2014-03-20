package p1.plague.item.metadata;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import p1.plague.Plague;
import p1.plague.item.PlagueItems;
import p1.reference.StringColor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemCircuitParts extends Item
{

/** List of item names */
public static final String[] itemMetaNames = new String[] {"pfCapacitor", "cCapacitor", "eCapacitor","PICircuit", "resistor","blankCircuitBoard"};
public static final String[] items= new String[] {"pfCapacitor", "cCapacitor", "eCapacitor", "PICircuit", "resistor","blankCircuitBoard"};

@SideOnly(Side.CLIENT)
private Icon[] icons;

public ItemCircuitParts(int par1)
{
         super(par1);
         setHasSubtypes(true);
         setMaxDamage(0);
         setMaxStackSize(64);
         setUnlocalizedName("circuitParts");
         setCreativeTab(Plague.tabPlagueItems);
}
public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B)
{
}

public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {

	if(!par3World.isRemote)
    {
           par3World.setBlock(par4, par5, par6, Block.sandStone.blockID);
           return true;
    }
    else
           return false;
}
@SideOnly(Side.CLIENT)
public Icon getIconFromDamage(int par1)
{
	//item number - 1
         int j = MathHelper.clamp_int(par1, 0, 5);
         return this.icons[j];
}

public String getUnlocalizedName(ItemStack par1ItemStack)
{
	//item number - 1
         int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 5);
         return super.getUnlocalizedName() + "." + itemMetaNames[i];
}

@SideOnly(Side.CLIENT)
public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
{
         for (int j = 0; j < 6; ++j)
         {
                 par3List.add(new ItemStack(par1, 1, j));
         }
}

@Override
public void registerIcons(IconRegister par1IconRegister)
{
         this.icons = new Icon[items.length];
        
         for (int i = 0; i < items.length; ++i)
         {
                 this.icons[i] = par1IconRegister.registerIcon(Plague.TEXTURE + items[i]);
         }
}
}