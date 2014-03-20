package p1.plague.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import p1.plague.PlagueConfig;
import p1.plague.item.PlagueItems;

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