package com.kpblogs.solid_design_principles.srp;

public class BlogPost
 {
    String text;
    String author;
    int length;

     //Setter getter

    /*methods that change the text format */
    void changeContentFormat() { 
    	System.out.println("Changed the format of conten");
    }
}

//Created separate class for content print
class PrintContent{
	private BlogPost post = null;
	public PrintContent(BlogPost post) {
		this.post = post;
	}
	
	public String doContentPrint(){
		return "In this method will start the content printing process";
	}
}