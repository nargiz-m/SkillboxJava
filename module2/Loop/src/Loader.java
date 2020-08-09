public class Loader
{
    public static void main(String[] args)
    {

        Integer i = 200000;

        //do while, в отличие от while, независимо от условия, выполняет тело цикла хотя бы раз
        do {
            System.out.println("Ticket number: " + i);
            i++;
        }
        while (i<=210000);

    }
}
