import java.util.ArrayList;

public class Loader
{
    public static void main(String[] args) //throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        String item = getFirstItem(list);
        //String item;
        System.out.println("First item: " + item);
        //try {
        //    item = list.get(0);
        //}
        //catch (IndexOutOfBoundsException e){
        //    System.out.println("Error: " + e.getMessage());
        //    item = null;
        //    e.printStackTrace();
        //}
        //System.out.println("First item: " + item);
    }

    public static String getFirstItem(ArrayList<String> list) //throws Exception
    {
        if(list.size() == 0)
        {
            //throw new Exception("List is empty");
            //throw new RuntimeException("List is empty");
            throw new IllegalArgumentException("List is empty");
        }
        return list.get(0);
    }
}
