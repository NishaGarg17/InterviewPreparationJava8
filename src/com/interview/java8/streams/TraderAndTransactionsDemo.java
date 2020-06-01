package com.interview.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.joining;
import com.interview.java8.entity.Trader;
import com.interview.java8.entity.Transaction;

public class TraderAndTransactionsDemo {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Find all transactions in the year 2011 and sort them by value (small to
		// high).
		System.out.println("All transactions in the year 2011 and sort them by value (small to high):");
		transactions.stream().filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing(transaction -> transaction.getValue()))
				.forEach(transaction -> System.out.println(transaction));

		// What are all the unique cities where the traders work?
		System.out.println("\nAll the unique cities where the traders work:");
		transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct()
				.forEach(city -> System.out.println(city));

		// find all traders from Cambridge and sort them by name.
		System.out.println("\nAll traders from Cambridge sorted by name:");
		transactions.stream().map(transaction -> transaction.getTrader())
				.filter(trader -> trader.getCity().equals("Cambridge")).map(trader -> trader.getName()).distinct()
				.sorted().forEach(trader -> System.out.println(trader));

		// Return a string of all traders’ names sorted alphabetically.
		System.out.println("\nString of all traders’ names sorted alphabetically.\n"
				+ transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted()
						.reduce("", (str1, str2) -> str1 + "" + str2));
		/*
		 * Note that this solution isn’t very efficient (all Strings are repeatedly
		 * concatenated, which creates a new String object at each iteration). Below is
		 * a more efficient solution that uses joining() as follows (which internally
		 * makes use of a StringBuilder):
		 */
		/*
		 * String traderStr = transactions.stream() .map(transaction ->
		 * transaction.getTrader().getName()) .distinct() .sorted() .collect(joining());
		 */

		// Are any traders based in Milan?
		System.out.println("\nAre any traders based in Milan? " + transactions.stream()
				.map(transaction -> transaction.getTrader().getCity()).anyMatch(city -> city.equals("Milan")));

		// Print all transactions’ values from the traders living in Cambridge.
		System.out.println("\nAll transactions’ values from the traders living in Cambridge:");
		transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
				.forEach(transaction -> System.out.println(transaction.getValue()));

		// What’s the highest value of all the transactions?
		System.out.println("\nHighest value of all the transactions? "
				+ transactions.stream().map(transaction -> transaction.getValue()).reduce(Integer::max).get());

		// Find the transaction with the smallest value.
		System.out.println("The transaction with the smallest value: "
				+ transactions.stream().map(transaction -> transaction.getValue()).reduce(Integer::min).get());
	}

}
