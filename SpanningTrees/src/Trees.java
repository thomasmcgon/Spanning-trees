import java.util.Scanner;

public class Trees {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the amount of vertices in the graph: ");
		int n = in.nextInt();
		int cayleyAns = cayley(n);
		System.out.println("\nThe number of spanning trees for your graph is: " + cayleyAns);
		//Numbers 11 and those greater than 12 create overflow
		double frac = (double)cayley(n) / denom(n);
		System.out.println("\nProbability: " + frac);
	}
	
	public static int cayley(int n) {
		int num = (int)Math.pow(n, n-2);
		return num;
	}
	
	public static int denom(int n) {
		int k = 1;
		int runningTotal = 0;
		while(k <= n) {
			//Combination Formula
			int comb = factorial(n) / (factorial(k) * (factorial(n-k)));
			int power = (int)Math.pow(k, k-2);
			int aK = comb * power;
			//Adding each aK in denominator to each other
			runningTotal += aK;
			++k;
		}
		return runningTotal;
	}
	//Factorial to use in Combination formula
	public static int factorial(int n) {
		int fact = 1;
		int i = 1;
		while(i <= n) {
			fact *= i;
			++i;
		}
		return fact;
	}
}
