package p1.plague.item;

import net.minecraft.item.Item;

public class ItemGeneCodeAnalyzer extends Item implements IPowerDepletingItem{

	public ItemGeneCodeAnalyzer(int par1) {
		super(par1);
	}

	@Override
	public int powerDepletionRate() {
		return 0;
	}

	@Override
	public boolean cantOpenWithoutPower() {
		return false;
	}
	
}
