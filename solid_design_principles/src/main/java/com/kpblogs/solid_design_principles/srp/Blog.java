package com.kpblogs.solid_design_principles.srp;

public class Blog {
	
	public static void main(String[] args) {
		BlogPost blogPost = new BlogPost();
		
		//Format changed
		blogPost.changeContentFormat();
		
		PrintContent printContent = new PrintContent(blogPost);
		
		//performing print command
		System.out.println(printContent.doContentPrint());
	}

}
