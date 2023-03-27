package model;

public class Admin extends User{
	private static int initID = 1000;
	private int adminID;
	
	public Admin(int adminID, String username, String password, String gender, int age) {
		super(username, password, gender, age);
		this.adminID = getNextID();
	}

	public static int getInitID() {
		return initID;
	}

	public static void setInitID(int initID) {
		Admin.initID = initID;
	}
	
	public static int getNextID() {
        return initID += 1;
    }
	
    public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	@Override
    public String toString() {
        return super.toString() +
                ", adminID=" + adminID + '\'' +
                '}';
    }
	
}
