package dynamicprogramming;

/**
 * Created by abhijeetkedari on 3/16/17.
 */
public class NQueenProblem {


    static class Position{
        int row,col;
        Position(int row,int col){
            this.row = row;
            this.col = col;
        }
    }

    public static Position[] solveNQueenProblem(int n){
        Position[] positions = new Position[n];
        boolean hasSolution = solveNQueenProblemUtil(n,0,positions);
        if(hasSolution){
            return positions;
        }
        else{
            return new Position[0];
        }

    }

    private static boolean solveNQueenProblemUtil(int n, int row, Position[] positions) {
        if(n==row){
            return true;
        }

        int col;

        for(col=0;col<n;col++){
            boolean safePlace =true;

            //check for this row and col is under attack form other queen
            for(int queen=0;queen<row;queen++){
                if(positions[queen].col == col || positions[queen].row - positions[queen].col == row-col ||
                        positions[queen].row+positions[queen].col==row+col){
                    safePlace =false;
                    break;
                }
            }
            if(safePlace){
                positions[row]= new Position(row,col);
                if(solveNQueenProblemUtil(n,row+1,positions)){
                    return true;
                }
            }

        }
        return false;
    }


    public static void main(String[] args){

        int n=4;
        Position[] result = solveNQueenProblem(n);

        for(int i=0;i<n;i++){
            System.out.println("row:"+result[i].row + "  col:"+result[i].col);
        }

    }
}
