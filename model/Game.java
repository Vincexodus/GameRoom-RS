package model;

public class Game {
	private static int initID = 9000;
	private int gameID;
	private String name;
	private double rate;
	
	public Game(int gameID, String name, double rate) {
		super();
		this.name = name;
		this.rate = rate;
		this.gameID = getNextID();
	}
	
	public static int getNextID(){
        return initID += 1;
    }
	
	public static int getInitID() {
		return initID;
	}

	public static void setInitID(int initID) {
		Game.initID = initID;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
    public String toString() {
        return "Game{" +
            "gameID=" + gameID +
            ", gameName=" + name+
            ", rate=" + rate+ 
            '}';
    }
	
}
