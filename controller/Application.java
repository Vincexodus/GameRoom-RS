package controller;

import view.*;
import model.*;

public class Application {
	public static RegisterPage register = new RegisterPage();
	public static LoginPage login = new LoginPage();
	public static GamePage game = new GamePage();
	public static AdminPage admin = new AdminPage();
	public static Student sObj;
	public static Admin aObj;
	
	public static void main(String[] args) {
		DataIO.read();
		
	}
}
