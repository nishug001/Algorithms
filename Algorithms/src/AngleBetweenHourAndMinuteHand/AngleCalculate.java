package AngleBetweenHourAndMinuteHand;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AngleCalculate {

	static int hour;
	static int minutes;

	public static void main(String[] args) {
		if (getTime()) {
			calAngle();
		}
		else{
			System.out.println("Incorrect time format. Try again.");
		}

	}

	public static boolean getTime() {

		System.out.println("Please enter the time in HH:mm format.");
		Scanner scan = new Scanner(System.in);
		String strTime = scan.next();
		scan.close();

		DateFormat df = new SimpleDateFormat("HH:mm");
		try {
			Date date = df.parse(strTime);
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTime(date);
			hour = calendar.get(Calendar.HOUR);
			minutes = calendar.get(Calendar.MINUTE);
			return true;
		} catch (ParseException e) {
			System.out.println(e.getMessage());			
		}
		return false;
	}

	public static void calAngle() {
		double minuteHand = minutes * 6;
		double hourHand = 30 * (hour % 12) + minutes * 0.5;

		double AngleBtwHour_Minute_Hand = Math.abs(hourHand - minuteHand);

		if (AngleBtwHour_Minute_Hand <= 180) {
			System.out.println("Smallest angle is: " + AngleBtwHour_Minute_Hand + " degrees.");
		} else {
			AngleBtwHour_Minute_Hand = Math.abs(360 - AngleBtwHour_Minute_Hand);
			System.out.println("Smallest angle between hour and minute hand is: " + AngleBtwHour_Minute_Hand + " degrees.");
		}
	}
}