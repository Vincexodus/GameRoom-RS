package model;

public class Student extends User{
	private static int initID = 2000;
	private int studentID;
	
	public Student(int studentID, String username, String password, String gender, int age) {
		super(username, password, gender, age);
		this.studentID = getNextID();
	}
	
    public static int getInitID() {
		return initID;
	}

	public static void setInitID(int initID) {
		Student.initID = initID;
	}
	
	public static int getNextID() {
        return initID += 1;
    }

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	@Override
    public String toString() {
        return super.toString() +
                ", studentID=" + studentID + '\'' +
                '}';
    }
}


