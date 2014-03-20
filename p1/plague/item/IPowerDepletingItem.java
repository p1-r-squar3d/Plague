package p1.plague.item;

public interface IPowerDepletingItem {

	/**
	 * The amount of power to be depleted on the power source per tick
	 * @author p1-r_squar3d
	 */
	public int powerDepletionRate();
	
	public boolean cantOpenWithoutPower();
}
