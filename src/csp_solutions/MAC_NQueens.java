package csp_solutions;

import core_algorithms.MAC;
import csp_problems.NQueens;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MAC_NQueens extends MAC<Integer,Integer> {

    private final NQueens csp;

    public MAC_NQueens(NQueens csp){
        super(csp);
        this.csp = csp;
    }

    //revise an arc according to the two constraints:
    //  Alldiff (V1, V2, ..., VN}          --- no two queens in the same row
    //  for all i,j (i != j), |Vi - Vj| != |i -j| --- no two queens in the same diagonal
    // where vi represents the variable i.
    public boolean revise(Integer tail, Integer head) {
        boolean revised = false;
        Iterator<Integer> itr = getAllVariables().get(tail).iterator();
        while (itr.hasNext()) {
            int rowTail = itr.next();
            boolean hasSupport = false;
            for (int rowHead : getAllVariables().get(head)) {
                if (!conflicts(tail, rowTail, head, rowHead)) {
                    //found a value at the head that supports this value at the tail
                    hasSupport = true;
                    break;
                }
            }
            if (!hasSupport) {
                //there is no value at the head that supports this tail value
                //delete the value from the tail
                itr.remove();
                revised = true;
            }
        }
        return revised;
    }

    //a helper function for checking if two queens are in conflict
    private static boolean conflicts(int col1, int row1, int col2, int row2) {
        return (row1 == row2 || Math.abs(col1 - col2) == Math.abs(row1 - row2));
    }

    public static void main(String[] args) {
        int N = 8;
        NQueens csp = new NQueens(N);
        MAC_NQueens agent = new MAC_NQueens(csp);
        if (agent.initAC3() && agent.search()){
            System.out.println(" Solution found:");
            csp.printPuzzle(agent.getAllVariables());
        }else{
            System.out.println("Unable to find a solution.");
        }
    }


}
