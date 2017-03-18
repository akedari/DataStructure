package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhijeetkedari on 3/16/17.
 */
/*
given integer n we need to generate all possible combination of those number of paranthesis
 */

public class CombinationOfParanthesis {
    public static void main(String[] args){
        int n=3;
        printAllCombination(n);

    }

    private static void printAllCombination(int n) {

        Set<String> set = generateParathesis(n);

        for(String item:set){
            System.out.println(" "+ item);
        }
    }

    private static Set<String> generateParathesis(int remaining) {

        Set<String> set =  new HashSet<>();

        if(remaining==0){
            set.add("");
        }
        else{
            Set<String> prev = generateParathesis(remaining-1);

            for(String str: prev){

                for(int i =0; i<str.length();i++ ){
                 if(str.charAt(i)=='('){
                     String newStr = insertPara(str,i);

                     if(!set.contains(newStr)){
                         set.add(newStr);
                     }

                 }
                }

                if(!prev.contains("()"+str)){
                    set.add("()"+str);

                }
            }



        }

        return set;
    }

    private static String insertPara(String str, int i) {

        String leftSide = str.substring(0,i+1);
        String rightSide = str.substring(i+1,str.length());

        String newStr = leftSide + "()" + rightSide;

        return newStr;

    }
}
