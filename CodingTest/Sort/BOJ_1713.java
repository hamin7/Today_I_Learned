package DAY01.P1713;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] inputs;
    static Person[] people = new Person[101];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src\\DAY01\\P1713\\input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        inputs = new int[K];

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            // 초기화
            if (people[num] == null) {
                people[num] = new Person(num, 0, 0, false);
            }
            // 사진틀에 있는경우 -> 해당 후보의 count++
            if (people[num].isIn == true) {
                people[num].count++;
            } else { // 사진틀에 없는경우
                // 사진틀이 꽉찬경우 -> 한명 제거
                if (list.size() == N) {
                    Collections.sort(list);
                    Person p = list.remove(0);
                    p.isIn = false;
                }
                // 후보 추가
                people[num].count = 1;
                people[num].isIn = true;
                people[num].timeStamp = i;
                list.add(people[num]);
            }
        }
        System.out.println(list);

        Collections.sort(list, new Comparator<Person>() {
            // -1 : 원하는 순서, 0 : 같음, 1 : 원하는 순서가 아님
            @Override
            public int compare(Person arg0, Person arg1) {
                if (arg0.num < arg1.num) {
                    return -1;
                } else if (arg0.num == arg1.num) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(list);
        for (Person person : list) {
            System.out.print(person.num);
            System.out.print(" ");
        }
    }
}

class Person implements Comparable<Person> {
    int num;
    int count;
    int timeStamp;
    boolean isIn;

    public Person(int num, int count, int timeStamp, boolean isIn) {
        super();
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    @Override
    public String toString() {
        return "[num=" + num + ", count=" + count + ", timeStamp=" + timeStamp + ", isIn=" + isIn + "]";
    }

    // -1 : 원하는 순서, 0 : 같음, 1 : 원하는 순서가 아님
    @Override
    public int compareTo(Person arg0) {
        if (count < arg0.count) {
            return -1;
        } else if (count == arg0.count) {
            // timeStamp 비교
            if (timeStamp < arg0.timeStamp) {
                return -1;
            } else if (timeStamp == arg0.timeStamp) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}