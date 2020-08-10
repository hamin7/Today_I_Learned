package DAY01.P1062;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, K;
    static String[] words;
    static boolean[] visited;
    static int selectedCount = 0;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src\\DAY01\\P1062\\input.txt"));
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.next());
        K = Integer.parseInt(sc.next());

//      System.out.println(N + ", " + K);

        words = new String[N];
        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

//      System.out.println(Arrays.toString(visited));

        for (int i = 0; i < N; i++) {
            words[i] = sc.next().replaceAll("[antic]", "");
        }

//      System.out.println(Arrays.toString(words));

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        selectedCount = 5;
        max = countWords();

        for (int i = 0; i < 26; i++) {
            if (visited[i] == false) {
                dfs(i);
            }
        }

        System.out.println(max);
    }

    static void dfs(int index) {
//      1. 체크인
        visited[index] = true;
        selectedCount++;
//      2. 목적지인가?
        if (selectedCount == K) {
            max = Math.max(countWords(), max);
        } else {
//          3. 갈 수 있는 곳을 순회
            for (int i = index + 1; i < 26; i++) {
//              4.   갈 수 있는가?
                if (visited[i] == false) {
//                  5.     간다
                    dfs(i);
                }
            }
        }
//      6. 체크아웃
        visited[index] = false;
        selectedCount--;
    }

    // 단어들을 순회하면서 읽을수 있는가를 체크.
    static int countWords() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean isPossible = true;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (visited[word.charAt(j) - 'a'] == false) { // 해당 알파벳을 배운적이 없으면.
                    isPossible = false;
                    break;
                }
            }
            if (isPossible == true) {
                count++;
            }
        }
        return count;
    }
}