package ExposureBreakdown;

import java.util.ArrayList;

public class TeamDetails {
	
	public String teamName = "";
	public String teamCon = "";
	public ArrayList<Player> players = new ArrayList<Player>();
		
	TeamDetails(String s) {
		teamName = s;
	}
	
	void setContest(String con) {
		teamCon = con;
	}
	
	public String getContest() {
		return teamCon;
	}
	
	void setTN(String tn) { teamName = tn; }
	public String getTN () { return teamName; }
	
	void addPlayer(String name, String team, String pos) {
		Player p = new Player(name,team,pos);
		players.add(p);
	}

	void printPlayers() {
		ArrayList<String> playerDetails = new ArrayList<String>();
		System.out.println(" TEAM NAME " + teamName);
		System.out.println("CONT " + teamCon);
		for ( Player pp : players ) {
			playerDetails.add(pp.getName()+"-"+pp.getTeam() + "-"+pp.getPos());
		}
		playerDetails.sort(null);
		for (String s : playerDetails) {
			System.out.println(s);
		}
	}
	
	boolean checkTeam(String team1, String team2) {
		boolean teamInt = false;
		int team1c = 0;
		int team2c = 0;
		int teamC = 0;
		for ( Player pp : players ) {
			if ( pp.getTeam().equals(team1) )
				team1c++;
			if ( pp.getTeam().equals(team2) )
				team2c++;
		}
		
		if ( team1c>=1 && team2c>=2 ) {
			teamC++;
			teamInt = true;
			System.out.println(team1+" vs " +team2);
			printPlayers();
		}
		return teamInt;
	}
	
	boolean checkPlayers(String team1, String team2) {
		boolean teamInt = false;
		int team1c = 0;
		int team2c = 0;
		int teamC = 0;
		for ( Player pp : players ) {
			if ( pp.getName().equals(team1) )
				team1c++;
			if ( pp.getName().equals(team2) )
				team2c++;
		}
		
		if ( team1c>=1 && team2c>=1 ) {
			teamC++;
			teamInt = true;
			System.out.println(team1+" vs " +team2);
			printPlayers();
		}
		return teamInt;
	}
	
}
