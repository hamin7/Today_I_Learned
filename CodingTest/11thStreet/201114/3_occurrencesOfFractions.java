import java.util.HashMap;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    
    static class pair {
        int x, y;
        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return this.x;
        }

        @Override
        public boolean equals(Object obj) {
            // If both the object references are referring to the same object.  
            if(this == obj) {
                return true;  
            } 
            
            // It checks if the argument is of the type pair by comparing the classes of the passed argument and this object.  
            // if(!(obj instanceof pair)) return  
            // false; ---> avoid.  
            if(obj == null ||  obj.getClass() !=  this.getClass())   {
                return false;  
            }
            
            // Type casting of the argument.  
            pair geek = (pair) obj;  
            
            // comparing the state of argument with  
            // the state of 'this' Object.  
            return (geek.x == this.x &&  geek.y == this.y);  
        }
    }

    // Recursive function to find gcd of a and b
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    // Function to count the frequnet fraction in the given array
    static int countFrequentFraction(int num[], int den[], int N) {
        // Hash-map to store the fractions in its lowest form
        HashMap<pair, Integer> mp = new HashMap<>();

        // Loop to iterate over the fractions and store is lowest form in the hash map
        for (int i = 0; i < N; i++) {
            // To find the Lowest form
            int numer = num[i] / gcd(num[i], den[i]);
            int denom = num[i] / gcd(num[i], den[i]);
            pair tmp = new pair(numer, denom);
            mp.put(tmp, 1);
        }
        return mp.size();
    }

    public int solution(int[] X, int[] Y) {
        // write your code in Java SE 11
        int N = X.length;
        int answer = 0;

        answer = countFrequentFraction(X, Y, N);
        
        return answer;
    }
}
