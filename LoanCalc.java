// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {

    static double epsilon = 0.001;  // Approximation accuracy
    static int iterationCounter;   // Number of iterations 

    public static void main(String[] args) {		
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);

        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
    }

    private static double endBalance(double loan, double rate, int n, double payment) {	
        rate = rate / 100;
        for (int i = 0; i < n; i++) {
            loan = (loan - payment) * (1 + rate);
        }
        return loan;
    }

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;
        double g1 = loan / n;
        while ((endBalance(loan, rate, n, g))> epsilon) {
            g1+= epsilon;
            iterationCounter++;
        }
        return g1;
    }

    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        iterationCounter = 0;
        double l = 0;
        double h = loan; 
        double index = 0.5 * (h + l);
        while (h - l > epsilon) {
            if (endBalance(loan, rate, n, index) * endBalance(loan, rate, n, l) > 0) {
                l = index;
            } else {
                h = index;
            }
            index = 0.5 * (h + l);
            iterationCounter++;
        }
        return index;
    }
}
