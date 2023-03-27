package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.DataIO;
import model.Admin;
import model.Game;
import model.Rent;
import model.Student;

public class AdminPage implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
//			if(e.getSource() == register) {
//			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame, "");
		}
	}
	
	private JFrame frame;
	public JFrame getJframe() {
		return frame;
	}
	
	private JComboBox gameCb = new JComboBox(arrayParse("game"));
	private JComboBox studentCb = new JComboBox(arrayParse("student"));
	private JComboBox adminCb = new JComboBox(arrayParse("admin"));
	private JComboBox rentCb = new JComboBox(arrayParse("rent"));
	private JLabel rentRate = new JLabel("$4.5/HR");
	
//	private Button uploadGame = new Button("Upload Game");
	private Button deleteGame = new Button("Delete");
	private Button editRate = new Button("Edit Rate");
	private Button addAdmin = new Button("Add Admin");
	private Button addStudent = new Button("Add Student");
	private Button addRent = new Button("Add Rent");
	
	private JLabel totalStudent = new JLabel();
	private JLabel totalAdmin = new JLabel();
	private JLabel bestGame = new JLabel();
	private JLabel avgHour = new JLabel();
	private JLabel totalRent = new JLabel();
	private JLabel totalSale = new JLabel();
	
	// use 2*6 grid and loop with key and value array
	public AdminPage() {
		frame = new JFrame("Admin Homepage");
		frame.setSize(500, 175);
		frame.setLocation(800, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JPanel topRight = new JPanel(new GridLayout(1, 2));
		editRate.addActionListener(this);
		deleteGame.addActionListener(this);
		topRight.add(rentRate);
		topRight.add(editRate);
		topRight.add(deleteGame);
		
		JPanel topSec = new JPanel(new GridLayout(1, 2));
		topSec.add(gameCb);
		topSec.add(topRight);
		
		JPanel centerSec = new JPanel(new GridLayout(3, 1));
		centerSec.add(studentCb);
		centerSec.add(adminCb);
		centerSec.add(rentCb);

		JPanel bottomSec = new JPanel(new GridLayout(6, 1));
		totalStudent.setText("Students" + "\t" + DataIO.studentList.size());
		totalAdmin.setText("Admins" + "\t" + DataIO.adminList.size());
		bestGame.setText("Most played" + "\t" + DataIO.gameList.size());
		avgHour.setText("Average Time Spend" + "\t" + DataIO.rentList.size());
		totalRent.setText("Total Rents" + "\t" + DataIO.rentList.size());
		totalSale.setText("Total Sales" + "\t" + DataIO.rentList.size());
		bottomSec.add(totalStudent);
		bottomSec.add(totalAdmin);
		bottomSec.add(bestGame);
		bottomSec.add(avgHour);
		bottomSec.add(totalRent);
		bottomSec.add(totalSale);
		
		frame.add(topSec, BorderLayout.NORTH);
		frame.add(centerSec, BorderLayout.CENTER);
		frame.add(bottomSec, BorderLayout.SOUTH);
		
		frame.setVisible(false);
	}
	public static String[] arrayParse(String obj) {
		DataIO.read();
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			if(obj.equals("student")) {
				for(Student s : DataIO.studentList) {
					arrayList.add(s.getUserName());
				}			
			}else if(obj.equals("admin")) {
				for(Admin a : DataIO.adminList) {
					arrayList.add(a.getUserName());
				}
			}else if(obj.equals("game")) {
				for(Game g : DataIO.gameList) {
					arrayList.add(g.getName());
				}
			}else if(obj.equals("rent")) {
				for(Rent r: DataIO.rentList) {
					arrayList.add(Integer.toString(r.getRentID()));
				}
			}else {
				throw new Exception();
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Parse error");
		}
		
		return arrayList.toArray(new String[arrayList.size()]);
	}
}
	