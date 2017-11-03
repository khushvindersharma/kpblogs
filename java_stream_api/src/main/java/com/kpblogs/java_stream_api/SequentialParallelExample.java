package com.kpblogs.java_stream_api;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class SequentialParallelExample {

	public static void main(String[] args) {
		
	        String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

	        System.out.println("-------\nRunning sequential\n-------");
	        runStream(Arrays.stream(strings).sequential());
	        System.out.println("-------\nRunning parallel\n-------");
	        runStream(Arrays.stream(strings).parallel());
	    }

	    public static void runStream (Stream<String> stream) {

	        stream.forEach(s -> {  System.out.println(LocalTime.now() 
	        		+ " - value: " + s + " - thread: " + Thread.currentThread().getName());
	            try {
	                Thread.sleep(200);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });
	    }
	}