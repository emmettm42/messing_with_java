package exercises;
// Emmett Maloney
// CS 120
// NCC, Fall 2016

public class PigLatin {
	public static void main(String[] args){
		String a = "nitrogen"; String b = "berrilium"; String c = "einstinium"; String d = "pallidium"; String e= "quantomphysisian";
		System.out.println(pigLatin(a));
		System.out.println(pigLatin(b));
		System.out.println(pigLatin(c));
		System.out.println(pigLatin(d));
		System.out.println(pigLatin(e));
	}
	
	public static String pigLatin(String s){
		if (s.charAt(0) == 'a' ||s.charAt(0) == 'e' ||
			s.charAt(0) == 'i' ||s.charAt(0) == 'o' ||
			s.charAt(0) == 'u' ||s.charAt(0) == 'y'){
			s = s + "way";
		} else
			s = s.substring(1) + s.substring(0, 1) + "ay";
		return s;
	}

}
