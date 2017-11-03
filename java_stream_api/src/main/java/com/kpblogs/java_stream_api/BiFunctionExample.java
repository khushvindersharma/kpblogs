package com.kpblogs.java_stream_api;

import java.util.function.BiFunction;

public class BiFunctionExample {
	 public static void main(String[] args) {
	        BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Output:" +(num1 + num2);
	        System.out.println(biFunction.apply(10,25));
	    }    
}
