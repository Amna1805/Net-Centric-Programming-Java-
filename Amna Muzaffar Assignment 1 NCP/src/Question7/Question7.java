package Question7;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Question7 {
    public static void main(String[] argv) {
        if (argv.length != 1) {
            System.out.println("Please provide your birthdate in the format yyyy-MM-dd");
            return;
        }

        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = date.parse(argv[0]);
            Date currentDate = new Date();

            Calendar birthCalendar = Calendar.getInstance();
            birthCalendar.setTime(birthDate);
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(currentDate);

            int years = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
            int months = currentCalendar.get(Calendar.MONTH) - birthCalendar.get(Calendar.MONTH);
            int days = currentCalendar.get(Calendar.DAY_OF_MONTH) - birthCalendar.get(Calendar.DAY_OF_MONTH);

            if (days < 0) {
                months--;
                days += currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            }

            if (months < 0) {
                years--;
                months += 12;
            }

            System.out.println("You are " + years + " years, " + months + " months, and " + days + " days old.");

            System.out.println("List of your birthday days since you were born:");
            int birthYear = birthCalendar.get(Calendar.YEAR);
            for (int year = birthYear; year <= currentCalendar.get(Calendar.YEAR); year++) {
                birthCalendar.set(Calendar.YEAR, year);
                Date birthday = birthCalendar.getTime();
                SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
                String dayOfWeek = dayFormat.format(birthday);
                System.out.println(year + ": " + dayOfWeek);
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
    }
}
