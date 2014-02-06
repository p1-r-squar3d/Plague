package plague.client.item.metadata;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import plague.common.Plague;
import plague.common.assets.StringColor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemRubber extends Item
{

/** List of item names */
public static final String[] itemMetaNames = new String[] {"rubberRaw", "rubberSynthetic", "rubberCompressed", "rubberMelted"};
public static final String[] items= new String[] {"rubberRaw", "rubberSynthetic", "rubberCompressed", "rubberMelted"};

@SideOnly(Side.CLIENT)
private Icon[] icons;

public ItemRubber(int par1)
{
         super(par1);
         setHasSubtypes(true);
         setMaxDamage(0);
         setMaxStackSize(64);
         setUnlocalizedName("rubber");
         setCreativeTab(Plague.tabPlagueItems);
}
public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B)
{
}	
@SideOnly(Side.CLIENT)
public Icon getIconFromDamage(int par1)
{
	//item number - 1
         int j = MathHelper.clamp_int(par1, 0, 3);
         return this.icons[j];
}

public String getUnlocalizedName(ItemStack par1ItemStack)
{
	//item number - 1
         int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 3);
         return super.getUnlocalizedName() + "." + itemMetaNames[i];
}

@SideOnly(Side.CLIENT)
public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
{
         for (int j = 0; j < 4; ++j)
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