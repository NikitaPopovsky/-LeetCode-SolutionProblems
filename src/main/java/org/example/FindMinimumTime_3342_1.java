package org.example;

//Сложное и неверное рещение
public class FindMinimumTime_3342_1 {
    public static int minTimeToReach(int[][] moveTime) {
        int curX = 0;
        int curY = 0;
        boolean exStepY = false;
//        int maxY = 1;
        int maxXFirst = moveTime[0].length - 1;
        int maxXSecond = moveTime[1].length - 1;
        int step = 1;
        int time = 0;
        int curCharY = 1;
        boolean OnlyX = false;
        while (true) {
            //Выход из цикла, если Х и Y дошло до конца
            if (curX >= maxXFirst && curX >= maxXSecond && curY == 1) {
                break;
            }else if (curX >= maxXFirst && curX >= maxXSecond && curY == 0) {
                curY++;
                exStepY = true;
            }else if (curY == 0 && curX == maxXFirst) {
                curY++;
                exStepY = true;
                OnlyX = true;
            } else if (curY == 1 && curX == maxXSecond) {
                curY--;
                exStepY = true;
                OnlyX = true;
            } else if (exStepY) {
                curX++;
            } else {
                if (OnlyX){
                    curX++;
                } else {
                    if (curY == 0) {
                        curCharY = 1;
                    } else {
                        curCharY = -1;
                    }
                    if (moveTime[curY][curX+1] <= moveTime[curY + curCharY][curX]) {
                        curX++;
                    } else {
                        curY += curCharY;
                        exStepY = true;
                    }
                }
            }

            time = Integer.max(time + step,moveTime[curY][curX]);
            //time += step;

            if (step == 1) {
                step = 2;
            } else {
                step = 1;
            }
        }
        return time;
    }
}
