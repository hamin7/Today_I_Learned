import java.io.IOException;

public class euclidGCD {
    public static void main(String[] args) throws IOException {
        System.out.println("gcd");
        System.out.println(gcd(36, 132));
    }
    
    // gcd(a, b) == gcd(b, a % b) ..... r = a % b
    //-> r 이 0인 경우 그 바로전이 gcd이다.
    static int gcd(int a, int b) {
    	while(b != 0) {
    		System.out.println(a + "," + b);
    		int r = a % b;
    		a = b;
    		b = r;
    	}
    	return a;
    }
}

