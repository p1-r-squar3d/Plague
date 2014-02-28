package plague.client.achievements;

import java.lang.reflect.Field;
import java.util.Map;

import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.AchievementMap;
import net.minecraft.stats.StatList;
import net.minecraftforge.common.AchievementPage;
import plague.client.item.PlagueItems;
import plague.common.assets.StringColor;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PlagueAchievements {

	public static Achievement pokingTime;
	public static Achievement wapow;
	
	public static AchievementPage pagePlague;

static void addAchievementLocalizations(String ach, String achName, String achDesc) 
{
	LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", achName);
	LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", achDesc);
}

private boolean addHiddenAchievement(Achievement ach) {

    StatList.allStats.add(ach);
            
    Map oneShotStats = null;
    Field field = null;
    
    for (Field f : StatList.class.getDeclaredFields()) {
        f.setAccessible(true);
        try {
                        if (f.getName().equals("oneShotStats") || f.getName().equals("field_75942_a")) {
                                oneShotStats = (Map)f.get(null);
                                field = f;
                        }
                } catch (Exception ex) {
                        System.out.println("no field " + ex);
                        return false;
                }
    }
   
        
        if (oneShotStats == null) return false;
        
        try {
                if (oneShotStats.containsKey(Integer.valueOf(ach.statId))) {
                        System.out.println("Already existing Achievement with this stat id!");
            return false;
        }
                
                oneShotStats.put(Integer.valueOf(ach.statId), ach);
        } catch (Exception e) {
                System.out.println("Failed setting");
                return false;
        }
        
        
    ach.statGuid = AchievementMap.getGuid(ach.statId);
        
    return true;
}

public static void load() {
	pokingTime = new Achievement(2001, "pokingTime", 1, -2, PlagueItems.itemSyringeBasic, AchievementList.acquireIron).registerAchievement();
	wapow = new Achievement(2002, "wapow", 1, -9, PlagueItems.itemSyringeBasic, AchievementList.acquireIron).registerAchievement();
	
	pagePlague = new AchievementPage(StringColor.dark_red + "Plague", pokingTime, wapow);
	
	AchievementPage.registerAchievementPage(pagePlague);
	
	addAchievementLocalizations("pokingTime", "Poking Time", "Created a basic syringe");
	addAchievementLocalizations("wapow", "WAPOW!", "Injected a syring to a mob and got its blood.");
}
}