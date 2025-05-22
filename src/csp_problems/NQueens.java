package csp_problems;

import java.util.*;
import java.util.stream.IntStream;

public class NQueens implements CSPProblem<Integer,Integer>{
    private final int N;
    private final List<Integer> DEFAULT_DOMAIN;

    public NQueens(int n){
        this.N = n;
        DEFAULT_DOMAIN = IntStream.rangeClosed(1, N)
                                  .boxed()
                                  .toList();
    }

    public Map<Integer, List<Integer>> getAllVariables(){
        Map<Integer, List<Integer>> allVariables = new HashMap<>();
        for(int i=1; i<=N; i++){
            List<Integer> domain = new ArrayList<>(DEFAULT_DOMAIN);
            allVariables.put(i, domain);
        }
        return allVariables;
    }

    //For a given column i, the neighbors are all other columns j
    // (where j != i).
    public List<Integer> getNeighborsOf(Integer value){
        List<Integer> neighbors =  new ArrayList<>(DEFAULT_DOMAIN);
        neighbors.remove(value);
        return neighbors;
    }

    //NQueens does not have any pre-assigned variables
    //so simply return an empty list.
    public List<Integer> getPreAssignedVariables(){
        return Collections.emptyList();
    }

    public String printPuzzle(Map<Integer, List<Integer>> allVariables) {
        String solution = "";
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (allVariables.get(col).size() == 1 &&
                        allVariables.get(col).get(0) == row) {
                    System.out.print(" Q "); // Queen position
                    solution += " Q ";
                } else {
                    System.out.print(" . "); // Empty space
                    solution += " . ";
                }
            }
            System.out.println();
            solution += "\n";
        }
        return solution;
    }

    public int getDomainSize(){
        return N;
    }




}
