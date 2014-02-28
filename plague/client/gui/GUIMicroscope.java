package plague.client.gui;

import java.io.IOException;

import plague.client.pathogen.Pathogen;

import com.mcf.davidee.guilib.basic.Label;
import com.mcf.davidee.guilib.core.Container;
import com.mcf.davidee.guilib.vanilla.sliders.IntSlider;

import net.java.games.input.Event;
import net.java.games.input.Keyboard;
import net.minecraft.client.gui.GuiScreen;

public class GUIMicroscope extends PlagueGUIScreen{

	private Container c;
	private Label mscope, pathogenName;
	private IntSlider zoom;
	
	private String patho;
	
	public GUIMicroscope() {
		super(null);
	}
	
	@Override
	protected void revalidateGui() {
		int startY = (height - HEIGHT) / 2;
		
		zoom.setPosition(width / 2, startY + 5);
		mscope.setPosition(width / 2, startY - 10);
		pathogenName.setPosition(width / 2, startY - 5);
		
		c.revalidate(0, 0, width, height);
	}
	
	@Override
	protected void createGui() {
		c = new Container();
		zoom = new IntSlider("Zoom", 50, 0, 100);
		mscope = new Label("Microscope", 0, 0);
		this.getPathogenUniqueName();
		pathogenName = new Label(patho, 0, 0);
		
		containers.add(c);
		
	}

	@Override
	protected void reopenedGui() {
		// TODO Auto-generated method stub
		
	}
	
	private void getPathogenUniqueName() {
		String p = Pathogen.getUniqueName();
	if(p == null) {	
		patho = "Yolo";
		throw new IllegalArgumentException("patho is empty");
		}
	else
	{
		p = patho;
	}
	}
	
	@Override
	protected void unhandledKeyTyped(char c, int code) {
		if (c == 27) {
			close();
		}
	}
}
