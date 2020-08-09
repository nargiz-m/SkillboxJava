import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Loader
{
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.of(1997, Month.FEBRUARY, 14);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = " ";
        int i = 0;


        while (date.isBefore(LocalDate.now()))
        {
            text = date.format(formatters);
            System.out.println(i + " - " + text + " - " + date.getDayOfWeek());
            date = date.plusYears(1);
            i++;
        }
    }
}
