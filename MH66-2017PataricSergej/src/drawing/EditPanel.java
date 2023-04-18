package drawing;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPanel extends JDialog {

	private JPanel contentPane;
	private JPanel editPanel;
	private JLabel lblX = new JLabel();
	private JLabel lblY = new JLabel();
	private JLabel lblWidth = new JLabel();
	private JLabel lblHeight = new JLabel();
	private JLabel lblRadius = new JLabel();
	private JLabel lblInnerRadius = new JLabel();
	private JLabel lblX2 = new JLabel();
	private JLabel lblY2 = new JLabel();
	private	JLabel lblClass = new JLabel();
	private JButton exitButton;
	private JButton editButton;
	private JFrame f = new JFrame();
	private JButton deleteButton;
	private String name;
	private Shape shape;
	
	/*private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			EditPanel dialog = new EditPanel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * Create the dialog.
	 */
	private final JPanel contentPanel = new JPanel();
	
	public EditPanel(final Shape selectedShape, final PnlDrawing panel) {
		setBounds(100, 100, 450, 300);
		setModal(true);
		
		shape = selectedShape;
		name =  selectedShape.getClass().getSimpleName();
		
		//System.out.println(name);
		
		
			
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		switch(name) {
		case "Point":
			setValuesForPoint();
			break;
		case "Line":
			setValuesForLine();
			break;
		case "Rectangle":
			setValuesForRect();
			break;
		case "Circle":
			setValuesForCircle();
			break;
		case "Donut":
			setValuesForDonut();
			break;
		default:
			break;
		}
		
		springLayout.putConstraint(SpringLayout.NORTH, lblClass, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblClass, 181, SpringLayout.WEST, getContentPane());
		lblClass.setVisible(true);
		getContentPane().add(lblClass);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblX, 36, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblX, 118, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblX);
		

		springLayout.putConstraint(SpringLayout.NORTH, lblY, 0, SpringLayout.NORTH, lblX);
		springLayout.putConstraint(SpringLayout.WEST, lblY, 92, SpringLayout.EAST, lblX);
		getContentPane().add(lblY);
		

		springLayout.putConstraint(SpringLayout.NORTH, lblX2, 6, SpringLayout.SOUTH, lblX);
		springLayout.putConstraint(SpringLayout.WEST, lblX2, 0, SpringLayout.WEST, lblX);
		getContentPane().add(lblX2);
		

		springLayout.putConstraint(SpringLayout.NORTH, lblY2, 6, SpringLayout.SOUTH, lblY);
		springLayout.putConstraint(SpringLayout.WEST, lblY2, 0, SpringLayout.WEST, lblY);
		getContentPane().add(lblY2);
		

		springLayout.putConstraint(SpringLayout.NORTH, lblWidth, 99, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblWidth, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblWidth);
		

		springLayout.putConstraint(SpringLayout.NORTH, lblHeight, 16, SpringLayout.SOUTH, lblWidth);
		springLayout.putConstraint(SpringLayout.WEST, lblHeight, 0, SpringLayout.WEST, lblWidth);
		getContentPane().add(lblHeight);
		

		springLayout.putConstraint(SpringLayout.NORTH, lblRadius, 17, SpringLayout.SOUTH, lblHeight);
		springLayout.putConstraint(SpringLayout.WEST, lblRadius, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblRadius);
		

		springLayout.putConstraint(SpringLayout.NORTH, lblInnerRadius, 19, SpringLayout.SOUTH, lblRadius);
		springLayout.putConstraint(SpringLayout.WEST, lblInnerRadius, 0, SpringLayout.WEST, lblWidth);
		getContentPane().add(lblInnerRadius);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (name) {
				case "Point":
					try {
						int x = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter x:"));
						int y = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter y:")); 
						Color newPointColor = panel.popUpColorChooser();
						Point p = (Point) shape;
						p.setColor(newPointColor);
						p.setX(x);
						p.setY(y);
					} catch (Exception e2) {
						System.out.println("Cancel button or wrong number imput!");
					}
						
						break;
				case "Line":
					try {
						int x1 = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter x of first point:"));
						int y1 = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter y of first point:")); 
						int x2 = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter x of second point:"));
						int y2 = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter y of second point:")); 
					
						if(x1 == 0 || y2 == 0) {
							break;
						}
						Line l = (Line) shape;
						Color newLineColor = panel.popUpColorChooser();
						Point tempStart = l.getStartPoint();
						tempStart.setX(x1);
						tempStart.setY(y1);
						Point tempEnd = l.getEndPoint();
						tempEnd.setX(x2);
						tempEnd.setY(y2);
						l.setColor(newLineColor);
						l.setStartPoint(tempStart);
						l.setEndPoint(tempEnd);
					} catch (Exception e2) {
						System.out.println("Cancel button or wrong number imput!");
					}
					
						break;
				case "Circle":
					try {
						int circleX = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter x of center:"));
						int circleY = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter y of center:"));
						int circleR = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter radius:"));
						Color newCircleEdgeColor = panel.popUpColorChooser();
						Color newCircleFillcolor = panel.popUpColorChooser();
						Circle c = (Circle) shape;
						Point centerP = c.getCenter();
						c.setColor(newCircleEdgeColor);
						c.setFillColor(newCircleFillcolor);
						centerP.setX(circleX);
						centerP.setY(circleY);
						try {
							c.setRadius(circleR) ;
						} catch (Exception e1) {
							System.out.println("mora biti broj veci od 1");
						}	
					} catch (Exception e2) {
						System.out.println("Cancel button or wrong number input!");
					}
					
					break;
				case "Rectangle":
					try {
						int rectX = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter x of upper left:"));
						int rectY = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter y of upper left:"));
						int rectWidth = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter width:"));
						int rectHeight = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter height:"));
						Rectangle r = (Rectangle) shape;
						Color newRectEdgeColor = panel.popUpColorChooser();
						Color newRectFillcolor = panel.popUpColorChooser();
						Point upperLeft = r.getUpperLeft();
						r.setColor(newRectEdgeColor);
						r.setFillColor(newRectFillcolor);
						upperLeft.setX(rectX);
						upperLeft.setY(rectY);
						r.setWidth(rectWidth);
						r.setHeight(rectHeight);
					} catch (Exception e2) {
						System.out.println("Cancel button or wrong number input!");
					}
				break;
				case "Donut":
					try {
						int donutX = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter x of center:"));
						int donutY = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter y of center:"));
						int donutInner = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter inner radius:"));
						int donutR = Integer.parseInt( JOptionPane.showInputDialog(f,"Enter radius:"));
						Donut d = (Donut) shape;
						Point centerDonut = d.getCenter();
						Color newDonutColor = panel.popUpColorChooser();
						centerDonut.setX(donutX);
						centerDonut.setY(donutY);
						d.setColor(newDonutColor);
						try {
							d.setRadius(donutR);
						} catch (Exception e1) {
							System.out.println("mora biti broj veci od 1");
						}
						d.setInnerRadius(donutInner);
					} catch (Exception e2) {
						System.out.println("Cancel button or wrong number input!");
					}
					break;
				}
				
				switch(name) {
				case "Point":
					setValuesForPoint();
					break;
				case "Line":
					setValuesForLine();
					break;
				case "Rectangle":
					setValuesForRect();
					break;
				case "Circle":
					setValuesForCircle();
					break;
				case "Donut":
					setValuesForDonut();
					break;
				default:
					break;
				}
				
				panel.validate();
				
				panel.repaint();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnEdit, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int result = JOptionPane.showConfirmDialog(f,"Wanna delete object?", "Notifaction",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	panel.removeObject(selectedShape);
							panel.repaint();
							dispose();
			            }else if (result == JOptionPane.NO_OPTION){
			            	
							dispose();
			            }
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, -32, SpringLayout.WEST, btnDelete);
		springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 0, SpringLayout.NORTH, btnEdit);
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, 0, SpringLayout.WEST, lblClass);
		getContentPane().add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	repaint();
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnExit, 0, SpringLayout.NORTH, btnEdit);
		springLayout.putConstraint(SpringLayout.WEST, btnExit, 32, SpringLayout.EAST, btnDelete);
		getContentPane().add(btnExit);
		
		
	}
	
	private void setValuesForPoint()
	{
		Point p = (Point) shape;
		lblClass.setText(name);
		String textX = Integer.toString(p.getX());
		String textY = Integer.toString(p.getY());
		lblX.setText("x: " + textX);
		lblY.setText("y: " + textY);
		lblWidth.setVisible(false);
		lblHeight.setVisible(false);
		lblX2.setVisible(false);
		lblY2.setVisible(false);
		lblRadius.setVisible(false);
		lblInnerRadius.setVisible(false);
		
	}
	
	private void setValuesForLine() {
		Line l = (Line) shape;
		lblClass.setText(name);
		Point startPoint = l.getStartPoint();
		Point endPoint = l.getEndPoint();
		String textX = Integer.toString(startPoint.getX());
		String textY = Integer.toString(startPoint.getY());
		String textX2 = Integer.toString(endPoint.getX());
		String textY2 = Integer.toString(endPoint.getY());
		lblX.setText("x: " + textX);
		lblY.setText("y: " + textY);
		lblX2.setText("x2: " + textX2);
		lblY2.setText("y2: " + textY2);
		lblWidth.setVisible(false);
		lblHeight.setVisible(false);
		lblRadius.setVisible(false);
		lblInnerRadius.setVisible(false);
	}
	
	private void setValuesForRect() {
		Rectangle r = (Rectangle) shape;
		lblClass.setText(name);
		Point p = r.getUpperLeft();
		String textX = Integer.toString(p.getX());
		String textY = Integer.toString(p.getY());
		lblX.setText("x: " + textX);
		lblY.setText("y: " + textY);
		String textWidth = Integer.toString(r.getWidth());
		String textHeight = Integer.toString(r.getHeight());
		lblWidth.setText("width: "  + textWidth);
		lblHeight.setText("height: " + textHeight);
		lblX2.setVisible(false);
		lblY2.setVisible(false);
		lblRadius.setVisible(false);
		lblInnerRadius.setVisible(false);
	}
	
	private void setValuesForCircle() {
		Circle c = (Circle) shape;
		lblClass.setText(name);
		Point p = c.getCenter();
		String textX = Integer.toString(p.getX());
		String textY = Integer.toString(p.getY());
		lblX.setText("x: " + textX);
		lblY.setText("y: " + textY);
		String textRadius = Integer.toString(c.getRadius());
		lblRadius.setText("radius: " + textRadius);
		lblWidth.setVisible(false);
		lblHeight.setVisible(false);
		lblX2.setVisible(false);
		lblY2.setVisible(false);
		lblInnerRadius.setVisible(false);
	}
	
	private void setValuesForDonut() {
		Donut d = (Donut) shape;
		lblClass.setText(name);
		Point p = d.getCenter();
		String textX = Integer.toString(p.getX());
		String textY = Integer.toString(p.getY());
		lblX.setText("x: " + textX);
		lblY.setText("y: " + textY);
		String textRadius = Integer.toString(d.getRadius());
		lblRadius.setText("radius:" + textRadius);
		String textInner = Integer.toString(d.getInnerRadius());
		lblInnerRadius.setText("inner radius: " + textInner);
		lblWidth.setVisible(false);
		lblHeight.setVisible(false);
		lblX2.setVisible(false);
		lblY2.setVisible(false);
	}
	
	
}
