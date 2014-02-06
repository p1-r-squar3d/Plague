package plague.client.registry;

import java.util.ArrayList;
import java.util.List;

import plague.client.implementation.IPathogen;

public class PlagueRegistry {

private static List<IPathogen> pathogens = new ArrayList<IPathogen>();

/**
 * Registers a pathogen created, the pathogen must implement @IPathogen	
 * @param p - The pathogen you want to register
 * @param n - The name of the pathogen you registered
 */
public static void registerPathogen(IPathogen p) {
	if (!PlagueRegistry.pathogens.contains(p))
    {
        PlagueRegistry.pathogens.add(p);
    }
}
}
