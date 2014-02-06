package plague.client.event;

import plague.client.item.PlagueItems;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class EventSyringe {
	
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitBlaze(AttackEntityEvent e){
	if(!(e.target instanceof EntityBlaze)){return;}
	    if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
	        e.setCanceled(true);
	        e.target.canAttackWithItem();
	        e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 0));
	        }
}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitCaveSpider(AttackEntityEvent e){
	    if(!(e.target instanceof EntityCaveSpider)){return;}
		if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
			e.setCanceled(true);
			e.target.canAttackWithItem();
			e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 1));
			}
}		
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitCreeper(AttackEntityEvent e){		
		if(!(e.target instanceof EntityCreeper)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 2));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitEnderman(AttackEntityEvent e){		
		if(!(e.target instanceof EntityEnderman)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 3));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitGhast(AttackEntityEvent e){		
		if(!(e.target instanceof EntityGhast)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 4));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitIronGolem(AttackEntityEvent e){		
		if(!(e.target instanceof EntityIronGolem)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 5));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitPigZombie(AttackEntityEvent e){		
		if(!(e.target instanceof EntityPigZombie)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 6));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitSilverfish(AttackEntityEvent e){		
		if(!(e.target instanceof EntitySilverfish)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 7));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitSkeleton(AttackEntityEvent e){		
		if(!(e.target instanceof EntitySkeleton)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 8));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitSlime(AttackEntityEvent e){		
		if(!(e.target instanceof EntitySlime)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 9));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitSnowman(AttackEntityEvent e){		
		if(!(e.target instanceof EntitySnowman)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 10));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitSpider(AttackEntityEvent e){		
		if(!(e.target instanceof EntitySpider)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 11));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitWitch(AttackEntityEvent e){		
		if(!(e.target instanceof EntityWitch)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 12));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitBat(AttackEntityEvent e){		
		if(!(e.target instanceof EntityBat)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 13));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitChicken(AttackEntityEvent e){		
		if(!(e.target instanceof EntityChicken)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 14));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitCow(AttackEntityEvent e){		
		if(!(e.target instanceof EntityCow)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 15));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitHorse(AttackEntityEvent e){		
		if(!(e.target instanceof EntityHorse)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 16));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitMooshroom(AttackEntityEvent e){		
		if(!(e.target instanceof EntityMooshroom)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 17));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitOcelot(AttackEntityEvent e){		
		if(!(e.target instanceof EntityOcelot)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 18));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitPig(AttackEntityEvent e){		
		if(!(e.target instanceof EntityPig)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 19));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitSheep(AttackEntityEvent e){		
		if(!(e.target instanceof EntitySheep)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 20));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitSquid(AttackEntityEvent e){		
		if(!(e.target instanceof EntitySquid)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 21));}
		}
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitVillager(AttackEntityEvent e){		
		if(!(e.target instanceof EntityVillager)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 22));}
		}
//player
@ForgeSubscribe(priority = EventPriority.NORMAL)
public void hitPlayer(AttackEntityEvent e){		
		if(!(e.target instanceof EntityPlayer)){return;}
        if(e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().itemID == PlagueItems.itemSyringeBasic.itemID){
        	e.setCanceled(true);
        	e.target.canAttackWithItem();
        	e.entityPlayer.inventory.setInventorySlotContents(e.entityPlayer.inventory.currentItem, new ItemStack(PlagueItems.itemBloodSyringeBasic, 1, 22));}
		}
}
