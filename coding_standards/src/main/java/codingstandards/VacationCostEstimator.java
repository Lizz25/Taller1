/**
* Domain classes used to produce .....
* @author Lizbeth
* @version 1.0
*/
package codingstandards;

import java.util.Scanner;

public class VacationCostEstimator {
	protected VacationCostEstimator() {
	}

	/**
	 * Funcion main.
	 * @param args
	 */
	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int minNumTravelers = 1;
		final int maxNumTravelers = 80;
		final int emptyDestination = 0;
		System.out.print("Welcome to the Vacation Package ");
		System.out.println("Calculator");
		System.out.print("Enter the destination: ");
		String destination = scanner.nextLine();
		if (destination.length() <= emptyDestination) {
			System.out.println("Deber ingresar un destino");
			System.exit(-1);
		}
		System.out.print("Enter the number of travelers: ");
		int numTravelers = scanner.nextInt();
		if (numTravelers < minNumTravelers
				|| numTravelers > maxNumTravelers) {
			System.out.println("Deber ingresar un numero valido");
			if (numTravelers > maxNumTravelers) {
				System.out.print("No existen paquetes para ");
				System.out.println("mas de 80 persona");
			}
			System.exit(-1);
		}
		System.out.print("Enter the duration of the vacation in days:");
		int duration = scanner.nextInt();
		if (duration < 1) {
			System.out.println("Deber ingresar un numero valido");
			System.exit(-1);
		}
		final int baseCost = 1000;
		final int adicionalParis = 500;
		final int adicionalNY = 600;
		final int discountTravels4 = 4;
		final int discountTravels10 = 10;
		final double percentTravels4 = 0.9;
		final double percentTravels10 = 0.8;
		final int penaltyDays = 7;
		final int costPenaltyDays = 200;
		final int durationPromotion = 30;
		final int travelersPromotion = 2;
		final int amountPromotion = 200;
		double totalCost = baseCost;

		// Calculate additional cost based on destination
		if (destination.equalsIgnoreCase("Paris")) {
			totalCost += adicionalParis;
		} else if (destination.equalsIgnoreCase("New York City")) {
			totalCost += adicionalNY;
		}

		// Calculate group discount
		if (numTravelers > discountTravels4
				&& numTravelers <= discountTravels10) {
			totalCost = totalCost * percentTravels4; // 10% discount
		} else if (numTravelers > discountTravels10) {
			totalCost = totalCost * percentTravels10; //20% discount
		}

		// Apply penalty fee for duration less than 7 days
		if (duration < penaltyDays) {
			totalCost += costPenaltyDays;
		}

		// Apply promotion policy
		if (duration > durationPromotion || travelersPromotion == 2) {
			totalCost -= amountPromotion;
		}

		// Display the total cost or an error message
		if (totalCost != -1) {
			System.out.print("Total cost of the vacation ");
			System.out.println("package: $" + totalCost);
		} else {
			System.out.print("Invalid input. Please check ");
			System.out.println("your input and try again.");
		}
		scanner.close();
	}

}
