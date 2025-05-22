package csp_solutions;

import core_algorithms.MAC;
import csp_problems.*;

import java.util.List;
import java.util.Map;


public class MAC_Sudoku extends MAC<Square,Integer> {

    public MAC_Sudoku(Sudoku problem){
        super(problem);
    }

    /**
     * Implements the `revise()` operation for arc consistency checking in Sudoku.
     *
     * This method enforces consistency between two variables (`tail` and `head`)
     * connected by a constraint. It removes values from `tail`'s domain that are
     * inconsistent with all values in `head`'s domain.
     *
     * In the context of Sudoku, two squares (i.e., variables) must take different
     * values. Therefore, a value `v` in the domain of `tail` is inconsistent if
     * `head`'s domain contains **only** the same value `v`.
     *
     * @param tail The variable whose domain may be reduced (tail of the arc).
     * @param head The variable used to check for consistency (head of the arc).
     * @return true if the domain of `tail` was revised (i.e., any values were removed),
     *         false otherwise.
     *
     * TODO: Implement the `revise()` method by checking each value in `tail`'s domain:
     *  - If there is no value in `head`'s domain that satisfies the constraint
     *    (i.e., being different from it), remove the value from `tail`'s domain.
     *  - If any values are removed, return true; otherwise, return false.
     *
     * Important:
     *  - Be careful not to modify the `head`'s domain—only `tail`'s domain should change.
     */
    public boolean revise(Square tail, Square head) {

    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String filename = "./SudokuTestCases/TestCase1.txt";
        Sudoku problem = new Sudoku(filename);
        MAC_Sudoku agent = new MAC_Sudoku(problem);
        System.out.println("loading puzzle from " + filename + "...");
        problem.printPuzzle(problem.getAllVariables());
        if(agent.initAC3() && agent.search()){
            System.out.println("Solution found:");
            problem.printPuzzle(agent.getAllVariables());
        }else{
            System.out.println("Unable to find a solution.");
        }
    }
}
