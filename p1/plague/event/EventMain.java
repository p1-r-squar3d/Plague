package p1.plague.event;

import p1.plague.PlagueExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

public class EventMain
{
@ForgeSubscribe
public void onEntityConstructing(EntityConstructing event)
{

if (event.entity instanceof EntityPlayer && PlagueExtendedPlayer.get((EntityPlayer) event.entity) == null)
PlagueExtendedPlayer.register((EntityPlayer) event.entity);

if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(PlagueExtendedPlayer.EXT_PROP_NAME) == null)
event.entity.registerExtendedProperties(PlagueExtendedPlayer.EXT_PROP_NAME, new PlagueExtendedPlayer((EntityPlayer) event.entity));
}
}