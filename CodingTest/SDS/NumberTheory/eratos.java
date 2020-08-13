// 에라토스테네스의 체.

public class Main {

    static int[] map = new int[1001];

    public static void main(String[] args) {
        
        for (int i = 2; i < map.length; i++) {
            if(map[i] == 0){
                for (int j = 2; j * i < map.length; j++) {
                    if(map[j * i] == 0){
                        map[j * i] = 1;
                    }
                }
            }
        }
        for(int i = 2; i < map.length; i++) {
            if(map[i] == 0) {
                System.out.println(i + ",");
            }
        }
    }
}