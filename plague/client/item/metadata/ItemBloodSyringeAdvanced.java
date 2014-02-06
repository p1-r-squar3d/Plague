package plague.client.item.metadata;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import plague.client.item.PlagueItems;
import plague.common.Plague;
import plague.common.assets.StringColor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBloodSyringeAdvanced extends Item
{

/** List of item names */
public static final String[] itemMetaNames = new String[] {"blaze", "caveSpider", "creeper", "enderman", "ghast", "ironGolem", "pigZombie", "silverfish", "skeleton", "slime", "snowMan", "spider", "witch", "bat", "chicken", "cow", "horse", "mooshroom", "ocelot", "pig", "sheep", "squid", "villager"};
public static final String[] item_a = new String[] {"blaze", "caveSpider", "creeper", "enderman", "ghast", "ironGolem", "pigZombie", "silverfish", "skeleton", "slime", "snowMan", "spider", "witch", "bat", "chicken", "cow", "horse", "mooshroom", "ocelot", "pig", "sheep", "squid", "villager"};
@SideOnly(Side.CLIENT)
private Icon[] item_b;

public static boolean keyPressed_keyDisposeFluid = false;

public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B)
{
	String iN = is.getDisplayName();
	
	l.add(StringColor.light_cyan + "Advanced");
	if (iN.equals("Syringe"+StringColor.dark_red+" [b/01]")){l.add(StringColor.dark_red+"[Blaze Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_red+" [b/02]")){l.add(StringColor.dark_red+"[Cavespider Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_red+" [b/03]")){l.add(StringColor.dark_red+"[Creeper Blood]");}
	if (iN.equals("Syringe"+StringColor.light_purple+" [b/04]")){l.add(StringColor.light_purple+"[Enderman Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_red+" [b/05]")){l.add(StringColor.dark_red+"[Ghast Blood]");}
	if (iN.equals("Syringe"+StringColor.light_green+" [b/06]")){l.add(StringColor.light_green+"[Iron Golem Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_red+" [b/07]")){l.add(StringColor.dark_red+"[Zombie Pigman Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_red+" [b/08]")){l.add(StringColor.dark_red+"[Silverfish Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_red+" [b/09]")){l.add(StringColor.dark_red+"[Skeleton Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_red+" [b/10]")){l.add(StringColor.dark_red+"[Slime Blood]");}
	if (iN.equals("Syringe"+StringColor.light_green+" [b/11]")){l.add(StringColor.light_green+"[Snow Golem Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_red+" [b/12]")){l.add(StringColor.dark_red+"[Spider Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_red+" [b/13]")){l.add(StringColor.dark_red+"[Witch Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_cyan+" [b/14]")){l.add(StringColor.dark_cyan+"[Bat Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_cyan+" [b/15]")){l.add(StringColor.dark_cyan+"[Chicken Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_cyan+" [b/16]")){l.add(StringColor.dark_cyan+"[Cow Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_cyan+" [b/17]")){l.add(StringColor.dark_cyan+"[Horse Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_cyan+" [b/18]")){l.add(StringColor.dark_cyan+"[Mooshroom Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_cyan+" [b/19]")){l.add(StringColor.dark_cyan+"[Ocelot Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_cyan+" [b/20]")){l.add(StringColor.dark_cyan+"[Pig Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_cyan+" [b/21]")){l.add(StringColor.dark_cyan+"[Sheep Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_cyan+" [b/22]")){l.add(StringColor.dark_cyan+"[Squid Blood]");}
	if (iN.equals("Syringe"+StringColor.dark_yellow+" [b/23]")){l.add(StringColor.dark_yellow+"[Villager Blood]");}
}

public ItemBloodSyringeAdvanced(int par1)
{
         super(par1);
         this.setHasSubtypes(true);
         this.setMaxDamage(0);
         this.setUnlocalizedName("metadataBloodSyringe");
}

@SideOnly(Side.CLIENT)
public Icon getIconFromDamage(int par1)
{
         int j = MathHelper.clamp_int(par1, 0, 22);
         return this.item_b[j];
}

public String getUnlocalizedName(ItemStack par1ItemStack)
{
         int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 22);
         return super.getUnlocalizedName() + "." + itemMetaNames[i];
}

@SideOnly(Side.CLIENT)
public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
{
         for (int j = 0; j < 23; ++j)
         {
                 par3List.add(new ItemStack(par1, 1, j));
         }
}

public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
{
EntityPlayer player = (EntityPlayer)par3Entity;
if (this.keyPressed_keyDisposeFluid)
{
	if (player.getHeldItem() != null && player.getHeldItem().itemID == PlagueItems.itemBloodSyringeAdvanced.itemID)
    {
		player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(PlagueItems.itemSyringeBasic));
    }
}
}
@Override
public void registerIcons(IconRegister par1IconRegister)
{
         this.item_b = new Icon[item_a.length];
        
         for (int i = 0; i < item_a.length; ++i)
         {
                 this.item_b[i] = par1IconRegister.registerIcon(Plague.TEXTURE + "syringe_blood");
         }
}
}