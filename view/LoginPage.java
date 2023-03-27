package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import controller.Application;
import controller.DataIO;
import model.*;

public class LoginPage implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == register) {
				Application.register.getJframe().setTitle("Student Registration");
				Application.register.getJframe().setVisible(true);
				
			}else if(e.getSource() == login) {
				DataIO.isAdmin = admin.getState();
				String username = userText.getText();
				User exist = DataIO.valid(username, DataIO.isAdmin);
				if(exist != null) {
					String password = new String(passwordText.getPassword());
					if(password.equals(exist.getPassword())) {
						if(DataIO.isAdmin) {
							Application.admin.getJframe().setVisible(true);
						}else {
							Application.game.getJframe().setVisible(true);
						}
					}
					frame.setVisible(false);
				}else {
					throw new Exception();
				}
				
			}else if(e.getSource() == adminRegis) {
				String adminCode = JOptionPane.showInputDialog("Enter Admin Code: ");
				if(adminCode.equals("")) {
					DataIO.isAdmin = true;
					Application.register.getJframe().setTitle("Admin Registration");
					Application.register.getJframe().setVisible(true);
				}else {
					throw new Exception();
				}
			}
		}catch(Exception ex) {
//			ex.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Invalid input/User doesn't exist");
		}
	}
	
	private JFrame frame;
	public JFrame getJframe() {
		return frame;
	}
	
	private Button register = new Button("Register");
	private Button login = new Button("Login");
	private Button adminRegis = new Button("Admin");
	private CheckboxGroup cbg = new CheckboxGroup();
	private Checkbox student = new Checkbox("Student", cbg, true);
	private Checkbox admin = new Checkbox("Admin", cbg, false);
	private JTextField userText = new JTextField();
	private JPasswordField passwordText = new JPasswordField();

	public LoginPage() {
		frame = new JFrame("Game Room RS");
		frame.setSize(300, 150);
		frame.setLocation(700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel centerSec = new JPanel(new GridLayout(3, 2));
		JLabel userLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");
		centerSec.add(student);
		centerSec.add(admin);
		centerSec.add(userLabel);
		centerSec.add(userText);
		centerSec.add(passwordLabel);
		centerSec.add(passwordText);
		
		JPanel bottomSec = new JPanel();
		login.addActionListener(this);
		register.addActionListener(this);
		adminRegis.addActionListener(this);
		bottomSec.add(login);
		bottomSec.add(register);
		bottomSec.add(adminRegis);
		
		frame.add(centerSec, BorderLayout.CENTER);
		frame.add(bottomSec, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
}