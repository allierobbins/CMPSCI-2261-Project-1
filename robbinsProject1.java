package robbinsProject1;

import java.util.Scanner;

public class robbinsProject1 {

	//Project 1 by Allie Robbins for CMPSCI 2261
	public static void main(String[] args) { 
		
		//Create scanner
		Scanner input = new Scanner(System.in);

		//prompt for credit card number
		System.out.print("Enter the number of digits of the card number: ");
		int cardLength = input.nextInt();
		
		//check card length
		if (cardLength < 13 || cardLength > 16) {
			System.out.print("That is an invalid number. Number of digits must be between 13 and 16. Program ending.");
			return;
		}
		int[] array = new int[cardLength];
		
		//prompt for credit card #
		System.out.print("Enter a credit card number as a long integer: ");
		long number = input.nextLong();
		
		//variable to keep number good
		long returnNum = number;
		
		//input long into an array
		for (int i = 0; i < array.length; i++) {
			array[(int) i] = (int) (number % 10);
			number /= 10;
		}
		
		//return number to normal
		number = returnNum;
		
		/*for (int i = 0; i <array.length; i++) {		//test for correct array order
			System.out.print(array[i] + " ");
		}*/
		
		//check that 1st digit of card# is valid
		if (array[cardLength - 1] == 4 || array[cardLength - 1] == 5 || array[cardLength - 1] == 6 || (array[cardLength - 1] == 3 && array[cardLength - 2] == 7)) {
		} else {
			System.out.print("That is an invalid number. Card number must start with a 4, 5, 37, or 6. Program ending.");
			return;
		}
		
		/*System.out.println("test for number - " + number);*/	//test for correct number
 
		//find necessary sums
		int sumEven = sumOfEvens(number);
		int sumOdd = sumOfOdds(number);
		
		int total = sumEven + sumOdd;
		
		//test for validity
		if (total % 10 == 0) {
			System.out.print("Your credit card " + number + " is valid.");
		} else {
			System.out.print("Your credit card " + number + " is not valid.");
		}
	}

	//method to find sum of evens from left
public static int sumOfEvens(long num) {
	int sum = 0;
	
	num /= 10;
	
	while (num != 0) {
		sum += getSingleNum((int)((num & 10) * 2));
		num /= 100;
	}
	
	return sum;
}

//method to finds sum of odds from left
public static int sumOfOdds(long num) {
	int sum = 0;
	
	while (num != 0) {
		sum += (int)(num % 10);
		num /= 100;
	}
	
	return sum;
}

//method to ensure single numbers while adding
public static int getSingleNum (int num) {
	if (num <= 9) {
		return num;
	} else if (num > 9)
		return (num % 10 + num / 10);
	
	return num;
}}