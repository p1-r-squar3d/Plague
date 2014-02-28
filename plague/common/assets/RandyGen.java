package plague.common.assets;

import java.util.Random;

/**
 * Generates random objects at will
 * @author p1-r_squar3d
 */
public class RandyGen {
	
/**
* Returns a random number in a range inclusive.
*
* @param lowerLimit
* - Inclusive lower limit
* @param upperLimit
* - Inclusive upper limit
* 
* @author p1-r_squar3d
*/
public static int generateRandomInt(int lowerLimit, int upperLimit) {
	
		Random r = new Random();

		if (lowerLimit > upperLimit) {
			return 0;
		}

		return r.nextInt((upperLimit - lowerLimit) + 1) + lowerLimit;
	}

public static String generateRandomString(String a, String b) {
	return a + " " + b;
}
}
