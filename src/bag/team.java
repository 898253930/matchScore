package bag;

/**
 * @Content:bag
 * @Name: team
 * @Version 1.0
 * @Author: TomJ
 * @Date:2023/4/19 20:41
 */
public class team {
    public String name;
    public int BigScore;
    public int SmallScore;

    public team(String name, int bigScore, int smallScore) {
        this.name = name;
        BigScore = bigScore;
        SmallScore = smallScore;
    }

    public team() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBigScore() {
        return BigScore;
    }

    public void setBigScore(int bigScore) {
        BigScore = bigScore;
    }

    public int getSmallScore() {
        return SmallScore;
    }

    public void setSmallScore(int smallScore) {
        SmallScore = smallScore;
    }
}
