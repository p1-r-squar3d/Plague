package plague.client.recipe.sorter;

import java.util.Comparator;

import plague.client.recipe.CircuitBuilderShapedRecipes;
import plague.client.recipe.CircuitBuilderShapelessRecipes;
import plague.client.recipe.manager.RecipeManagerCircuitBuilder;
import net.minecraft.item.crafting.IRecipe;

public class RecipeSorterCircuitBuilder implements Comparator{

final RecipeManagerCircuitBuilder recipeManager;

public RecipeSorterCircuitBuilder(RecipeManagerCircuitBuilder par1CircuitBuilderCraftingManager)
{
this.recipeManager = par1CircuitBuilderCraftingManager;
}

public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
{
return par1IRecipe instanceof CircuitBuilderShapelessRecipes && par2IRecipe instanceof CircuitBuilderShapedRecipes ? 1 : (par2IRecipe instanceof CircuitBuilderShapelessRecipes && par1IRecipe instanceof CircuitBuilderShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
}

public int compare(Object par1Obj, Object par2Obj)
{
return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
}
}