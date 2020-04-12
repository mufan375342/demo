package 练习;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mufan
 * @date 2020/4/11
 */
public class Num_874_模拟行走机器人 {

    public int robotSim(int[] commands, int[][] obstacles) {
        //障碍物
        Set<String> blockSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            blockSet.add(obstacle[0] + "," + obstacle[1]);
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //方向的索引
        int dirIndex = 0;
        int x = 0;
        int y = 0;
        int res = 0;
        for (int command : commands) {
            if (command == 2) {
                dirIndex = (dirIndex + 3) % 4;
            } else if (command == -1) {
                dirIndex = (dirIndex + 1) % 4;
            } else if (command > 0) {
                for (int j = 0; j < command; j++) {
                    int nextX = x + dir[dirIndex][0];
                    int nextY = y + dir[dirIndex][1];
                    if (blockSet.contains(nextX + "," + nextY)) {
                        break;
                    } else {
                        x = nextX;
                        y = nextY;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }
        }
        return res;
    }
}
