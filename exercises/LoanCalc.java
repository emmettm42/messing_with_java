// Emmett Maloney
// CS 120
// NCC, Fall 2016

// Purpose: Allows the user to calculate their monthly payment based on a loan amount, an
// annual interest rate, and the term (number of years) of the loan.
import java.util.*;
public class LoanCalc {
	public static void main(String[] args){
		int loanPrincipal, loanMonths, loanYears;
		double loanInterestAnnual, loanInterestMonthly, loanPayment;
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Banks, Inc. \n\n"
				+ "Please Enter the Loan Amount Requested: ");
		loanPrincipal = input.nextInt();

		System.out.println("Please Enter the Term in Years: ");
		loanYears = input.nextInt();
		loanMonths = loanYears * 12;

		System.out.println("Please Enter the Annual Percent Interest Rate: ");
		loanInterestAnnual = input.nextDouble();

		System.out.println("You have requested a loan of $" + loanPrincipal + ", for " + loanYears + " years at an annual" + " interest rate of " + loanInterestAnnual + "%.");

		// Convert to Decimal, Calculate Monthly Interest Rate.
		loanInterestAnnual /= 100;
		loanInterestMonthly = loanInterestAnnual / 12;

		// P = r*A/1-(1+r)^-N
		loanPayment = (
				(loanInterestMonthly * loanPrincipal) / (1 - Math.pow((1 + loanInterestMonthly), -loanMonths)));

		System.out.println("Your monthly loan payment will be $" + loanPayment);

	}
}
