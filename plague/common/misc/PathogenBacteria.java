package plague.common.misc;

import plague.client.pathogen.Pathogen;

public class PathogenBacteria extends Pathogen {

	public PathogenBacteria(int i) {
		super(i);
		this.setColdResistance(10.0F);
		this.setHotResistance(10.0F);
		this.setDrugResistance(10.0F);
		this.setUniqueName("Bacteria");
		this.setMicroScopicScale(2.0F);
	}

	@Override
	public boolean isPathogen() {
		return false;
	}
}