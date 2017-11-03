package com.kpblogs.java_stream_api;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample {
	 public static void main(String[] args) {
	       Map<Integer,String> map = new HashMap<>();
	       map.put(1, "A");
	       map.put(2, "B");
	       map.put(3, "C");
	       map.put(4, "D");
	       BiConsumer<Integer,String> biConsumer = (key,value) -> System.out.println("Key:"+ key+" Value:"+ value);
	       map.forEach(biConsumer);
	   }    
}
