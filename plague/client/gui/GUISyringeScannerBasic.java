	package plague.client.gui;

import java.awt.Graphics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import plague.client.container.ContainerSyringeScannerBasic;
import plague.client.pathogen.PathogenRenderer;
import plague.client.tileentity.TileEntitySyringeScannerBasic;
import plague.common.Plague;

	public class GUISyringeScannerBasic extends GuiContainer{
		public static final ResourceLocation texture = new ResourceLocation(Plague.ID, "textures/gui/syringeScannerBasicGui.png");
		public TileEntitySyringeScannerBasic syringeScanner;
		public static String powerHash;
		
		public GuiButton scan;
		public GuiButton drain;
		
		public GUISyringeScannerBasic(InventoryPlayer invPlayer, TileEntitySyringeScannerBasic entity) {
			super(new ContainerSyringeScannerBasic(invPlayer, entity));
			
			this.syringeScanner = entity;

			this.xSize = 210; /**FROM LEFT TO RIGHT SCALE**/
			this.ySize = 247; /**FROM UP TO DOWN SCALE**/
		}
		@Override
		public void initGui() {
			super.initGui();
			buttonList.add(scan = new GuiButton(1, xSize / 2, ySize - 70, 30, 20, "Scan"));
			buttonList.add(drain = new GuiButton(2, xSize / 2, ySize - 12, 30, 20, "Drain"));
		}
		private void sub() {
		}
		protected void actionPerformed(GuiButton guibutton) {
			
            switch(guibutton.id) {
            case 1:
             
            System.out.println("WAPOW");
            break;
            
            case 2:
            	if(this.syringeScanner.power > 0)
            	this.syringeScanner.power--;
            }
    }
		public void drawGuiContainerForegroundLayer(int par1, int par2){
			String s = this.syringeScanner.isInvNameLocalized() ? this.syringeScanner.getInvName() : I18n.getString(this.syringeScanner.getInvName());
			
			this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 4, 4210752);
			this.fontRenderer.drawString(I18n.getString("container.inventory"), 9, this.ySize - 96 + 6, 4210752);
			this.fontRenderer.drawString("Power: ", 80, ySize - 137, xSize + 200);
			this.fontRenderer.drawString("" + syringeScanner.power + "/10000", 120, ySize - 137, 428766);
			this.fontRenderer.drawString("Speed: " + syringeScanner.maceratingSpeed / 30 +"s", 85, ySize - 210 + 5, 428766);
			this.fontRenderer.drawString("Status: CLEAN", 85, ySize - 225,428766);
			
		if(syringeScanner.isScanning()) { 	
			this.fontRenderer.drawString("Scanning: " + syringeScanner.scanProgress + "%", 85, ySize - 215,428766);
		}
			else {
				this.fontRenderer.drawString("Scanning: 0%", 85, ySize - 215, 428766);
			}
		if(syringeScanner.isPowerDrained()) {
			this.fontRenderer.drawString(powerHash, 85, ySize - 200 + 10, 428766);
		}
		}
		
		public void drawGuiContainerBackgroundLayer(float f, int j, int i) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			
			Minecraft.getMinecraft().getTextureManager().
			bindTexture(texture);
			
			drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
			
			int i1;

			if(this.syringeScanner.hasPower()) { 
				i1 = this.syringeScanner.getPowerRemainingScaled(79);
				this.drawTexturedModalRect(guiLeft + 48, guiTop + 151 - i1, 210 ,79 - i1, 6, i1);
			if(this.syringeScanner.hasUpgrades()) {
				this.drawTexturedModalRect(guiLeft + 117, guiTop + 124 , 210 ,86, 9, 100);
			}
				else {
					this.drawTexturedModalRect(guiLeft + 117, guiTop + 124 , 2100 ,86, 9, 100);
				}
			}
			}
				
		}
	