package net.sady.java8.stream.combinedconcept;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinedConcept {
	
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950)
				);
		
		findSortedTransactionIn2011(transactions);
		findUniqueCity(transactions);
		findUniqueCityUsingSet(transactions);
		findSortedCambridgeTraders(transactions);
		allTraderSorted(transactions);
		isTraderInMilan(transactions);
		transactionFromCambridge(transactions);
		highestTransaction(transactions);
	}

	private static void findSortedTransactionIn2011(List<Transaction> transactions) {
		List<Transaction> list = transactions.stream()
			.filter(t -> t.getYear() == 2011)
			//.sorted(comparing(Transaction::getValue))
			//.sorted((a,b) -> a.getValue() > b.getValue() ? 1)
			.collect(Collectors.toList());
		
		System.out.println(list);
	}
	private static void findUniqueCity(List<Transaction> transactions) {
		List<String> list = transactions.stream()
				.map(t -> t.getTrader().getCity())
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(list);
	}
	private static void findUniqueCityUsingSet(List<Transaction> transactions) {
		Set<String> set = transactions.stream()
				.map(t -> t.getTrader().getCity())
				.collect(Collectors.toSet());
		
		System.out.println(set);
	}
	private static void findSortedCambridgeTraders(List<Transaction> transactions) {
		List<String> list = transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.map(t -> t.getTrader().getName())
				.distinct()
				.sorted((a,b) -> a.compareTo(b))
				.collect(Collectors.toList());
		
		System.out.println(list);
	}
	private static void allTraderSorted(List<Transaction> transactions) {
		String s = transactions.stream()
				.map(t -> t.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("", (s1,s2) -> s1 + s2);
				//.collect(joining());
		
		System.out.println(s);
	}
	
	private static void isTraderInMilan(List<Transaction> transactions) {
		Boolean isTraderInMilan = transactions.stream()
				.anyMatch(t-> t.getTrader().getCity().equals("Milan"));
		
		System.out.println(isTraderInMilan);
	}
	
	private static void transactionFromCambridge(List<Transaction> transactions) {
		transactions.stream()
			.filter(t -> t.getTrader().getCity().equals("Cambridge"))
			.map(Transaction::getValue)
			.forEach(System.out::println);
	
	}
	private static void highestTransaction(List<Transaction> transactions) {
		Optional<Integer> opt = transactions.stream()
			//.filter(t -> t.getValue() < 500)
			.map(Transaction::getValue)
			.reduce(Integer::max);
		System.out.println(opt.get());
	}
}
