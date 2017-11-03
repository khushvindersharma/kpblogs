package com.kpblogs.java_stream_api;

import java.util.stream.Stream;

public class BiPredicateExample {
public static void main(String[] args) {
	Stream<Integer> numbers4 = Stream.of(1,2,3,4,5,12);
	System.out.println("Stream contains all elements less than 10? "+numbers4.allMatch(i -> i<10));
	
	Stream<Integer> numbers5 = Stream.of(1,2,3,4,5,1);
	System.out.println("Stream contains all elements less than 10? "+numbers5.allMatch(i -> i<10));
	
}
}
