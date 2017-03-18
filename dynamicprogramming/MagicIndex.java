package dynamicprogramming;

/**
 * Created by abhijeetkedari on 3/16/17.
 */
/*
a magic index in array a[1,....n-1] define as an idex a[i]=i
given sorted array may not contain all distinct values. (means repeated values can be there)
 */

public class MagicIndex {

    public static void main(String[] args){

        int[] array = {-10,-5,2,2,2,3,4,7,9,12,13};
        int result = findMagicIndex(array,0,array.length-1);
        System.out.print("Result: "+result);

    }

    private static int findMagicIndex(int[] array, int start, int end) {

        if(start>end || start<0 || end>=array.length){
            return -1;
        }

        int mid = (start+end)/2;

        if(array[mid]==mid){
            return mid;
        }

        int leftIndex = Math.min(array[mid], mid-1);
        int left = findMagicIndex(array,start,leftIndex);
        if(left>=0){
            return left;
        }

        int rightIndex = Math.max(array[mid],mid+1);
        int right = findMagicIndex(array,rightIndex,end);
        return right;

    }
}
