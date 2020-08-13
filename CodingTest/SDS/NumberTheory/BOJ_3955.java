// 확장 유클리드 호제법 (표와 동일하게)

public class Main {
    public static void main(String[] args) {
        System.out.println("Egcd");
        System.out.println(eGcd(9, 5));
    }
    
    // gcd(a, b) == gcd(b, a % b) ..... r = a % b
    //-> r 이 0인 경우 그 바로 전이 gcd이다.
    static int gcd(int a, int b) {
    	while(b != 0) {
    		System.out.println(a + "," + b);
    		int r = a % b;
    		a = b;
    		b = r;
    	}
    	return a;
    }

    // x0 = s*c/d
    // y0 = t*c/d
    // 약분 안해도 코드는 동작
    // x = x0 + B*k/D
    // y = y0 a A*k/D

    static ExtendedGcdResult eGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 - r1 * q;
            r0 = r1;
            r1 = temp;

            temp = s0 - s1 * q;
            s0 = s1;
            s1 = temp;

            temp = t0 - t1 * q;
            t0 = t1;
            t1 = temp;
        }

        return new ExtendedGcdResult(s0, t0, r0);
    }
}

class ExtendedGcdResult{
    long s;
    long t;
    long r;

    public ExtendedGcdResult(long s, long t, long r) {
        super();
        this.s = s;
        this.t = t;
        this.r = r;
    }
    @Override
    public String toString() {
        return "[s=" + s + ", t= " + t + ", r= " + r + "]";
    }
}