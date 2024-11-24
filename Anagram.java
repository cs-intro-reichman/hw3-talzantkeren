/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		/*System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");*/
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int countLet1 = 0;
		int countLet2 = 0;
		int i = 0;
		int b = 0;
		int a1 = 0, a2 = 0;
		for (i = 0; i < len1; i++) {
			if ((str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') || 
				(str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z')) {
				a1++;
			}
		}
		for (i = 0; i < len2; i++) {
			if ((str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z') || 
				(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z')) {
				a2++;
			}
		}
	
		if (a1 != a2) {
			return false;
		}
	
		i = 0; 
		while (i < len1) {
			if (!((str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') || 
				  (str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z'))) {
				i++;
				continue;
			}
	
			countLet1 = 0;
			countLet2 = 0;
	
			for (b = 0; b < len1; b++) {
				if (str1.charAt(b) == str1.charAt(i) || 
					(str1.charAt(b) >= 'a' && str1.charAt(b) == str1.charAt(i) + 32) || 
					(str1.charAt(b) >= 'A' && str1.charAt(b) == str1.charAt(i) - 32)) {
					countLet1++;
				}
			}
	
			for (b = 0; b < len2; b++) {
				if (str2.charAt(b) == str1.charAt(i) || 
					(str2.charAt(b) >= 'a' && str2.charAt(b) == str1.charAt(i) + 32) || 
					(str2.charAt(b) >= 'A' && str2.charAt(b) == str1.charAt(i) - 32)) {
					countLet2++;
				}
			}
	
			if (countLet1 != countLet2) {
				return false;
			}
	
			i++;
		}
	
		return true;
	}
	
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		int length= str.length();
		char []	allc = new char[length];
		int i = 0;
		String str1="";
		for(i=0;i<length;i++){
			if((str.charAt(i)>= 'a' && str.charAt(i)<= 'z')||(str.charAt(i) == 32)){
				allc[i]=str.charAt(i);
			}
			else{if((str.charAt(i)>= 'A' && str.charAt(i)<= 'Z')){
					allc[i]=(char)(str.charAt(i)+32);
					}
				
			else{
					allc[i]=34;
				}
			}
		}
		for(i=0;i<length;i++){
			if(allc[i]!=34)
			{
				str1+=allc[i]+"";
		    }
		}
		return str1;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int length = str.length();
		char [] allc = new char[length];
		int i = 0;
		String s="";
		for(i=0;i<length;i++){
			allc[i]=str.charAt(i);
		}
		for(i=0;i<length-1;i++){
			int random1 = (int)(Math.random() * length);
			int random2 = (int)(Math.random() * length);
			char c= allc[random1];
			allc[random1]=allc[random2];
			allc[random2]=c;
		}
		for(i=0;i<length;i++){
			s+=allc[i];
		}
		return s;
	}
}
