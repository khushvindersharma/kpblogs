package com.kpblogs.java_stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedStreamExample {

	public static void main(String[] args) {
		Stream<String> names2 = Stream.of("a", "b", "ef", "9810093311");
		List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSorted); 
		Stream<String> names3 = Stream.of("khushvinder", "pal", "kpblogs", "9810093311");
		List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
		System.out.println(naturalSorted); 
	}
}
