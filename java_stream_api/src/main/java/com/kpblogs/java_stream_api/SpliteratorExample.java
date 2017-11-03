package com.kpblogs.java_stream_api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorExample {

	public static void main(String[] args) {
		Collection<Integer> al = new ArrayList<Integer>();
		al.add(1);
        al.add(2);
        al.add(-3);

        // Obtain a Stream to the array list.
        Stream<Integer> str = al.stream();
             
        // getting Spliterator object on al
        Spliterator<Integer> splitr1 = str.spliterator();
         
        // estimateSize method
        System.out.println("estimate size : " + splitr1.estimateSize());
                 
        // getExactSizeIfKnown method
        System.out.println("exact size : " + splitr1.getExactSizeIfKnown());
         
        // hasCharacteristics and characteristics method
        System.out.println(splitr1.hasCharacteristics(splitr1.characteristics()));
         
        System.out.println("Content of arraylist :");
        // forEachRemaining method    
        splitr1.forEachRemaining((n) -> System.out.println(n));
	}
}
