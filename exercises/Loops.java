package exercises;
// Emmett Maloney
// CS 120
// NCC, Fall 2016

public class Loops {
	public static void main(String[] args){

		// Write a 'While' Loop that prints 0 to 10
		int i = 0;
		while (i < 11){
			System.out.println(i);
			i++;
		}

		// Write a 'for' loop that prints multiples of 5, from 0 to 25
		for(int j = 0; j <= 25; j += 5)
			System.out.println(j);


		// Write a 'for' that adds 10 'a's to a string
		// Output should be "Laaaaaaaaaa"
		String s = "l";
		String a = "a";
		for(int i = 0; i < 10; i++){
			s = s + a;
		}
		System.out.println(s);

		// Write a loop that counts down from 10 to 0
		int k = 10;
		while(k >= 0){
			System.out.println(k);
			k--;
		}
	}
}
