package p1.plague.pathogen.plague;

import p1.plague.pathogen.Pathogen;

public class PathogenPlague {
	
	protected boolean runningPlague = false;
	private Pathogen pa;
	
	public PathogenPlague(Pathogen pa) {
		this.pa = pa;
	}
	
	/**
	 * 
	 * Sets whether this plague is created first when a new world is created.
	 * @author p1-r_squar3d
	 */
	public boolean isPrePlague() {
		return true;
	}
}
