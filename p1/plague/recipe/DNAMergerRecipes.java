package p1.plague.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import p1.plague.PlagueConfig;

public class DNAMergerRecipes
{
    public DNAMergerRecipes()
    {
    }

    public static ItemStack getSmeltingResult(int i, int j)
    {
        return getOutput(i, j);
    }

    private static ItemStack getOutput(int i, int j)
    {
        if (i == Item.coal.itemID && j == Item.ingotIron.itemID || i == Item.ingotIron.itemID && j == Item.coal.itemID)
        {
            return new ItemStack(Item.ingotGold, 1);
        }
        if (i == PlagueConfig.itemStubDNAMerger1 && j == PlagueConfig.itemStubDNAMerger2 || i == PlagueConfig.itemStubDNAMerger2 && j == PlagueConfig.itemStubDNAMerger1)
        {
            return new ItemStack(Item.ingotGold, 1);
        }
		return null;
    }
}