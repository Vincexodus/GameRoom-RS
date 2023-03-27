package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class GamePage implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
//			if(e.getSource() == register) {
//			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame, "Username Exists/Invalid Input");
		}
	}
	
	private JFrame frame;
	public JFrame getJframe() {
		return frame;
	}
	private String country[]={"India","Aus","U.S.A","England","Newzealand"};        
	private JComboBox gameCb = new JComboBox(country);
	private JLabel rentRate = new JLabel("$4.5/HR");
	private JSpinner inSpin = new JSpinner(new SpinnerNumberModel(8, 8, 23, 1));
	private JSpinner outSpin = new JSpinner(new SpinnerNumberModel(8, 8, 23, 1));
	private Button confirm = new Button("Confirm");
	
	public GamePage() {
		frame = new JFrame("GameRoom Page");
		frame.setSize(400, 420);
		frame.setLocation(800, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel topSec = new JPanel();
		try {
			BufferedImage myPicture = ImageIO.read(this.getClass().getResource("/res/monopoly.jpg"));
			Image newImage = myPicture.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
			JLabel picLabel = new JLabel(new ImageIcon(newImage));
			topSec.add(picLabel);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		JPanel centerSec = new JPanel(new GridLayout(1, 2));
		centerSec.add(gameCb);
		centerSec.add(rentRate);
		
		JPanel leftBottom = new JPanel(new GridLayout(2, 2));
		JLabel inText = new JLabel("Time In");
		JLabel outText = new JLabel("Time Out");
		inSpin.setEditor(new JSpinner.DefaultEditor(inSpin));
		outSpin.setEditor(new JSpinner.DefaultEditor(outSpin));
		leftBottom.add(inText);
		leftBottom.add(inSpin);
		leftBottom.add(outText);
		leftBottom.add(outSpin);
		
		JPanel bottomSec = new JPanel(new GridLayout(1, 2));
		confirm.addActionListener(this);
		bottomSec.add(leftBottom);
		bottomSec.add(confirm);
		
		frame.add(topSec, BorderLayout.NORTH);
		frame.add(centerSec, BorderLayout.CENTER);
		frame.add(bottomSec, BorderLayout.SOUTH);
		
		frame.setVisible(false);
	}
	
}
	