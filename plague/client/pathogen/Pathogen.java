package plague.client.pathogen;

import plague.client.implementation.IPathogen;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

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

public static float microscopicScale;

public static String uniqueName;
/**
 * List that contains every aboded pathogen in the game.
 * 50 pathogens can be listed.
 * @author p1-r_squar3d
 */
public static Pathogen[] pathogenList = new Pathogen[50];
/**
 * @param i - unique ID for the pathogen
 * @author p1-r_squar3d
 * 
 */
public Pathogen(int i) {
	if (pathogenList[i] != null) {
		throw new IllegalArgumentException("Pathogen ID " + i + " is already occupied by " + pathogenList[i] + " when registering " + this);
	}
	pathogenList[i] = this;
}
public abstract boolean isPathogen();

/**
 * Prints the class of the registered pathogen.
 * @param i - id of the pathogen registered.
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
		p.attackTime
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
public String getUniqueName() {
	return this.uniqueName;
}

@Deprecated
@NeedToBeFixedByP1
public String getUniqueNameInPluralForm() {
	
if (this.uniqueName.endsWith("xxx")) {
	return this.uniqueName + "s";
}
else if (this.uniqueName.endsWith("ch") 
		|| (this.uniqueName.endsWith("j")) 
		|| (this.uniqueName.endsWith("s")) 
		|| (this.uniqueName.endsWith("x")) 
		|| (this.uniqueName.endsWith("z")) 
		|| (this.uniqueName.endsWith("o")) 
		|| (this.uniqueName.endsWith("sh"))
		|| (this.uniqueName.endsWith("ch"))
		|| (this.uniqueName.endsWith("ss")) 
		|| (this.uniqueName.endsWith("zz")))
	{
		return this.uniqueName + "es";
	}
return this.uniqueName;
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
public float getHotResistance() {
	return this.hotResistance;
}
/**
 * Gets the cold resistance value setted.
 * @author p1-r_squar3d
 */
public float getColdResistance() {
	return this.coldResistance;
}
/**
 * Gets the drug resistance value setted.
 * @author p1-r_squar3d
 */
public float getDrugResistance() {
	return this.drugResistance;
}
/**
 * Being worked on. Not recommended for use yet, may cause world issues.
 * @param f - size of pathogen appearing under the microscope lens
 * @author p1-r_squar3d
 */
@Deprecated
public Pathogen setMicroScopicScale(float f) {
	this.microscopicScale = f;
	
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