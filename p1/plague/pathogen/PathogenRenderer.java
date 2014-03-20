package p1.plague.pathogen;

import java.awt.Component; 
import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.util.Random;

public abstract class PathogenRenderer extends Component {

public PathogenRenderer(Graphics g) {
	super();
	if (g == this.getGraphics()) {
		this.disable();
	}
}

protected void draw(Graphics g, Color c, int x, int y) { 
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.CYAN);
		g.drawLine(x,y,x,y);
	}

public void colorInPixels() {
	
}
}