package gui.gaspar.challenges;

import java.util.HashMap;
import java.util.Map;

public class JavaChallenges {

	//	Given a non-empty array, return true if there is a place to split the array so that 
	//	the sum of the numbers on one side is equal to the sum of the numbers on the other side.
	//
	//			canBalance([1, 1, 1, 2, 1]) → true
	//			canBalance([2, 1, 1, 2, 1]) → false
	//			canBalance([10, 10]) → true
	public boolean canBalance(int[] nums) {
	    int i = nums.length;
		for(int x = i; x > 0; x--){
			int firstSum = 0;
			int secondSum = 0;	
				
			int splitVar = x - 1;
			while(splitVar < i){
				secondSum =  secondSum + nums[splitVar];
				splitVar++;
			}
				
			splitVar = x - 2;
			while(splitVar >= 0){
				firstSum =  firstSum + nums[splitVar];
				splitVar--;
			}
				
			if(firstSum == secondSum){
				return true;
			}
		}
		return false;
	}
	
	//	Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer.
	//	The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order.
	//
	//	linearIn([1, 2, 4, 6], [2, 4]) → true
	//	linearIn([1, 2, 4, 6], [2, 3, 4]) → false
	//	linearIn([1, 2, 4, 4, 6], [2, 4]) → true
	public boolean linearIn(int[] outer, int[] inner) {
		 int outerIndex = 0;
		 for(int innerIndex = 0; innerIndex < inner.length; innerIndex++)
		 {
			while(outerIndex < outer.length && outer[outerIndex] < inner[innerIndex])  {
				outerIndex++;
		    }
		    if(outerIndex >= outer.length || outer[outerIndex] != inner[innerIndex]){
		        return false;
		    }
		 }
		 return true;		
	}
	
	//	Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to show the grouping). 
	//	Note that the length of the array will be 1 + 2 + 3 ... + n, which is known to sum to exactly n*(n + 1)/2.
	//
	//	seriesUp(3) → [1, 1, 2, 1, 2, 3]
	//	seriesUp(4) → [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
	//	seriesUp(2) → [1, 1, 2]
	public int[] seriesUp(int n) {
		int arraySize = n*(n + 1)/2;
		int[] series = new int[arraySize];
		int control = 1;
		int y = 0;
		while(control <= n && n!=0){
			for(int x=1; x <= control;x++){
				series[y] = x;
				y++;
			}
			control++;
		}
		return series;
	}
	
	//	Given a map of food keys and topping values, modify and return the map as follows: if the key "ice cream" is present, set its value to "cherry". 
	//	In all cases, set the key "bread" to have the value "butter".
	//
	//	topping1({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
	//	topping1({}) → {"bread": "butter"}
	//	topping1({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}
	public Map<String, String> topping1(Map<String, String> map) {
		Map<String, String> resultMap = new HashMap<String, String>();
		map.remove("bread");
		resultMap.put("bread", "butter");
		if(!map.isEmpty()){
			for (Map.Entry<String, String> entry : map.entrySet())
			{
			    if(entry.getKey().equalsIgnoreCase("ice cream")){
			    	resultMap.put(entry.getKey(), "cherry");
			    }else{
			    	resultMap.put(entry.getKey(), entry.getValue());
			    }
			}
		}
		return resultMap;
	}
	
	//	Given 3 int values, a b c, return their sum. However, if one of the values is the 
	//	same as another of the values, it does not count towards the sum.
	//
	//	loneSum(1, 2, 3) → 6
	//	loneSum(3, 2, 3) → 2
	//	loneSum(3, 3, 3) → 0
	public int loneSum(int a, int b, int c) {
		int total = 0;

		if(a == b && a == c && b == c)
			return total;
		
		if(a == b)
			total = c;
		else if(a == c)
			total = b;
		else if(b == c)
			total = a;
		else
			total = a + b + c;
			
		return total;
	}
	
	//	Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it 
	//	does not count towards the sum and values to its right do not count. 
	//	So for example, if b is 13, then both b and c do not count.
	//
	//	luckySum(1, 2, 3) → 6
	//	luckySum(1, 2, 13) → 3
	//	luckySum(1, 13, 3) → 1
	public int luckySum(int a, int b, int c) {
		 int total;
		 if(a == 13)
			 total = 0;
		 else if(b == 13)
			 total = a;
		 else if(c == 13)
			 total = a + b;
		 else
			 total = a + b + c;
			 
		 return total;
	}

	//	Given three ints, a b c, one of them is small, one is medium and one is large. 
	//  Return true if the three values are evenly spaced, so the difference between small and medium 
	//	is the same as the difference between medium and large.
	//
	//	evenlySpaced(2, 4, 6) → true
	//	evenlySpaced(4, 6, 2) → true
	//	evenlySpaced(4, 6, 3) → false
	public boolean evenlySpacedV1(int a, int b, int c) {
		int difference = 0;
		if(a > b && a > c){
			if(b > c){
				difference = a - b;
				if(b - c == difference)
					return true;
				else
					return false;
			}else{
				difference = a - c;
				if(c - b == difference)
					return true;
				else
					return false;
			}
		}else if(b > a && b > c){
			if(a > c){
				difference = b - a;
				if(a - c == difference)
					return true;
				else
					return false;
			}else{
				difference = b - c;
				if(c - a == difference)
					return true;
				else
					return false;
			}
		}else if(c > a && c > b){
			if(a > b){
				difference = c - a;
				if(a - b == difference)
					return true;
				else
					return false;
			}else{
				difference = c - b;
				if(b - a == difference)
					return true;
				else
					return false;
			}
		}else if(a == b && b == c && a == c){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Previously exercise but now using the library Math
	 */
	public boolean evenlySpaced(int a, int b, int c) {
		if(a == b && b == c)
			return true;
		
		//If hit here, means that we have 2 equal numbers and 1 different, must return false.
		if(a==b || b==c || a==c) 
			return false;
		
		if(Math.abs(a - b) == Math.abs(a - c) || 
		   Math.abs(a - c) == Math.abs(b - c) ||
		   Math.abs(b - c) == Math.abs(a - b) )
			return true;
		else{
			return false;
		}	
	}
	
	//	Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1),
	//	while the other is "far", differing from both other values by 2 or more. 
	//	Note: Math.abs(num) computes the absolute value of a number.
	//
	//	closeFar(1, 2, 10) → true
	//	closeFar(1, 2, 3) → false
	//	closeFar(4, 1, 3) → true
	public boolean closeFar(int a, int b, int c) {	
		if(Math.abs(a - b) == 0 || Math.abs(a - c) == 0){
			if(Math.abs(a - b) >= 2 || Math.abs(a - c) >= 2 || Math.abs(b - c) >= 2){
				return true;
			}else{
				return false;
			}
		}
		if(Math.abs(a - b) == 1 || Math.abs(a - c) == 1){
			if(Math.abs(a - b) > 2 || Math.abs(a - c) > 2 || Math.abs(b - c) > 2){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	//	Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. 
	//	Return 0 if they both go over.
	//
	//	blackjack(19, 21) → 21
	//	blackjack(21, 19) → 21
	//	blackjack(19, 22) → 19
	public int blackjack(int a, int b) {
		int auxFirst = 0;
		int auxSecond = 0;
		if(a > 21 && b > 21){
			return 0;
		}
		
		if(a <= 21){
			auxFirst = 21 - a;
		}else{
			return b;
		}
		
		if(b <= 21){
			auxSecond = 21 - b;
		}else{
			return a;
		}
		
		if(auxFirst < auxSecond){
			return a;
		}else{
			return b;
		}
	}
	
	// https://coderbyte.com
	//	Challenge
	//	Using the Java language, have the function FirstFactorial(num) take the num parameter 
	// being passed and return the factorial of it (e.g. if num = 4, return (4 * 3 * 2 * 1)). 
	// For the test cases, the range will be between 1 and 18 and the input will always be an integer.
	//	Sample Test Cases
	//
	//	Input:4
	//
	//	Output:24
	//
	//	Input:8
	//
	//	Output:40320
	public static int FirstFactorial(int num) { 
		int result = num;
		int aux = num - 1;
		while(aux > 0){
			result = result * aux;
			aux--;
		}
		return result;
	} 
	
	//	Given a string that contains a single pair of parenthesis, compute recursively a new string 
	//	made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".
	//
	//	parenBit("xyz(abc)123") → "(abc)"
	//	parenBit("x(hello)") → "(hello)"
	//	parenBit("(xy)1") → "(xy)"
	public String parenBit(String str) {
	    int size = str.length() - 1;
		int lastIndex = 0;
		int firstIndex = 0;
		while(size>0){
			if(String.valueOf(str.charAt(size)).equalsIgnoreCase(")")){
				lastIndex = size;
			}
			if(String.valueOf(str.charAt(size)).equalsIgnoreCase("(")){
				firstIndex = size;
				break;
			}
			size--;
		}
		return str.substring(firstIndex, lastIndex + 1);	
	}

	//	Modify and return the given map as follows: if the key "a" has a value, set the key "b" to 
	//	have that same value. In all cases remove the key "c", leaving the rest of the map unchanged.
	//
	//	mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
	//	mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
	//	mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
	public Map<String, String> mapShare(Map<String, String> map) {
		Map<String, String> resultMap = new HashMap<String, String>();
		if(map.containsKey("a")){
			map.remove("b");
		}
		for (Map.Entry<String, String> entry : map.entrySet()){
			if(entry.getKey().equalsIgnoreCase("a")){
				resultMap.put(entry.getKey(), entry.getValue());
				resultMap.put("b", entry.getValue());
			}
			if(!entry.getKey().equalsIgnoreCase("c")){
				resultMap.put(entry.getKey(), entry.getValue());
			}
		}
		return resultMap;
	}
	
	//	We'll say that a String is xy-balanced if for all the 'x' chars in the string, 
	//	there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. 
	//	One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.
	//
	//	xyBalance("aaxbby") → true
	//	xyBalance("aaxbb") → false
	//	xyBalance("yaaxbb") → false
	public boolean xyBalance(String str) {
		boolean haveX = true;
		boolean haveY = true;
		int index = 0;
		while(index<str.length()){
			if(String.valueOf(str.charAt(index)).equalsIgnoreCase("x")){
				haveX = true;
				haveY = false;
			}
			if(String.valueOf(str.charAt(index)).equalsIgnoreCase("y")){
				haveY = true;
			}
			index++;
		}
		if(haveY && haveX){
			return true;
		}else{
			return false;
		}
	}
	
	//	Given a string, consider the prefix string made of the first N chars of the string. 
	//	Does that prefix string appear somewhere else in the string? 
	//	Assume that the string is not empty and that N is in the range 1..str.length().
	//
	//	prefixAgain("abXYabc", 1) → true
	//	prefixAgain("abXYabc", 2) → true
	//	prefixAgain("abXYabc", 3) → false
	public boolean prefixAgain(String str, int n) {
		String prefix = String.valueOf(str.subSequence(0, n));
		String restOfTheWord = String.valueOf(str.subSequence(n, str.length()));
		if(restOfTheWord.contains(prefix)){
			return true;
		}else{
			return false;
		}
	}	
	
}