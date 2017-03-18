package dynamicprogramming;

/**
 * Created by abhijeetkedari on 3/16/17.
 */
public class AllPermutationsOfString {
    public static void main(String[] args){

        String str="abc";
        printAllPermutations(str);
    }

    private static void printAllPermutations(String str) {

        String prefix=" ";

        permutations(prefix,str);
    }

    private static void permutations(String prefix, String str) {

        if(str.length()==0){
            System.out.println(" "+prefix);
        }
        else{
            for(int i=0; i< str.length();i++){
                permutations(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1,str.length()));
            }
        }
    }
}
