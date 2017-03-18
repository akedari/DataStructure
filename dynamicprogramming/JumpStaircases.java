package dynamicprogramming;

/**
 * Created by abhijeetkedari on 3/16/17.
 */
public class JumpStaircases {
    public static void main(String[] args){

        int n = 10; // # of staircases

        int result = findNumberOfWays(n);
        System.out.println("# of ways : "+ result);

        int[] map  = new int[100000];
        int resultDp = findNumberOfWaysDP(n,map);
        System.out.println("DP: # of ways : "+ resultDp);
    }

    private static int findNumberOfWaysDP(int n, int[] map) {

        if(n<0)
            return 0;
        if(n==0)
            return 1;

        if(map[n]>0)
            return map[n];
        else {
            map[n] = findNumberOfWaysDP(n - 1, map) +
                    findNumberOfWaysDP(n - 2, map) +
                    findNumberOfWaysDP(n - 3, map);

            return map[n];
        }
    }

    private static int findNumberOfWays(int n) {
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        return (
                findNumberOfWays(n-1) +
                        findNumberOfWays(n-2) +
                        findNumberOfWays(n-3)
                );
    }
}
