package p1.plague.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import p1.plague.item.PlagueItems;
import p1.plague.recipe.manager.RecipeManagerCircuitBuilder;
import cpw.mods.fml.common.registry.GameRegistry;

public class PlagueRecipes {

	public static void load() {

		GameRegistry.addShapedRecipe(new ItemStack(PlagueItems.itemSyringePlunger, 1, 0), new Object[] { "XXX", "X", "Y", Character.valueOf('X'), new ItemStack(PlagueItems.itemRubber, 1, 3), Character.valueOf('Y'), Item.ingotIron });
		GameRegistry.addShapedRecipe(new ItemStack(PlagueItems.itemGlassPanel, 1, 0), new Object[] { "  ", "XXX", "  ", Character.valueOf('X'), PlagueItems.itemGlassStrip });
		GameRegistry.addShapedRecipe(new ItemStack(PlagueItems.itemSyringeBasic, 1, 0), new Object[] { "X", "Y", "Z", Character.valueOf('X'), PlagueItems.itemSyringePlunger, Character.valueOf('Y'), PlagueItems.itemSyringeTube, Character.valueOf('Z'), PlagueItems.itemSyringeNeedle });
		GameRegistry.addShapedRecipe(new ItemStack(PlagueItems.itemSyringeTube, 1, 0), new Object[] { "XZX", "X X", "XYX", Character.valueOf('X'), Block.thinGlass, 'Y', new ItemStack(PlagueItems.itemRubber, 1, 3), Character.valueOf('Z'), Item.ingotIron });
		GameRegistry.addShapelessRecipe(new ItemStack(PlagueItems.itemGlassStrip, 6), new ItemStack(Block.glass));
		GameRegistry.addShapelessRecipe(new ItemStack(PlagueItems.itemGlassStrip, 3), new ItemStack(Block.thinGlass));
		FurnaceRecipes.smelting().addSmelting(PlagueItems.itemRubber.itemID, 0, new ItemStack(PlagueItems.itemRubber, 1, 3), 0.1f);
		
		RecipeManagerCircuitBuilder.getInstance().addShapedRecipe(new ItemStack(Item.bow, 1), new Object[] { " II", "I S", "I S", "I S", " II", 'I', Item.stick, 'S', Item.silk });
		RecipeManagerCircuitBuilder.getInstance().addShapelessRecipe(new ItemStack(Item.diamond, 9), new Object[] { Block.blockDiamond });
	}
}
