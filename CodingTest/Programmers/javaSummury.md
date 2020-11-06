~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String[] input = br.readLine().split(" ");		
int n = Integer.parseInt(input[0]);
~~~

~~~java
import java.util.LinkedList;
import java.util.Queue;

Queue<Point> q = new LinkedList<>();
q.add(new Point(x, y, 0, 1));
Point p = q.poll();
~~~

~~~java
import java.util.StringTokenizer;

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String s = br.readLine();
StringTokenizer st = new StringTokenizer(s," ");

n = Integer.parseInt(st.nextToken());
m = Integer.parseInt(st.nextToken());
v = Integer.parseInt(st.nextToken());
~~~