package model;

public class Rent {
	private static int initID = 9000;
	private int rentID;
	private Student renter;
	private Game game;
	private int timeIn;
	private double charge;
	
	public Rent(int rentID, Student renter, Game game, int timeIn, double charge) {
		super();
		this.renter = renter;
		this.game = game;
		this.timeIn = timeIn;
		this.charge = charge;
		this.rentID = getNextID();
	}
	
	public static int getNextID(){
        return initID += 1;
    }
	
	public static int getInitID() {
		return initID;
	}

	public static void setInitID(int initID) {
		Rent.initID = initID;
	}

	public int getRentID() {
		return rentID;
	}

	public void setRentID(int rentID) {
		this.rentID = rentID;
	}

	public Student getRenter() {
		return renter;
	}

	public void setRenter(Student renter) {
		this.renter = renter;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(int timeIn) {
		this.timeIn = timeIn;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}
	
    @Override
    public String toString() {
        return "Rent{" +
            "rentID=" + rentID +
            ", studentID=" + renter.getStudentID()+
            ", gameName=" + game +
            ", timeIn=" + timeIn+
            ", charge=" + charge + 
            '}';
    }
	
}
