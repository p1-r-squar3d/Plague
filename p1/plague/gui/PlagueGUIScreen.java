/**
 * package p1.plague.gui;
 * 
 * import net.minecraft.client.gui.GuiScreen; import
 * net.minecraft.util.ResourceLocation;
 * 
 * import org.lwjgl.opengl.GL11;
 * 
 * import p1.plague.Plague;
 * 
 * import com.mcf.davidee.guilib.basic.BasicScreen; import
 * com.mcf.davidee.guilib.basic.Label; import
 * com.mcf.davidee.guilib.core.Container; import
 * com.mcf.davidee.guilib.vanilla.sliders.IntSlider;
 * 
 * public abstract class PlagueGUIScreen extends BasicScreen {
 * 
 * public static final int WIDTH = 256, HEIGHT = 129; private static final
 * ResourceLocation TEXTURE = new ResourceLocation(Plague.ID,
 * "textures/gui/window.png");
 * 
 * public PlagueGUIScreen(GuiScreen parent) { super(parent); }
 * 
 * @Override public boolean doesGuiPauseGame() { return false; }
 * @Override public void drawBackground() { super.drawBackground();
 *           drawGradientRect(0, 0, width, height, -1072689136, -804253680); int
 *           x = (width - WIDTH) / 2, y = (height - HEIGHT) / 2;
 *           mc.renderEngine.getTexture(TEXTURE); GL11.glColor4f(1, 1, 1, 1);
 *           drawTexturedModalRect(x, y, 0, 0, WIDTH, HEIGHT); } }
 **/
