/**package lesslyepic.plaguemod.client.achievements;

import lesslyepic.plaguemod.client.item.PlagueItems;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PlagueAchievements {

static final Achievement pokingTime = new Achievement(2001, "pokingTime", 1, -2, PlagueItems.itemSyringeBasic, AchievementList.buildFurnace).registerAchievement();
static final Achievement advancedPoking = new Achievement(2002, "TimeAchieve", 1, -2, PlagueItems.itemSyringeBasic, AchievementList.buildFurnace).registerAchievement();
static final Achievement pokingTime = new Achievement(2001, "TimeAchieve", 2, -2, PlagueItems.itemSyringeBasic, AchievementList.buildFurnace).registerAchievement();
static final Achievement pokingTime = new Achievement(2001, "TimeAchieve", 3, -2, PlagueItems.itemSyringeBasic, AchievementList.buildFurnace).registerAchievement();
static final Achievement pokingTime = new Achievement(2001, "TimeAchieve", 4, -2, PlagueItems.itemSyringeBasic, AchievementList.buildFurnace).registerAchievement();
	
static void addAchievementLocalizations(){}
private static void addAchievementName(String ach, String name)
{
LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
}

private static void addAchievementDesc(String ach, String desc)
{
LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
}

public static void load() {
	
	addAchievementLocalizations();
	{
		addAchievementName("pokingTime", "Time to poke!");
		addAchievementDesc("pokingTime", "Craft a basic syringe");
	}
}
}
**/