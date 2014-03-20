	package p1.plague.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import p1.plague.Plague;
import p1.plague.block.container.ContainerDNAMergerBasic;
import p1.plague.block.tileentity.TileEntityDNAMergerBasic;
import p1.reference.RandyGen;
import p1.reference.StringColor;

	public class GUIDNAMergerBasic extends GuiContainer{
		public static final ResourceLocation texture = new ResourceLocation(Plague.ID, "textures/gui/DNAMergerBasicGui.png");
		public static String powerStatus;
		public static String mergeStatus;
		
		public TileEntityDNAMergerBasic merger;
		
		int [] tier1 = {10,20,30,40,50,60,70,80,90};
		public GUIDNAMergerBasic(InventoryPlayer invPlayer, TileEntityDNAMergerBasic entity) {
			super(new ContainerDNAMergerBasic(invPlayer, entity));
			
			this.merger = entity;

			this.xSize = 210; /**FROM LEFT TO RIGHT SCALE**/
			this.ySize = 247; /**FROM UP TO DOWN SCALE**/
		}
		
		private void gen() {
			int i = RandyGen.generateRandomInt(1, 10);
		if(merger.isScanning()) {	
			if(i == 1) {
				mergeStatus = "Success";
			}
			else
			{
				mergeStatus = "Failed";
			}
		}
		}
		public void drawGuiContainerForegroundLayer(int par1, int par2){
			String s = this.merger.isInvNameLocalized() ? this.merger.getInvName() : I18n.getString(this.merger.getInvName());
			this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 4, 4210752);
			gen();
		if(this.merger.isScanning()) {	
			this.fontRenderer.drawString(mergeStatus + merger.scanProgress + "%", 100, ySize - 154 + 32, xSize + 20);
		}
		else
		{
			this.fontRenderer.drawString("Idle", 100, ySize - 154 + 32, xSize + 20);
		}
			this.fontRenderer.drawString(I18n.getString("container.inventory"), 5, this.ySize - 96 + 4, 4210752);
			this.fontRenderer.drawString("Power:", 60, ySize - 154 + 32, xSize + 20);
			this.fontRenderer.drawString("" + merger.power + "/10000", 63, ySize - 154 + 47, 428766);
			
		}
		public void drawGuiContainerBackgroundLayer(float f, int j, int i) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			
			Minecraft.getMinecraft().getTextureManager().
			bindTexture(texture);
			
			drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
			
			int i1;

			if(this.merger.hasPower()) { 
				i1 = this.merger.getPowerRemainingScaled(79);
				this.drawTexturedModalRect(guiLeft + 48, guiTop + 151 - i1, 210 ,79 - i1, 6, i1);
			
			}
				
		}
	}
	