package dynamicprogramming;

/**
 * Created by abhijeetkedari on 3/16/17.
 */
public class Fibonacci {
    public static void main(String[] args){

        int n= 45;

        int result = fibonacci(n);
        System.out.println("Simple Recursion: "+ result);


        int res[] = new int[100000];
        int resultDP = fibonacciDP(n,res);
        System.out.println("DP Recursion: "+ resultDP);

    }

    private static int fibonacciDP(int n, int[] res) {

        if(n==0)
            return 0;
        if (n==1)
            return 1;

        if(res[n]!=0)
            return res[n];

        res[n] = (fibonacci(n-1) + fibonacci(n-2));
        return res[n];

    }

    private static int fibonacci(int n) {
        if(n==0)
            return 0;
        else if (n==1)
            return 1;
        return (fibonacci(n-1)+fibonacci(n-2));
    }
}
