package drawing;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;


public class PnlDrawing extends JPanel {
	
	ArrayList<geometry.Shape> shapes = new ArrayList<geometry.Shape>();
	private String item;
	private Point p1, p2;
	private Frame f = new Frame();
	private Color selectedColor;
	private Color fillColor;
	private Shape selectedShape;
	private PnlDrawing panel;

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		
		panel = this;	
		this.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent me) {
				
				if(item == null) {
					return;
				}
				switch (item) {
				
				case "Select":
					selectedShape = getSelectedShape(me.getX(), me.getY());
					if (selectedShape == null) {
						break;
					}
					
					EditPanel editPanel = new EditPanel(selectedShape, panel);
					editPanel.setVisible(true);
					
					break;	
				
				case "Point":
					Point p = new Point(me.getX(), me.getY());
					shapes.add(p);
					p.setColor(selectedColor);
					repaint();
					break;
					
				case "Line":
					if (p1 == null) {
						p1 = new Point(me.getX(), me.getY());
					} else {
						p2 = new Point(me.getX(), me.getY());
					}
					
					if (p1 != null && p2 != null) {
						Line l = new Line(p1, p2);
						l.setColor(selectedColor);
						shapes.add(l);
						repaint();
						clearPoints();
					}
					break;
					
				case "Rectangle":
					int width = 0;
					int height = 0;
					try {
						//Color colorEdgeRect = popUpColorChooser();
						//Color colorFillRect = popUpColorChooser();
						Point p4 = new Point(me.getX(), me.getY());
						String textWidth = JOptionPane.showInputDialog(f,"Enter width");
						String textHeight = JOptionPane.showInputDialog(f,"Enter height");
						if(textWidth != null || textHeight != null) {
							width = Integer.parseInt(textWidth);
							height = Integer.parseInt(textHeight);
							Rectangle r = new Rectangle(p4, width, height);
							shapes.add(r);
							r.setColor(selectedColor);
							r.setFillColor(fillColor);
							repaint();

						}
						
					} catch (Exception e2) {
						System.out.println("Invalid input or you pressed cancel button!");
						break;
					}
					break;
					
				case "Circle":
					int radius  ;
					String textRadius;
					Point p3;
					try {

						p3 = new Point(me.getX(), me.getY());
						textRadius = JOptionPane.showInputDialog(f,"Enter radius","");
						if( textRadius != null || textRadius.length() > 0  ) {
							radius = Integer.parseInt(textRadius);
							Circle c = new Circle(p3,radius);
							c.setCenter(p3);
							shapes.add(c);
							c.setColor(selectedColor);
							c.setFillColor(fillColor);
							
							repaint();
							
						}
					} catch (Exception e2) {
						System.out.println("Invalid input or you pressed cancel button!");
						break;
					}
					break;
					
				case "Donut":
					
					Point p5 = new Point(me.getX(), me.getY());
					int inner = 0;
					int radius1 = 0;
					try {
						//Color colorEdgeDonut = popUpColorChooser();
						String textInner = JOptionPane.showInputDialog(f,"Enter inner");
						String textRadius1 = JOptionPane.showInputDialog(f,"Enter radius");
						if(textInner != null || textRadius1 != null) {
						inner = Integer.parseInt(textInner);
						radius1 = Integer.parseInt(textRadius1);
						Donut d = new Donut(p5, radius1, inner);
						d.setColor(selectedColor);
						//d.setEdgecolor(colorEdgeDonut);
						shapes.add(d);
						repaint();
						break;
						}
						
					} catch (Exception e2) {
						System.out.println("Invalid input is 0 or you pressed cancel button!");
						break;
					}
				}
			}
			
		});

	}
	
	public void removeObject(Shape shape) {
		shapes.remove(shape);
		for (Shape shape1 : shapes) {
			
		}
	}
	
	private Shape getSelectedShape(int x, int y) {
		Shape selectedItem = null;
		
		for (Shape shape : shapes) {
			if(shape.contains(x, y)) {
				selectedItem = shape;
			}
		}
		return selectedItem;
	}
	
	//public Shape getSelectedShape() {
	//	return selectedShape;
	//}
	
	public Color popUpColorChooser() {
		
		Color initialColor = Color.black;
		Color color = JColorChooser.showDialog(panel, "select color", initialColor);
		return color;
	}
	
	 private void clearPoints() {
		 p1 = null;
		 p2 = null;
	 }
	 

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public void setSelectedColor(Color color) {
		this.selectedColor = color;
	}
	
	public void setFillColor(Color color) {
		this.fillColor = color;
	}
	
	 public void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
		 
		 for (Shape shape : shapes) {
			 shape.draw(g);
		}
			MainFrm.Instance().refreshScreen();
		 
		 
	 }
	 


}
