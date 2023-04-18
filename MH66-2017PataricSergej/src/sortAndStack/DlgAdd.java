package sortAndStack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgAdd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	private boolean check;
		
	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public void setTextFieldX(JTextField textFieldX) {
		this.textFieldX = textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public void setTextFieldY(JTextField textFieldY) {
		this.textFieldY = textFieldY;
	}

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public void setTextFieldRadius(JTextField textFieldRadius) {
		this.textFieldRadius = textFieldRadius;
	}
	
	

	public boolean isCheck() {
		return check;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAdd dialog = new DlgAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public DlgAdd() {
		setBounds(100, 100, 319, 255);
		setTitle("Add circle");
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		
		JLabel lblX = new JLabel("Centre x coordinate");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblX, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblX, 10, SpringLayout.WEST, contentPanel);
		contentPanel.add(lblX);
		
		JLabel lblY = new JLabel("Centre y coordinate");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblY, 29, SpringLayout.SOUTH, lblX);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblY, 0, SpringLayout.WEST, lblX);
		contentPanel.add(lblY);
		
		JLabel lblRadius = new JLabel("Circle radius");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblRadius, 33, SpringLayout.SOUTH, lblY);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblRadius, 10, SpringLayout.WEST, contentPanel);
		contentPanel.add(lblRadius);
		
		textFieldX = new JTextField();
		textFieldX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
			}
		});
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textFieldX, -4, SpringLayout.NORTH, lblX);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textFieldX, 93, SpringLayout.EAST, lblY);
		textFieldX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(textFieldX);
		textFieldX.setColumns(10);
		
		textFieldY = new JTextField();
		textFieldY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
			}
		});
		sl_contentPanel.putConstraint(SpringLayout.WEST, textFieldY, 30, SpringLayout.EAST, lblY);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textFieldY, -79, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, textFieldX, 0, SpringLayout.WEST, textFieldY);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textFieldY, -3, SpringLayout.NORTH, lblY);
		textFieldY.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(textFieldY);
		textFieldY.setColumns(10);
		
		textFieldRadius = new JTextField();
		textFieldRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
			}
		});
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textFieldRadius, -3, SpringLayout.NORTH, lblRadius);
		sl_contentPanel.putConstraint(SpringLayout.WEST, textFieldRadius, 0, SpringLayout.WEST, textFieldX);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textFieldRadius, -5, SpringLayout.EAST, textFieldX);
		textFieldRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(textFieldRadius);
		textFieldRadius.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textFieldX.getText().trim().isEmpty() || textFieldY.getText().trim().isEmpty() || textFieldRadius.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Text box must not be empty", "Error", JOptionPane.WARNING_MESSAGE);
							check = false; 
							dispose(); 
						}
						else {
							check = true; 
							setVisible(false);
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
}
