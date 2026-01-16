package ExposureBreakdown;

public class Player {
	private String name = "";
	private String pos = "";
	private String team = "";
	
	Player () {};
	
	public Player(String name2, String team2, String pos2) {
		name = name2;
		team = team2;
		pos = pos2;
	}

	void setName(String pname) {
		name = pname;
	}
	
	String getName() {
		return name;
	}
	
	void setPos(String p) { pos = p; }
	String getPos() { return pos; }
	
	void setTeam(String t) { team = t; }
	String getTeam() { return team; }

}
