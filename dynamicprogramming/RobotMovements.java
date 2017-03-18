package dynamicprogramming;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by abhijeetkedari on 3/16/17.
 */
public class RobotMovements {
    public static  void main(String[] args){

        int x1 = 0,y1=0;
        int x2 = 2, y2 =2;
        HashMap<Point,Boolean> map = new HashMap<Point, Boolean>();

        ArrayList<Point> paths = new ArrayList<>();
//        boolean result  = numberOfPaths(x2,y2,paths);

        boolean resultDP  = numberOfPathsDP(x2,y2,paths,map);

        if(resultDP){
            System.out.println("found path");
            for(int i=0;i<paths.size();i++){
                System.out.println(" "+paths.get(i));
            }

        }
        else {
            System.out.print("no path found !!! :(");
        }



    }

    private static boolean numberOfPathsDP(int x, int y, ArrayList<Point> paths, HashMap<Point, Boolean> map) {
        Point p = new Point(x,y);

        if(map.containsKey(p)){
            return map.get(p);
        }

        paths.add(p);

        if(x==0 && y==0){
            return true;
        }

        boolean success =false;

        if(x>=1){
            success = numberOfPathsDP(x-1,y,paths,map);
        }

        if(!success && y>=1){
            success = numberOfPathsDP(x,y-1,paths,map);
        }

        map.put(p,success);
        return success;
    }

    private static boolean numberOfPaths(int x, int y, ArrayList<Point> paths) {

        Point p = new Point(x,y);
        paths.add(p);

        if(x==0 && y==0){
            return true;
        }

        boolean success =false;

        if(x>=1){
            success = numberOfPaths(x-1,y,paths);
        }

        if(!success && y>=1){
            success = numberOfPaths(x,y-1,paths);
        }

        return success;
    }
}
