package plague.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import plague.client.container.ContainerCircuitBuilder;
import plague.client.item.PlagueItems;
import plague.client.tileentity.TileEntityCircuitBuilder;

public class GUICircuitBuilder extends GuiContainer
{

public static TileEntityCircuitBuilder cbuilder;

public GUICircuitBuilder(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5, TileEntityCircuitBuilder entity)
{
	super(new ContainerCircuitBuilder(par1InventoryPlayer, par2World, par3, par4, par5, entity));
	cbuilder = entity;
}
public static String GuiTexturePrefix = "plague" + ":" + "textures/gui/";

public Minecraft mc = Minecraft.getMinecraft();

public ItemStack cb = new ItemStack(PlagueItems.itemCircuitParts,1,5);

private String hashStr = "BCB not inserted.";

public NBTTagCompound stackTagCompound;

public static ResourceLocation BigCrafting = new ResourceLocation(GuiTexturePrefix + "CircuitBuilderGUI.png");
@Override
public void initGui() {
	super.initGui();
	checkForCircuitBoard();
	if (cbuilder.hash == true) {
		buttonList.add(new GuiButton(1, 234, 37, 45, 20, "Install"));
	}
}

protected void actionPerformed(GuiButton guibutton) {
	
    switch(guibutton.id) {
    case 1:
    	cbuilder.createAndLoadEntity(stackTagCompound);
    }
    }
protected void drawGuiContainerForegroundLayer(int par1, int par2)
{

this.fontRenderer.drawString("Circuit Builder", 40 + 5, - 10 - 10, 4210752);
this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 50 + 14, this.ySize - 96 - 10 - 19, 4210752);
this.fontRenderer.drawString(hashStr, 13, 92, 4210752);


}

private boolean checkForCircuitBoard() {
	
	Item c = PlagueItems.itemCircuitParts;
	
	if(mc.thePlayer.getHeldItem() != null && mc.thePlayer.getHeldItem().isItemEqual(cb)) {
		hashStr = "BCB ready to install.";
		cbuilder.ready = true;
		mc.thePlayer.inventoryContainer.detectAndSendChanges();
		return true;
	}
	else
	{
		this.updateScreen();
		cbuilder.hash = false;
		cbuilder.ready = false;
		return false;
	}
}
protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
{

GL11.glColor4f(1F, 1F, 1F, 1F);

this.mc.getTextureManager().bindTexture(BigCrafting);

this.ySize = 231;
this.xSize = 176;

int var5 = (this.width - this.xSize) / 2;
int var6 = (this.height - this.ySize) / 2;
int var7;

/**must be called before chip rect **/
this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);

if(cbuilder.ready == true) { 
	this.drawTexturedModalRect(guiLeft + 125, guiTop + 67, 176, 89, 32, 100);
}

if(cbuilder.installed == true) {
	this.drawTexturedModalRect(guiLeft + 22, guiTop - 1, 176, 0, 54, 89);
}

}
}
