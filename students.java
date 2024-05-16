// To Do all the Operations related to students:
// add Students,check-in books,check out books,ValidStudent

import College.*;
// Importing required classes
import java.util.Scanner;

// Class
public class students {

	// Creating objects of Scanner and students class
	Scanner input = new Scanner(System.in);
	student theStudents[] = new student[50];

	public static int count = 0;

	// To add books
	public void addStudent(student s)
	{
		for (int i = 0; i < count; i++) {

			if (s.regNum.equalsIgnoreCase(
					theStudents[i].regNum)) {

				System.out.println(
					"Student of Reg Num " + s.regNum
					+ " is Already Registered.");

				return;
			}
		}

		if (count <= 50) {
			theStudents[count] = s;
			count++;
		}
	}

	// Displaying all students
	public void showAllStudents()
	{
		// Printing student name and
		// corresponding registered number
		System.out.println("Student Name\t\tReg Number");
		for (int i = 0; i < count; i++) {

			System.out.println(theStudents[i].studentName
							+ "\t\t"
							+ theStudents[i].regNum);
		}
	}

	// To check the Student
	public int isStudent()
	{
		System.out.println("Enter Reg Number:");

		String regNum = input.nextLine();

		for (int i = 0; i < count; i++) {

			if (theStudents[i].regNum.equalsIgnoreCase(
					regNum)) {
				return i;
			}
		}

		System.out.println("Student is not Registered.");
		System.out.println("Get Registered First.");

		return -1;
	}

	// To remove the book
	public void checkOutBook(books book)
	{
		int studentIndex = this.isStudent();

		if (studentIndex != -1) {
			System.out.println("checking out");

			book.showAllBooks();
			book b = book.checkOutBook();

			System.out.println("checking out");
			if (b != null) {

				if (theStudents[studentIndex].booksCount
					<= 3) {

					System.out.println("adding book");
					theStudents[studentIndex].borrowedBooks
						[theStudents[studentIndex]
							.booksCount]
						= b;
					theStudents[studentIndex].booksCount++;

					return;
				}
				else {

					System.out.println(
						"Student Can not Borrow more than 3 Books.");
					return;
				}
			}
			System.out.println("Book is not Available.");
		}
	}

	// To add the book
	public void checkInBook(books book)
	{
		int studentIndex = this.isStudent();
		if (studentIndex != -1) {

			// Printing credentials corresponding to student
			System.out.println(
				"S.No\t\t\tBook Name\t\t\tAuthor Name");

			student s = theStudents[studentIndex];

			for (int i = 0; i < s.booksCount; i++) {

				System.out.println(
					s.borrowedBooks[i].sNo + "\t\t\t"
					+ s.borrowedBooks[i].bookName + "\t\t\t"
					+ s.borrowedBooks[i].authorName);
			}

			System.out.println(
				"Enter Serial Number of Book to be Checked In:");

			int sNo = input.nextInt();

			for (int i = 0; i < s.booksCount; i++) {
				if (sNo == s.borrowedBooks[i].sNo) {
					book.checkInBook(s.borrowedBooks[i]);
					s.borrowedBooks[i] = null;

					return;
				}
			}

			System.out.println("Book of Serial No " + sNo
							+ "not Found");
		}
	}
}
