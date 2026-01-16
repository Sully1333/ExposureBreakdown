package ExposureBreakdown;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExposureBreakdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path filePath = Paths.get("C:\\Users\\cjsul\\Downloads\\UD_2.csv");
		String[] fileDetails = null;
		ArrayList<TeamDetails> teams = new ArrayList<>();
		ArrayList<String> teamNames = new ArrayList<>();
		int interestedCounter = 0;
        try {
            String content = Files.readString(filePath);
            fileDetails = content.split("\n");
            String[] playerDetails = null;
            String pn = "";
            String pp = "";
            String pt = "";
            String pcon = "";
            String nflT = "";
            int pc = 0;
            for(int i = 0; i < fileDetails.length; i++ ) {
            	pc++;
            	//System.out.println("EACH " + fileDetails[i]);
            	playerDetails = fileDetails[i].split(",");
        		TeamDetails newTeam = new TeamDetails("");

            	if ( playerDetails.length>0 ) {
            		pn = playerDetails[3] + " " + playerDetails[4];
            		pp = playerDetails[6];
            		nflT = playerDetails[5];
            		pt = playerDetails[7];
            		pcon = playerDetails[12];
            		//team = new TeamDetails(pt);
            		if ( teamNames.contains(pt) ) {
            			getTeam(pt,teams).addPlayer(pn, nflT, pp);
            		} else {
            			teamNames.add(pt);
            			newTeam = new TeamDetails(pt);
            			teams.add(newTeam);
                		newTeam.addPlayer(pn, nflT, pp);
                		newTeam.setContest(pcon);
            		}

            		

            	}
            }
            System.out.println(teams.size());
            for ( TeamDetails td : teams ) {
             //  if ( td.checkTeam("HOU","CAR") ) {
              //  	interestedCounter++;
            //    }
            	
            if ( td.checkPlayers("Caleb Williams"
            		,"Colston Loveland") ) {
                  	interestedCounter++;
               }
            }
            System.out.println("TEAMS FOUND " + interestedCounter);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }		
	}
	
	public static TeamDetails getTeam(String s, ArrayList<TeamDetails> teamL) {
		TeamDetails defTeam = new TeamDetails("");
		for ( TeamDetails td : teamL ) {
			if ( td.getTN().equals(s) ) {
				defTeam = td;
			}
		}
		return defTeam;
		
	}

}

		
