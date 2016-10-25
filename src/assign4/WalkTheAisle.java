package assign4;

/*
 * This class contains a solution to the "walk the aisle" problem in CSC 330
 * Assignment 4 (Fall 2016). The constructor sets up the problem, and then
 * you call the solveAndPrint() method to compute the solution and print it.
 *
 * @author srtate
 */
public class WalkTheAisle {
    private int[] weight;        // The weight of each station's item
    private int target;          // How much you want to be carrying at the end
    private boolean[] solution;  // For building up the solution
    
    private WalkTheAisle() {
        // Disable the default constructor
    }
    
    /**
     * Defines the problem you want to solve.
     * @param weight an array of weights for items at stations
     * @param target the weight you want to be carrying at the end of the aisle
     */
    public WalkTheAisle(int[] weight, int target) {
        this.weight = weight;
        this.target = target;
    }

    /**
     * This is the recursive backtracking algorithm to find a solution.
     * @param pos the current position (station number)
     * @param carrying the weight of items that I have picked up so far
     * @return true if we have found a solution - false otherwise
     */
    private boolean walk(int pos, int carrying) {
        if (carrying == target) {
            return true;  // Have the target weight, so we found a solution!
        } else if ((pos == weight.length) || (carrying > target)) {
            return false; // We reached the end with the wrong weight, or have gone over
        } else {
            // Exploring different solutions - first try without picking
            // up this item
            solution[pos] = false;
            if (walk(pos+1, carrying)) {
                return true;   // Found a solution, so return true
            } else {
                // Didn't find a solution without picking up the item, so we
                // have backtracked to here - no try to find a solution WITH
                // picking up the item.
                solution[pos] = true;
                if (walk(pos+1, carrying+weight[pos])) {
                    return true;   // Found a solution, so return true
                } else {
                    // Didn't find a solution from here with either leaving or
                    // picking up the item, so put the item down and backtrack
                    // to try different decisions earlier in the aisle.
                    solution[pos] = false;
                    return false;
                }
            }
        }
    }
    
    /**
     * Solve and print a solution for this problem.
     */
    public void solveAndPrint() {
        solution = new boolean[weight.length];
        boolean found = walk(0, 0);
        if (!found) {
            System.out.println("No solution found.");
        } else {
            System.out.print("Pick up these items:");
            for (int i=0; i<weight.length; i++) {
                if (solution[i]) System.out.print(" "+i+" ("+weight[i]+" g)");
            }
            System.out.println();
        }
        
    }
}
