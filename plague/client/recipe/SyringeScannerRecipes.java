package plague.client.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import plague.client.item.PlagueItems;
import plague.common.PlagueConfig;

public class SyringeScannerRecipes
{
    public SyringeScannerRecipes()
    {
    }

    public static ItemStack getSmeltingResult(int i)
    {
        return getOutput(i);
    }

    private static ItemStack getOutput(int i)
    { 
        if (i == PlagueItems.itemSyringeBasic.itemID)
        {
            return new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 1);
        }
        if (i == PlagueConfig.itemStubSyringeScanner)
        {
            return new ItemStack(Item.ingotGold, 1);
        }
		return null;
    }
}