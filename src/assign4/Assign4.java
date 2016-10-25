/*
 * This is code for Assignment 4 in CSC 330 at UNCG (Fall 2016).
 *
 * There isn't any programming required for this assignment - this is code
 * that needs to be analyzed as part of the assignment (see the assignment for
 * details).
 */
package assign4;

/**
 *
 * @author srtate
 */
public class Assign4 {

    /**
     * This is a small test case that has a solution (picking up items of
     * weight 227, 123, and 650 give you a total weight of 1000).
     */
    public static void testPossible() {
        int weights[] = {328, 227, 931, 123, 650, 444};
        WalkTheAisle testCase = new WalkTheAisle(weights, 1000);
        testCase.solveAndPrint();
    }

    /**
     * This function creates an impossible test case, where the target weight
     * is one greater than the sum of all item weights. This is the worst-case
     * behavior of the algorithm, since you'll never find a solution, and you
     * won't discover that any partial solution is bad until you get to the
     * end of the aisle.
     * @param num_stations 
     */    
    public static void testImpossible(int num_stations) {
        int[] weights = new int[num_stations];
        for (int i=0; i<num_stations; i++) {
            weights[i] = 10;
        }
        WalkTheAisle testCase = new WalkTheAisle(weights, 10*num_stations+1);
        testCase.solveAndPrint();
    }
    
    /**
     * The main program. A quick "possible" test case followed by a longer
     * impossible test case.
     */
    public static void main(String[] args) {
        testPossible();
        testImpossible(30);
    }
    
}
