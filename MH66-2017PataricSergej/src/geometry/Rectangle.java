package geometry;

import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends Shape {

	private int width;
	private int height;
	private Point upperLeft;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}
	
	public int area() {
		return width*height;
	}
	
	public int circumference() {
		return 2*(width+height);
	}
	
	public boolean contains(int x, int y) {
		return upperLeft.getX()+width >= x && upperLeft.getY()+height >= y;			
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public String toString() {
		return "Upper left point: " + upperLeft + ", width: " + width + ", height: " + height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp = (Rectangle)obj;
			if(temp.getUpperLeft().equals(upperLeft) &&
					temp.getHeight() == height &&
					temp.getWidth() == width) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		g.setColor(color);
		g.setColor(fillColor);
		g.fillRect(upperLeft.getX(), upperLeft.getY(), width, height);
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle)o;
			return this.area() - temp.area();
		}
		return 0;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}




}
