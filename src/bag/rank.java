package bag;

import java.util.Collections;
import java.util.Comparator;

/**
 * @Content:bag
 * @Name: rank
 * @Version 1.0
 * @Author: TomJ
 * @Date:2023/4/19 21:07
 */
//public class rank {
//    public team[] teams=new team[6];
//    public void show(){
//        System.out.println("1----->"+teams[0].getName()+"-----积分:"+teams[0].getBigScore()+"-----净胜:"+teams[0].getSmallScore());
//        System.out.println("2----->"+teams[1].getName()+"-----积分:"+teams[1].getBigScore()+"-----净胜:"+teams[1].getSmallScore());
//        System.out.println("3----->"+teams[2].getName()+"-----积分:"+teams[2].getBigScore()+"-----净胜:"+teams[2].getSmallScore());
//        System.out.println("4----->"+teams[3].getName()+"-----积分:"+teams[3].getBigScore()+"-----净胜:"+teams[3].getSmallScore());
//        System.out.println("5----->"+teams[4].getName()+"-----积分:"+teams[4].getBigScore()+"-----净胜:"+teams[4].getSmallScore());
//        System.out.println("6----->"+teams[5].getName()+"-----积分:"+teams[5].getBigScore()+"-----净胜:"+teams[5].getSmallScore());
//    };
//    public void getRank(){
//        // 对六只队伍进行排序，按照优先级依次比较大场积分，净胜分和胜负关系
//        Collections.sort(teams, new Comparator<team>() {
//            @Override
//            public int compare(team t1, team t2) {
//                if (t1.getBigScore() != t2.getBigScore()) {
//                    return t2.getBigScore() - t1.getBigScore();
//                } else if (t1.getSmallScore() != t2.getSmallScore()) {
//                    return t2.getSmallScore() - t1.getSmallScore();
//                } else {
//                    // 比较两支队伍的胜负关系
//                    int t1wins = 0, t2wins = 0;
//                    for (match m : matches) {
//                        if (m.getRedTeam().equals(t1) && m.getRedTeam().getBigScore() > m.getBlueTeam().getBigScore()) {
//                            t1wins++;
//                        } else if (m.getRedTeam().equals(t2) && m.getRedTeam().getBigScore() > m.getBlueTeam().getBigScore()) {
//                            t2wins++;
//                        } else if (m.getBlueTeam().equals(t1) && m.getBlueTeam().getBigScore() > m.getRedTeam().getBigScore()) {
//                            t1wins++;
//                        } else if (m.getBlueTeam().equals(t2) && m.getBlueTeam().getBigScore() > m.getRedTeam().getBigScore()) {
//                            t2wins++;
//                        }
//                    }
//                    return t2wins - t1wins;
//                }
//            }
//        });
//
//        // 输出排名
//        System.out.println("排名\t队名\t大场积分\t净胜分");
//        for(int i=0;i<teams.size();i++){
//            System.out.println((i+1)+"\t"+teams.get(i).getName()+"\t"+teams.get(i).getBigScore()+"\t\t"+teams.get(i).getSmallScore());
//        }
//    }
//
//}
import java.util.Arrays;


public class rank {
    public team[] teams;
    public match[] matches;

    public rank(team[] teams, match[] matches) {

        this.matches = matches;
        Arrays.sort(teams, new Comparator<team>() {
            @Override
            public int compare(team t1, team t2) {
                // 比较大场积分
                int bigScore1 = t1.getBigScore();
                int bigScore2 = t2.getBigScore();
                if (bigScore1 != bigScore2) {
                    return bigScore2 - bigScore1; // 按照大场积分降序排序
                }

                // 比较净胜分
                int diffScore1 =  t1.getSmallScore();
                int diffScore2 =  t2.getSmallScore();
                if (diffScore1 != diffScore2) {
                    return diffScore2 - diffScore1; // 按照净胜分降序排序
                }

                // 比较胜负关系
                for (match m : matches) {
                    team redTeam = m.getRedTeam();
                    team blueTeam = m.getBlueTeam();
                    if ((redTeam == t1 && blueTeam == t2) || (redTeam == t2 && blueTeam == t1)) {
                        int redScore = m.getRedScore();
                        int blueScore = m.getBlueScore();
                        if (redTeam == t1) { // t1作为红方
                            return Integer.compare(redScore, blueScore);
                        } else { // t1作为蓝方
                            return Integer.compare(blueScore, redScore);
                        }
                    }
                }
                return 0;
            }
        });
        this.teams = teams;
    }

    public void rank() {
        int wolveR=0;
        System.out.println("排名如下：");
        for (int i = 0; i < teams.length; i++) {
            if("Wolves"==teams[i].getName()){
                wolveR=i+1;
            }
            System.out.println("第" + (i + 1) + "名：" + teams[i].getName()+"-----积分："+teams[i].getBigScore()+"-----净胜分："+teams[i].getSmallScore());
        }
        System.out.println("狼队排名："+wolveR);
    }
    public int getRank(team t) {
        for (int i = 0; i < teams.length; i++) {
            if(t.getName()==teams[i].getName()){
                return i+1;
            }
            return -1;
        }
        return -1;
    }
}
