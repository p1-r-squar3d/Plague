package plague.client.pathogen.type;

import java.util.logging.Level;

import plague.client.pathogen.Pathogen;
import plague.common.PlagueLog;

public abstract class PathogenType extends Pathogen{
	
	public static PathogenType p;
	public int ptID;
	
	public PathogenType(int i, PathogenType p) {
		super(i, p);
		this.p = p;
		this.ptID = i;
	}
	
	public void list() {
		
		}
	}