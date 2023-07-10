package bag;

/**
 * @Content:bag
 * @Name: match
 * @Version 1.0
 * @Author: TomJ
 * @Date:2023/4/19 20:41
 */

public class match {
    public int matchId;
    public  team redTeam;
    public team blueTeam;
    public int redScore;
    public int blueScore;

    public void fight(int redScore, int blueScore){
        redScore=redScore;
        blueScore=blueScore;
        if(redScore>blueScore){redTeam.setBigScore(redTeam.getBigScore()+1);}
            else blueTeam.setBigScore(blueTeam.getBigScore()+1);
        redTeam.setSmallScore(redTeam.getSmallScore()+redScore-blueScore);
        blueTeam.setSmallScore(blueTeam.getSmallScore()+blueScore-redScore);

    };
    public match(int matchId, team redTeam, team blueTeam) {
        this.matchId = matchId;
        this.redTeam = redTeam;
        this.blueTeam = blueTeam;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public team getRedTeam() {
        return redTeam;
    }

    public void setRedTeam(team redTeam) {
        this.redTeam = redTeam;
    }

    public team getBlueTeam() {
        return blueTeam;
    }

    public void setBlueTeam(team blueTeam) {
        this.blueTeam = blueTeam;
    }

    public int getRedScore() {
        return redScore;
    }

    public int getBlueScore() {
        return blueScore;
    }
}
