package DynamicProg;

// 0, 1, 1, 2, 3, 5, 8, ...
public class Fibonacci {
    public static void main(String args[]){
        System.out.println(fib2(0));
        System.out.println(fib1(0));
        System.out.println(fib3(0));
    }

    // least efficient - exponential o(2^n)
    private static int fib3(int n){
        if (n<=1){
            return n;
        }
        return fib3(n-1) + fib3(n-2);
    }

    // semi-efficient o(n) space o(n) time
    private static int fib2(int n){
        if (n<=1){
            return n;
        }
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i=2;i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    // most efficient o(1) space o(n) time
    private static int fib1(int n){
        if (n<=1){
            return n;
        }
        int res=0;
        int first = 0;
        int second = 1;
        for(int i=2;i<=n;i++){
            res = first+second;
            first = second;
            second = res;
        }
        return res;
    }
}
