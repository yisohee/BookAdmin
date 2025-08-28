package algorithm;

import java.util.Scanner;

import java.util.*;

class Book{
	public int page;
	public String name;
	public String author;
}

public class Main {	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
	
		
		//1)HashMap<String, Book> 선언

		HashMap<String, Book> h = new HashMap<>();
		
		Book b = new Book();
		b.name = "Java";
		b.author = "Lee";
		b.page = 400;
		h.put("1111", b);
		
		Book b2 = new Book();
		b2.name = "Python";
		b2.author = "Park";
		b2.page = 500;
		h.put("1234", b2);
	}

}
