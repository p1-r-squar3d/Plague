package plague.client.pathogen;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import plague.client.pathogen.type.PathogenType;
import plague.common.misc.PathogenTypeBacteria;

/**
 *  The core pathogen class, use this instance for creating a new pathogen.
 * @author p1-r_squar3d
 */
public abstract class Pathogen {
	
/**
 * ID of the pathogen.
 * @author p1-r_squar3d	
 */
public static int pathogenID;

public static float hotResistance;
public static float coldResistance;
public static float drugResistance;

public static Pathogen p;

public static float microscopicScale;

public static String uniqueName;
public static String desc;
/**
 * List that contains every aboded pathogen in the game.
 * 50 pathogens can be listed.
 * @author p1-r_squar3d
 */
public static Pathogen[] pathogenList = new Pathogen[50];
/**
 * @param i - unique ID for the pathogen
 * @param p - pathogen type for it
 * @author p1-r_squar3d
 * 
 */
public Pathogen(int i, PathogenType p) {
	if (pathogenList[i] != null) {
		throw new IllegalArgumentException("Pathogen ID " + i + " is already occupied by " + pathogenList[i] + " when registering " + this);
	}
	pathogenList[i] = this;
}
public abstract boolean isPathogen();

/**
 * Prints the class of the registered pathogen for informational purposes.
 * @param i - id of the pathogen registered.
 * @author p1-r_squar3d
 */
public static void printRegisteredPathogen(int i) {
	String s = pathogenList[i].toString();
	System.out.println(s);
}
public static void setCorrosive(EntityPlayer p, World w) {
	
}

public static void corrode(EntityPlayer p, World w) {
	p.clearItemInUse();
	if (!w.isRemote) {
		w.extinguishFire(p, 2, 3, 4, 5);
		p.setInvisible(true);
	}
}
/**
 * Set an event when on pathogen collision.
 * 
 * @param p - player object
 * @param w - world object
 * @param x - x position
 * @param y - y position
 * @param z - z position
 * @author p1-r_squar3d
 */
public static void onPathogenCollision(EntityPlayer p, World w, int x, int y, int z) {

}
/**
 * Sets a unique name for the pathogen.
 * @param s - unique name
 * @author p1-r_squar3d
 */
public Pathogen setUniqueName(String s) {
	this.uniqueName = s;
	return this;
}
/**
 * Gets the unique name setted.
 * @author p1-r_squar3d
 */
public static String getUniqueName() {
	return uniqueName;
}

public static Pathogen getPathogen() {
	return p;
}

public static Pathogen setDescription(String s) {
	desc = s;
	return Pathogen.getPathogen();
}
public static void getPathogenTypeAdvantage() {
	if (Pathogen.getPathogen() instanceof PathogenTypeBacteria) {
		float f = getHotResistance() + 1.0F;
	}
}
@Deprecated
@NeedToBeFixedByP1
public static String getUniqueNameInPluralForm() {
	
if (uniqueName.endsWith("xxx")) {
	return uniqueName + "s";
}
else if (uniqueName.endsWith("ch") 
		|| (uniqueName.endsWith("j")) 
		|| (uniqueName.endsWith("s")) 
		|| (uniqueName.endsWith("x")) 
		|| (uniqueName.endsWith("z")) 
		|| (uniqueName.endsWith("o")) 
		|| (uniqueName.endsWith("sh"))
		|| (uniqueName.endsWith("ch"))
		|| (uniqueName.endsWith("ss")) 
		|| (uniqueName.endsWith("zz")))
	{
		return uniqueName + "es";
	}
return uniqueName;
}
/**
 * Sets a default starting value for hot resistance.
 * @param f - hot resistance value
 * @author p1-r_squar3d
 */
public Pathogen setHotResistance(float f) {
	this.hotResistance = f;
	return this;
}
/**
 * Sets a default starting value for cold resistance.
 * @param f - cold resistance value
 * @author p1-r_squar3d
 */
public Pathogen setColdResistance(float f) {
	this.coldResistance = f;
	return this;
}
/**
 * Sets a default starting value for drug resistance.
 * @param f - drug resistance value
 * @author p1-r_squar3d
 */
public Pathogen setDrugResistance(float f) {
	this.drugResistance = f;
	return this;
}
/**
 * Gets the hot resistance value setted.
 * @author p1-r_squar3d
 */
public static float getHotResistance() {
	return hotResistance;
}
/**
 * Gets the cold resistance value setted.
 * @author p1-r_squar3d
 */
public static float getColdResistance() {
	return coldResistance;
}
/**
 * Gets the drug resistance value setted.
 * @author p1-r_squar3d
 */
public static float getDrugResistance() {
	return drugResistance;
}
/**
 * Being worked on. Not recommended for use yet, may cause world issues.
 * @param f - size of pathogen appearing under the microscope lens
 * @author p1-r_squar3d
 */
@Deprecated
public Pathogen setMicroScopicScale(float f) {
	microscopicScale = f;
	
	return this;
}
/**
 * Being worked on. Not recommended for use yet, may cause world issues.
 * @author p1-r_squar3d
 */
@Deprecated
public float getMicroscopicScale() {
	return this.microscopicScale;
}

}