package com.chainsys.strings;

public class StringBuilderDemo {
	public static void main(String args[]) {
		testA();
	}
    public static void testA() {
    	String firstString ="Hello how are you today. Is the weather hot or cold. ";
    	StringBuilder stringBuilder =new StringBuilder();
        // stringBuilder.ensureCapacity(250);
    	System.out.println("length=" +stringBuilder.length());
    	System.out.println("capacity ="+stringBuilder.capacity());
    	stringBuilder.append(firstString);
    	System.out.println("buffer ="+stringBuilder);
    	System.out.println("length="+stringBuilder.length());
    	System.out.println("capacity ="+stringBuilder.capacity());
 
    	firstString ="Wish it rains this week";
    	
    	stringBuilder.append(firstString);
    	System.out.println("buffer ="+stringBuilder);
    	System.out.println("length="+stringBuilder.length());
    	System.out.println("capacity ="+stringBuilder.capacity());
   //reduce capacity to length
    	stringBuilder.trimToSize();
    	System.out.println("\tlength="+stringBuilder.length());
    	System.out.println("\tcapacity="+stringBuilder.capacity());
   
    	stringBuilder.replace(3, 8, "-This is a Test-");
    	System.out.println("replace= "+stringBuilder);
  
        stringBuilder.insert(10, "-This is August-");
        System.out.println("insert ="+stringBuilder);
        System.out.println("\tlength="+stringBuilder.length());
    	System.out.println("\tcapacity="+stringBuilder.capacity());
    	
        stringBuilder.delete(5, 20);
        System.out.println("delete ="+stringBuilder.length());
        System.out.println("\tlength="+stringBuilder.length());
    	System.out.println("\tcapacity="+stringBuilder.capacity());
   
    	System.out.println("Before reverse: "+stringBuilder);
    	stringBuilder.reverse();
    	System.out.println("After reverse: "+stringBuilder);
    }
}
