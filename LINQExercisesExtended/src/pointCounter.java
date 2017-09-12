import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;


class team {
    String name;
    LinkedHashMap<String, Integer> playersAndPoints = new LinkedHashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedHashMap<String, Integer> getPlayersAndPoints() {
        return playersAndPoints;
    }

    public void setPlayersAndPoints(LinkedHashMap<String, Integer> playersAndPoints) {

        this.playersAndPoints = playersAndPoints;
    }
}
public class pointCounter {
    public static team createUnexistingTeam(String[] newTeamToCreate){
        int points=Integer.parseInt(newTeamToCreate[2]);
        LinkedHashMap<String, Integer> playerAndPoints=new LinkedHashMap<>();
        team newTeam=new team();
        if(isItTeamsName(newTeamToCreate[0])){
            newTeam.setName(newTeamToCreate[0]);
            playerAndPoints.put(newTeamToCreate[1],points);
            newTeam.setPlayersAndPoints(playerAndPoints);


        }
        else{
            newTeam.setName(newTeamToCreate[1]);
            playerAndPoints.put(newTeamToCreate[0],points);
            newTeam.setPlayersAndPoints(playerAndPoints);
        }
        return newTeam;
    }
    public static boolean isItTeamsName(String teamOrNot){
        boolean itIsteam=true;
        for(int i=0;i<teamOrNot.length();i++){
            //Character current=teamOrNot.charAt(i);
            if(Character.isLowerCase(teamOrNot.charAt(i))){
                itIsteam=false;
                break;
            }
        }
        return itIsteam;
    }
    //those two methods are to clean the input joinedCleanString and cleanStrings
    public static String joinedCleanString(String[] polluted){
        StringBuilder cleanString=new StringBuilder();
        for (String s : polluted) {
            cleanString.append(s);

        }
        return cleanString.toString();
    }
    public static String[] cleanStrings(String[] polluted) {
        String[] clean=new String[polluted.length];
        String[] current;

        for(int i=0;i<polluted.length;i++) {
            current = polluted[i].split("\\W");
            clean[i]=joinedCleanString(current);
//
        }
        return clean;


    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] pollutedStrings = scan.nextLine().split("\\|");
        ArrayList<team> listOfAllTeams=new ArrayList<team>();
        while(!pollutedStrings[0].equals("Result")){
            String[] cleanStrings=cleanStrings(pollutedStrings);
            //team currentTeam=new team(createUnexistingTeam());
            if(!listOfAllTeams.stream().map(team::getName).collect(Collectors.toList()).contains(createUnexistingTeam(cleanStrings).getName())){
                listOfAllTeams.add(createUnexistingTeam(cleanStrings));

            }
            else{
                //gotta check if the player exists or not..if the pleyer exists then just add points


            }
            pollutedStrings = scan.nextLine().split("\\|");
        }




        for (team team : listOfAllTeams) {
            System.out.println(team.getName());
            System.out.println(team.getPlayersAndPoints());


        }

    }


}