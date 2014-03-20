package p1.plague;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class PlagueLog {
	
	private static Logger logger = Logger.getLogger(Plague.LOG);

	public static void init() {
		logger.setParent(FMLLog.getLogger());
	}

	public static void log(Level logLevel, String message) {
		logger.log(logLevel, message);
	}
}