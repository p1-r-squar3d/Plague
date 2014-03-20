package p1.plague.pathogen.type;

import java.util.logging.Level;

import p1.plague.PlagueLog;
import p1.plague.pathogen.Pathogen;

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