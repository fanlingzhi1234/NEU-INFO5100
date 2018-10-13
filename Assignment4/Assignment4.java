package assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.ResolutionSyntax;

public class Assignment4 {
	
	/**
	 * The deadline of assignment4 is 10/12/2018 23:59 PST.
	 * Please feel free to contact Zane and Amanda for any questions.
	 */
	public static void main(String args[]) {
		String a = "leetcode";
		int result;
		String result1;
		result = firstUniqChar(a);
		System.out.println("Let's begin!");
		System.out.println("--------------------");
		System.out.println("Answer 1:");
		System.out.println(result);
		System.out.println("--------------------");
		
		int number = 789;
		result = addDigits(number);
		System.out.println("Answer 2:");
		System.out.println(result);
		System.out.println("--------------------");
		
		int[] c = {0,1,0,3,12};
		System.out.println("Answer 3:");
		moveZeroes(c);
		System.out.println("--------------------");
		
		String d = "babadcacd";
		result1 = longestPalindrome3(d);
		System.out.println("Answer 4:");
		System.out.println(result1);
		System.out.println("--------------------");
		
		int[][] e = new int[3][3];
		e[0][0] = 1; e[0][1] = 2;e[0][2] = 3;
		e[1][0] = 4; e[1][1] = 5;e[1][2] = 6;
		e[2][0] = 7; e[2][1] = 8;e[2][2] = 9;
		
		System.out.println("Answer 5:");
		System.out.println("original is");
		
		for(int i=0;i<e.length;i++) {
			for(int j=0;j<e.length;j++) {
				System.out.print(e[i][j]);
			}
			System.out.println();
		}
		rotate(e);
		System.out.println("After rotated:");
		for(int i=0;i<e.length;i++) {
			for(int j=0;j<e.length;j++) {
				System.out.print(e[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------------");
		
	}
	/*
	 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
	 * s = "leetcode" return 0. 
	 * s = "loveleetcode" return 2.
	 */
    public static int firstUniqChar(String s) {
    		//TODO
    	if(s == null) return -1;
    	
    	char count[] = new char[256];
    	for(int i = 0; i<s.length();i++) {
    		count[s.charAt(i)]++;
    	}
    	
    	int index = -1;
    	for (int i = 0; i<s.length(); i++) {
    		if(count[s.charAt(i)] == 1) {
    			return i;
    			
    		}
    	}
    	return index;
     }
       
    
    /*
     *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * Input: 38 Output: 2
     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public static int addDigits(int n) {
    	
    	String s = Integer.toString(n);
    	char[] c = s.toCharArray();
    	
    	int result = 0;
    	
    	for(int i = 0 ; i< c.length;i++) {
    		result += Character.getNumericValue(c[i]);
    	}
    	
    	if(result >= 10) {
    		return addDigits(result);
    	}
    	else
    		return result;
    }
    
    /*
     *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *  Input: [0,1,0,3,12] Output: [1,3,12,0,0]
     */
    public static void moveZeroes(int[] nums) {
    		//TODO
    	int countZero= 0;
    	
    	List<Integer> num = new ArrayList<>();
    	for(int i=0; i<nums.length;i++) {
    		if(nums[i] == 0)
    			countZero++;
    		else
    			num.add(nums[i]);
    	}
    	while(countZero != 0) {
    		num.add(0);
    		countZero --;
    	}
    	
    	System.out.println(num);
    	
     }
	
    /*
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
     */
	public static String longestPalindrome(String s) {
		//TODO
		if(s.length() <= 1) return null;
		String result1 = null;
		List<String> list = new ArrayList<>();
		for(int i =0;i< s.length();i++) {
			for (int j=i; j< s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)){
					list.add(s.substring(i, j+1));
				}
			}
		}
		result1 = list.get(0);
		for(int i = 1;i<list.size();i++) {
			if(list.get(i).length() > result1.length()) {
				result1 = list.get(i);
			}
		}
		return result1;
    }
	
	public static String longestPalindrome2(String s) {
		if (s.length()<1) return null;
	    if (s.length() == 1) return s;
	    
	    int start = 0;
	    int max_len = 1;
	    
	    for (int i = 0; i < s.length();) {
	    	if (s.length() - i <= max_len / 2) 
	    		break;
	    	int left = i, right = i;
	    	while (right < s.length()-1 && s.charAt(right+1) == s.charAt(right)) 
	    		++right;
	    	i = right+1;
	    	while (right < s.length()-1 && left > 0 && s.charAt(right+1) == s.charAt(left-1)){ 
	    		++right; 
	    		--left; 
	    	} 
	    	int new_len = right - left + 1;
	    	if (new_len > max_len) { 
	    		start = right; 
	    		max_len = new_len; 
	    	}
	    }
	    return s.substring(start, max_len);
	}
	static int lo, maxLen;

	public static String longestPalindrome3(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private static void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	
    /*
     * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * Given input matrix = [ [1,2,3],
  			      			  [4,5,6],
  			      			  [7,8,9] ],
     * rotate the input matrix in-place such that it becomes: [  [7,4,1],
  								 								 [8,5,2],
  								  								 [9,6,3] ],
     */
	public static int[][] rotate(int[][] matrix) {
		// reverse it;
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //swap it diagonally;
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
        return matrix;
    }
    
}

