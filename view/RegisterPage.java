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

import controller.DataIO;
import model.*;

public class RegisterPage implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == register) {
				String username = userText.getText().toLowerCase();
				User exist = DataIO.valid(username, DataIO.isAdmin);
				if(exist == null) {
					String password = new String(passwordText.getPassword());
					int age = Integer.parseInt(ageText.getText());
					if(DataIO.isAdmin) {
						DataIO.adminList.add(new Admin(1000, username, password, isMale(male.getState()), age));						
					}
					else {
						DataIO.studentList.add(new Student(1000, username, password, isMale(male.getState()), age));				
					}
					DataIO.write();
					frame.setVisible(false);
				}else {
					throw new Exception();
				}
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame, "Username Exists/Invalid Input");
		}
	}
	
	private JFrame frame;
	public JFrame getJframe() {
		return frame;
	}
	private Button register = new Button("Register");
	private JTextField userText = new JTextField();
	private JPasswordField passwordText = new JPasswordField();
	private CheckboxGroup cbg = new CheckboxGroup();
	private Checkbox female = new Checkbox("Female", cbg, false);
	private Checkbox male = new Checkbox("Male", cbg, false);
	private JTextField ageText = new JTextField();
    
	public RegisterPage() {
		frame = new JFrame();
		frame.setSize(300, 175);
		frame.setLocation(800, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel centerSec = new JPanel(new GridLayout(4, 2));
		JLabel userLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");
		JLabel ageLabel = new JLabel("Age");
		centerSec.add(userLabel);
		centerSec.add(userText);
		centerSec.add(passwordLabel);
		centerSec.add(passwordText);
		centerSec.add(female);
		centerSec.add(male);
		centerSec.add(ageLabel);
		centerSec.add(ageText);
		
		JPanel bottomSec = new JPanel();
		register.addActionListener(this);
		bottomSec.add(register);
		
		frame.add(centerSec, BorderLayout.CENTER);
		frame.add(bottomSec, BorderLayout.SOUTH);
		
		frame.setVisible(false);
	}
	
	public String isMale(boolean male) {
		if(male) {
			return "male";
		}else {
			return "female";
		}
	}
}
