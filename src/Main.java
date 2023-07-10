/**
 * @Content:
 * @Name: ${NAME}
 * @Version 1.0
 * @Author: TomJ
 * @Date:${DATE} ${TIME}
 */

import bag.match;
import bag.team;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bag.rank;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\matchScore\\src\\input.txt"); // 文件路径
        Scanner input = new Scanner(file);

        int wolveMin=6;
        team[] teams = {
                new team("Wolves",2,1),
                new team("DRG",2,2),
                new team("LGD",2,1),
                new team("WB",2,1),
                new team("RW",1,-1),
                new team("ES",0,-4)
        };
        match[] matches = {
                new match(1, teams[1], teams[0]),
                new match(2, teams[4], teams[3]),
                new match(3, teams[2], teams[5]),
                new match(4, teams[2], teams[1]),
                new match(5, teams[4], teams[5]),
                new match(6, teams[0], teams[3]),
//                new match(7, teams[0], teams[2]),
//                new match(8, teams[1], teams[3]),
//                new match(9, teams[5], teams[4]),
//                new match(10, teams[1], teams[5]),
//                new match(11, teams[2], teams[3]),
//                new match(12, teams[4], teams[0]),
//                new match(13, teams[2], teams[5]),
//                new match(14, teams[3], teams[0]),
//                new match(15, teams[1], teams[4]),
//                new match(16, teams[3], teams[2]),
//                new match(17, teams[5], teams[0]),
//                new match(18, teams[4], teams[2]),
//                new match(19, teams[0], teams[3]),
//                new match(20, teams[1], teams[2])
        };

        // 用户输入比分
        for (match m : matches) {
            System.out.printf("Please enter the score for match %d between %s and %s: ", m.getMatchId(), m.getRedTeam().getName(), m.getBlueTeam().getName());

                int redScore = input.nextInt();
                int blueScore = input.nextInt();
                // 处理输入
                m.fight(redScore, blueScore);
                // 排序并打印排名
                rank r =new rank(teams,matches);
                r.rank();
 //               wolveMin=wolveMin<r.getRank(teams[0])?r.getRank(teams[0]):wolveMin;


        }

        // 排序并打印排名
        rank r =new rank(teams,matches);
        r.rank();
    }
}
