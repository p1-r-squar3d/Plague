package plague.client.implementation;

public interface IPathogen {

/**
 * Sets the default drug resistance value as of creation
 * @return  0.0F - 6.0F  = WEAK ||| 7.0F - 15.0F = AVERAGE ||| 16.0F - ...  = STRONG
 */
public  float setDefaultDrugResistance();

/**
 * Sets the default heat resistance value as of creation
 * @return  0.0F - 6.0F  = WEAK ||| 7.0F - 15.0F = AVERAGE ||| 16.0F - ...  = STRONG
 */
public  float setDefaultHeatResistance();

/**
 * Sets the default cold resistance value as of creation
 * @return  0.0F - 6.0F  = WEAK ||| 7.0F - 15.0F = AVERAGE ||| 16.0F - ...  = STRONG
 */
public  float setDefaultColdResistance();

}
