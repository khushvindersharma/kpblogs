package com.kpblogs.java_stream_api;

import java.util.Optional;

public class OptionalClassExample {
	public static void main(String[] args) {
		//Map and Flat Map
		Optional<String> blog = Optional.of("kpblogs");
        System.out.println("Map :: " + blog.map(blogs -> blog.map(String::toUpperCase)));
        System.out.println("Flat Map :: " + blog.flatMap(blogs -> blog.map(String::toUpperCase)));
        
        //Filter
        System.out.println(blog.filter(g -> g.equals("kp"))); //Optional.empty
        System.out.println(blog.filter(g -> g.equalsIgnoreCase("kpblogs"))); //Optional[kpblogs]
        System.out.println(blog.filter(g -> g.equalsIgnoreCase("khushvinder"))); //Optional.empty
	}
}
