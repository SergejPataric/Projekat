package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable,Comparable{

	protected boolean selected;
	protected Color color;
	protected Color fillColor;

	public Shape() {

	}

	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(int x, int y);
	
	public abstract void draw(Graphics g);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public void  setColor(Color color) {
		this.color = color;
	}
	
	public void setFillColor(Color color) {
		this.fillColor  = color;
	}

}
