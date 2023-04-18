package sortAndStack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class FrmStack extends JFrame {


	private JPanel contentPane;
	public JList list;
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();
	Stack<Circle> stack = new Stack<Circle>();
	
	public DefaultListModel<Circle> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<Circle> dlm) {
		this.dlm = dlm;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmStack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 247, 379);
		setTitle("Stack");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Pataric Sergej MH66/2017");

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		list = new JList();
		list.setModel(dlm);
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, 227, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, 211, SpringLayout.WEST, contentPane);
		contentPane.add(list);
		
		JButton btnRemove = new JButton("Remove Circle");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnRemove, 55, SpringLayout.WEST, contentPane);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.remove(0);
			}
		});
		contentPane.add(btnRemove);
		
		JButton btnAdd = new JButton("Add Circle");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnRemove, 6, SpringLayout.SOUTH, btnAdd);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAdd, 64, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAdd, 6, SpringLayout.SOUTH, list);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAdd dr = new DlgAdd();
				dr.setVisible(true);
				if(dr.isCheck()) {
					Circle c1 = new Circle();
					int flag = 0;
					try {
						c1 = new Circle(new Point(Integer.parseInt(dr.getTextFieldX().getText().toString()),Integer.parseInt(dr.getTextFieldY().getText().toString())),
								Integer.parseInt(dr.getTextFieldRadius().getText().toString()));
						
						
					}catch(Exception ex) {
						flag = 1;
						JOptionPane.showMessageDialog(null, "You can not enter string for value");  
						
					}
					if(c1.getRadius() < 0) {
						JOptionPane.showMessageDialog(null, "You need to enter positive values!");
						dr.dispose();				
					}
					else {
						if(flag == 0) { 
							
							dlm.insertElementAt(c1, 0);
			
				}
			}
		}}});
		contentPane.add(btnAdd);
				
		JButton btnSort = new JButton("Sort list");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSort, 6, SpringLayout.SOUTH, btnRemove);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSort, 0, SpringLayout.EAST, btnAdd);
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Circle> list = new ArrayList<>();
				for (int i = 0; i < dlm.getSize(); i++) {
				    list.add(dlm.getElementAt(i));
				}
				Collections.sort(list, Collections.reverseOrder());
				dlm.clear();
				for (Circle o : list) {
				    dlm.addElement(o);
				}
			}
		});
		contentPane.add(btnSort);
	}
}
