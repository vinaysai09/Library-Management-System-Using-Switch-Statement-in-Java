// To take Input from the student and related Information

import College.*;
// Importing required classes
import java.util.Scanner;

// Class
public class student {

	// Class member variables
	String studentName;
	String regNum;

	book borrowedBooks[] = new book[3];
	public int booksCount = 0;

	// Creating object of Scanner class to
	// take input from user
	Scanner input = new Scanner(System.in);

	// Constructor
	public student()
	{
		System.out.println("Enter Student Name:");

		this.studentName = input.nextLine();

		System.out.println("Enter Registration Number:");
		this.regNum = input.nextLine();
	}
}
