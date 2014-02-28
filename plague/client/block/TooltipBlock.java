package plague.client.block;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import plague.common.Plague;

public class TooltipBlock extends ItemBlock {

	public TooltipBlock(int par1) {
		super(par1);
		this.setCreativeTab(Plague.tabPlagueBlocks);
	}
	
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
	list.add("[Unknown]");
	}
	}
