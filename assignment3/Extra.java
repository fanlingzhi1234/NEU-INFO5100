package assignment3;

public class Extra {
	public static void main(String args[]) {
		
		String a = "The sky is blue";
		System.out.println(a);
		String b = reverse(a);
		
		System.out.println(b);
	}
	
	
	static String reverse(String s) 
    { 
  
        String[] words = s.split(" ");
        String result = ""; 
  
        
        for (int i = 0; i < words.length; i++) { 
            if (i == words.length - 1) 
                result = words[i] + result; 
            else
                result = " " + words[i] + result; 
        } 
        return result; 
    } 
}
