package plague.common.misc;

import plague.client.pathogen.Pathogen;

public class PathogenVirus extends Pathogen {

	public PathogenVirus(int i) {
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