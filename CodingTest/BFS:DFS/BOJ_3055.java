package DAY01.P3055;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // 좌, 우, 위, 아래
    static int[] mx = { -1, 1, 0, 0 };
    static int[] my = { 0, 0, -1, 1 };

    static int R, C;
    static char[][] map;
    static int[][] dp;
    static Queue<Point> queue;
    static boolean foundAnswer;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src\\DAY01\\P3055\\input.txt"));

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        System.out.println(R + ", " + C);

        map = new char[R][C];
        dp = new int[R][C];
        queue = new LinkedList<>();

        List<Point> waterList = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            String line = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if (map[r][c] == 'S') {
                    queue.add(new Point(r, c, 'S'));
                } else if (map[r][c] == '*') {
                    waterList.add(new Point(r, c, '*'));
                }
            }
        }
        queue.addAll(waterList);

        for (int r = 0; r < R; r++) {
            System.out.println(Arrays.toString(map[r]));
        }

        System.out.println(queue);

        while (!queue.isEmpty()) {
//          1. 큐에서 꺼내옴
            Point p = queue.poll();
//          2. 목적지인가? if(p ==  D)
            if (p.type == 'D') {
                System.out.println(dp[p.y][p.x]);
                foundAnswer = true;
                break;
            }
//          3. 갈 수 있는 곳을 순회 for( 좌, 우, 위, 아래 )
            for (int i = 0; i < 4; i++) {
                int ty = p.y + my[i];
                int tx = p.x + mx[i];
//              4.   갈 수 있는가? if( 맵을 벗어나지 않고, X가 아니고, *아니고 )
                if (0 <= ty && ty < R && 0 <= tx && tx < C) {
                    if (p.type == '.' || p.type == 'S') {
                        if (dp[ty][tx] == 0 && checkSafe(ty, tx)) {
//                          5.     체크인 dp[r][c] = time
                            dp[ty][tx] = dp[p.y][p.x] + 1;
//                          6.     큐에 넣음 queue.add(next)
                            queue.add(new Point(ty, tx, map[ty][tx]));
                        }
                    } else if (p.type == '*' && map[ty][tx] == '.') {
//                      6.     큐에 넣음 queue.add(next)
                        queue.add(new Point(ty, tx, '*'));
                        map[ty][tx] = '*';
                    }
                }
            }
        }
        if (foundAnswer == false) {
            System.out.println("KAKTUS");
        }
    }

//  X가 아니고, *아니고, *에 인접한 .도 아니고 체크
    static boolean checkSafe(int y, int x) {
        if (map[y][x] == 'D') {
            return true;
        } else if (map[y][x] == '.') {
            for (int i = 0; i < 4; i++) {
                int ty = y + my[i];
                int tx = x + mx[i];
                if (0 <= ty && ty < R && 0 <= tx && tx < C && map[ty][tx] == '*') {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}

class Point {
    int y;
    int x;
    char type;

    public Point(int y, int x, char type) {
        super();
        this.y = y;
        this.x = x;
        this.type = type;
    }

    @Override
    public String toString() {
        return "[y=" + y + ", x=" + x + ", type=" + type + "]";
    }
}