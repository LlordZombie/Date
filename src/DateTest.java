import java.time.LocalDate;

public class DateTest {

	public static void main(String[] args) {

		Date d1 = new Date();
		System.out.println("d1 is " + d1 + " [ January 1, 1900 ]");

		System.out.println("d1.isLeapYear() is " + d1.isLeapYear() + " [ false ]");
		System.out.println("d1.lastDayInMonth() is " + d1.lastDayInMonth() + " [ 31 ]");

		// Mind the order of the parameters!
		Date d2 = new Date(12, 27, 2015); // December 27, 2015
		System.out.println("\nd2 is " + d2 + " [ December 27, 2015 ]");

		Date d3 = new Date(0, 99, 8045); // invalid date -> January 1, 1900
		System.out.println("d3 is " + d3 + " [ January 1, 1900 ]");

		d3.setDate(2, 28, 2012);

		System.out.println("\nd3 is " + d3 + " [ February 28, 2012 ]");
		System.out.println("d3.lastDayInMonth() is " + d3.lastDayInMonth() + " [ 29 ]");

		d3.inc(); // increment to next day (changes d3)
		System.out.println("d3.inc() is " + d3 + " (leap year allows 29th)" + " [ February 29, 2012 ]");

		d2.inc(7); // increment 7 days (changes d2)
		System.out.println("\nd2.inc(7) is " + d2 + " [ January 3, 2016 ]");

		System.out.println("\nd1 = " + d1 + " [ January 1, 1900 ]");
		d1.inc(43734);
		System.out.println("   + 43734 days is " + d1 + " [ September 28, 2019 ]"); // how to check the
														// result?

		Date d4 = new Date(2, 29, 2012);
		if (d4.equals(d3)) {
			System.out.println("\nd4 equals d3" + " [ OK ]");
		} else {
			System.out.println("\nd4 equals not d3"  + " [ FAIL ]");
		}

		// Special cases
		Date s1 = new Date(0, 2, 2000); // bad
		System.out.println("\ns1 = " + s1 + " [ January 1, 1900 ]");
		Date s2 = new Date(13, 2, 2000); // bad
		System.out.println("s2 = " + s2 + " [ January 1, 1900 ]");
		Date s3 = new Date(2, 0, 2000); // bad
		System.out.println("s3 = " + s3 + " [ January 1, 1900 ]");
		Date s4 = new Date(32, 3, 2000); // bad
		System.out.println("s4 = " + s4 + " [ January 1, 1900 ]");
		Date s5 = new Date(2, 29, 1900); // bad
		System.out.println("s5 = " + s5 + " [ January 1, 1900 ]");
		Date s6 = new Date(2, 29, 2000); // ok
		System.out.println("s6 = " + s6 + " [ February 29, 2000 ]");



		System.out.println("d4 - Day of year = " + d4.dayOfYear() + " [ 60 ]"); //  count from  January 1
		System.out.println("d4 - Day of week = " + d4.dayOfWeek() + " [ 3 ]"); // 0-Sunday, 1-Monday,...,6-Saturday


		Date today = new Date(11, 26, 2019);
		System.out.println("\ntoday = " + today);
		System.out.println("today - Day of year = " + today.dayOfYear());
		System.out.println("today - Day of week = " + today.dayOfWeek());


	}
}
