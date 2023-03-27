package controller;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.*;

public class DataIO {
	public static ArrayList<Student> studentList = new ArrayList<Student>();
	public static ArrayList<Admin> adminList = new ArrayList<Admin>();
	public static ArrayList<Game> gameList = new ArrayList<Game>();
	public static ArrayList<Rent> rentList = new ArrayList<Rent>();
	public static boolean isAdmin = false;
	
	public static void read() {
		try {
			// read student file
			Scanner s = new Scanner(new File("student.txt"));
			studentList.clear();
			while(s.hasNext()) {
				String id = s.nextLine();
				String name = s.nextLine();
				String password = s.nextLine();
				String gender = s.nextLine();
				String age = s.nextLine();
				s.nextLine();
				studentList.add(new Student(Integer.parseInt(id), name, password, gender, Integer.parseInt(age)));					
			}
			// read admin file
			s = new Scanner(new File("admin.txt"));
			adminList.clear();
			while(s.hasNext()) {
				String id = s.nextLine();
				String name = s.nextLine();
				String password = s.nextLine();
				String gender = s.nextLine();
				String age = s.nextLine();
				s.nextLine();
				adminList.add(new Admin(Integer.parseInt(id), name, password, gender, Integer.parseInt(age)));
			}
			
			// read res folder
			File imgDir = new File("res/");
		    String imgName[] = imgDir.list();
		    gameList.clear();
		    for(int i=0; i<imgName.length; i++) {
		    	String gameName = imgName[i].substring(0, imgName[i].indexOf("."));
		    	gameList.add(new Game(500, capitalize(gameName), 0));
		    }
		    
		    // read rent file
		    s = new Scanner(new File("rent.txt"));
		    rentList.clear();
			while(s.hasNext()) {
				String id = s.nextLine();
				String student = s.nextLine();
				String game = s.nextLine();
				String timeIn = s.nextLine();
				String charge = s.nextLine();
				s.nextLine();
				Student std = (Student) valid(student, false);
				Game gam = gSearch(game);
				rentList.add(new Rent(Integer.parseInt(id), std, gam, Integer.parseInt(timeIn),Double.parseDouble(charge)));
			}
		}catch(Exception e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Read error");
		}
	}
	
	public static void write() {
		try {
			// write student file
			PrintWriter sw = new PrintWriter("student.txt");
			for(Student s : studentList) {
				sw.println(s.getStudentID());
				sw.println(s.getUserName());
				sw.println(s.getPassword());
				sw.println(s.getGender());
				sw.println(s.getAge());
				sw.println();
			}
			sw.close();
			
			// write admin file
			PrintWriter aw = new PrintWriter("admin.txt");	
			for(Admin a : adminList) {
				aw.println(a.getAdminID());
				aw.println(a.getUserName());
				aw.println(a.getPassword());
				aw.println(a.getGender());
				aw.println(a.getAge());
				aw.println();
			}
			aw.close();
			
			// write game file
			PrintWriter gw = new PrintWriter("game.txt");
			for(Game g : gameList) {
				gw.println(g.getGameID());
				gw.println(g.getName());
				gw.println(g.getRate());
				gw.println();
			}
			gw.close();
			
			// write rent file
			PrintWriter rw = new PrintWriter("rent.txt");
			for(Rent r : rentList) {
				rw.println(r.getRentID());
				rw.println(r.getRenter().getUserName());
				rw.println(r.getGame().getName());
				rw.println(r.getTimeIn());
				rw.println(r.getCharge());
				rw.println();
			}
			rw.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Write error");
		}
	}
	public static User valid(String name, boolean isAdmin) {
		if(!isAdmin) {
			Student found = null;
			for(Student s : studentList) {
				if(name.equals(s.getUserName())) {
					found = s;
				}
			}
			return found;
		}else {
			Admin found = null;
			for(Admin a : adminList) {
				if(name.equals(a.getUserName())) {
					found = a;
				}
			}		
			return found;
		}
	}
	
	public static Game gSearch(String name) {
		Game found = null;
		for(Game g : gameList) {
			if(name.equals(g.getName())) {
				found = g;
			}
		}
		return found;
	}
	
	public static final String capitalize(String str)   
	{  
	if (str == null || str.length() == 0) return str;  
	return str.substring(0, 1).toUpperCase() + str.substring(1);  
	}  
}
