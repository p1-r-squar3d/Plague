package plague.common.misc;

import java.awt.Color;
import java.awt.Graphics;

import plague.client.pathogen.PathogenRenderer;

public class RenderPathogenBacteria extends PathogenRenderer {
	
public RenderPathogenBacteria(Graphics g) {
		super(g);
		this.draw(g, Color.BLACK, 31, 1);
	}
}