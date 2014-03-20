package p1.plague.item;

import net.minecraft.item.Item;

public class ItemPowered extends Item{

	public ItemPowered(int par1) {
		super(par1);
	}
	
	public static int powerDepletionRate() {
		if (powerDepletionRate() == 0) throw new ArithmeticException();
		return 0;
	}
	
	public static boolean cantOpenWithoutPower() {
		return false;
	}
}