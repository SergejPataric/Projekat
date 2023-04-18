package drawing;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private static MainFrm mainFrm;
	private JPanel contentPane;
	private String item;
	private PnlDrawing panel;
	/**
	 * Launch the application.
	 */
	public static MainFrm Instance() {
		if (mainFrm == null) {
			mainFrm = new MainFrm();
			
		}
		return mainFrm;
	}

	/**
	 * Create the frame.
	 */
	private MainFrm() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 398);
		setTitle("Pataric Sergej MH66/2017");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnPoint = new JButton("Point");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			panel.setItem("Point");
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPoint, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnPoint, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnPoint);
		
		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setItem("Line");
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLine, 0, SpringLayout.NORTH, btnPoint);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLine, 6, SpringLayout.EAST, btnPoint);
		contentPane.add(btnLine);
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setItem("Rectangle");
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnRectangle, 0, SpringLayout.NORTH, btnPoint);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnRectangle, 6, SpringLayout.EAST, btnLine);
		contentPane.add(btnRectangle);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setItem("Circle");
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCircle, 0, SpringLayout.NORTH, btnPoint);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCircle, 6, SpringLayout.EAST, btnRectangle);
		contentPane.add(btnCircle);
		
		JButton btnDonut = new JButton("Donut");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setItem("Donut");
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDonut, 0, SpringLayout.NORTH, btnPoint);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDonut, 6, SpringLayout.EAST, btnCircle);
		contentPane.add(btnDonut);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setItem("Select");
				//EditPanel editPanel = new EditPanel();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSelect, 0, SpringLayout.NORTH, btnPoint);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSelect, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnSelect);
		
		
		panel = new PnlDrawing();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 16, SpringLayout.SOUTH, btnPoint);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 15, SpringLayout.WEST, btnPoint);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, btnSelect);
		contentPane.add(panel);
		
		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Color fillColor = popUpColorChooser();
				panel.setFillColor(fillColor);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnColor, 0, SpringLayout.NORTH, btnPoint);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnColor, 47, SpringLayout.EAST, btnDonut);
		contentPane.add(btnColor);
		
		JButton btnEdgeColor = new JButton("Edge Color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = popUpColorChooser();
				panel.setSelectedColor(color);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEdgeColor, 8, SpringLayout.EAST, btnColor);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEdgeColor, 0, SpringLayout.SOUTH, btnPoint);
		contentPane.add(btnEdgeColor);
		this.setVisible(true);
		
		//SwingUtilities.updateComponentTreeUI(mainFrm);
		//mainFrm.setVisible(true);
		//this.repaint();
		
		//this.pack();

		

	}

	
	public Color popUpColorChooser() {
		
		Color initialColor = Color.black;
		Color color = JColorChooser.showDialog(panel, "select color", initialColor);
		return color;
}
	public void refreshScreen() {
		mainFrm.repaint(); 
	}
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
