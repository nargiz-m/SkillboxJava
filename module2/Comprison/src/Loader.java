public class Loader
{
    public static void main(String[] args)
    {

        Integer dimaAge = 35;
        Integer mishaAge = 55;
        Integer vasyaAge = 16;

        Integer oldest = dimaAge;
        Integer youngest = dimaAge;
        Integer middle = dimaAge;

        if (mishaAge>oldest)
        {
            oldest = mishaAge;
        }
        if (vasyaAge>oldest)
        {
            oldest = vasyaAge;
        }

        if (mishaAge<youngest)
        {
            youngest = mishaAge;
        }
        if (vasyaAge<youngest)
        {
            youngest = vasyaAge;
        }

        if (mishaAge<oldest && mishaAge>youngest)
        {
            middle = mishaAge;
        }
        if (vasyaAge<oldest && vasyaAge>youngest)
        {
            middle = vasyaAge;
        }

        System.out.println("Most old: " + oldest);
        System.out.println("Most young: " + youngest);
        System.out.println("Middle: " + middle);
    }
}
