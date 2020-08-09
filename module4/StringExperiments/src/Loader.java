import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader
{
    public static void main(String[] args) throws IOException
    {
        for (int i = 0; i < 513; i++)
        {
            System.out.print(i);
            System.out.println(" " + (char) i);
        }
        //Коды русских букв находятся в диапазоне 1040-1103

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String vasya = text.substring(text.indexOf("заработал")+"заработал".length(),text.indexOf("руб")).trim();
        int vasyaIncome = Integer.parseInt(vasya);
        String masha = text.substring(text.lastIndexOf("-")+"-".length(),text.lastIndexOf("руб")).trim();
        int mashaIncome = Integer.parseInt(masha);
        System.out.println("Сумма заработка Васи и Маши: " + (vasyaIncome + mashaIncome));

        String fullName = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        String name = fullName.substring(0,fullName.indexOf(" ")).trim();
        String surname = fullName.substring(fullName.indexOf(" "),fullName.lastIndexOf(" ")).trim();
        String patronymic = fullName.substring(fullName.lastIndexOf(" ")).trim();
        System.out.println("Фамилия: " + name);
        System.out.println("Имя: " + surname);
        System.out.println("Отчество: " + patronymic);

        String income[] = text.replaceAll("[^0-9\\s*,\\s*]","").trim().split("\\s*,\\s*");
        int sum = 0;
        for (int i = 0; i < income.length; i++)
        {
            sum = sum + Integer.parseInt(income[i]);
        }
        System.out.println("Общая сумма заработка: " + sum);

        String nameArray[] = fullName.split(" ");
        System.out.println("Фамилия: " + nameArray[0]);
        System.out.println("Имя: " + nameArray[1]);
        System.out.println("Отчество: " + nameArray[2]);
    }
}