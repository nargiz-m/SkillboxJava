import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;
import org.javagram.response.object.ContactStatus;
import org.javagram.response.object.UserContact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Loader
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.40:443", 753054, "22b898be78a071bf61e78879c226daf0");

        //9996624444
        System.out.println("Please, type the phone number: ");
        String phone = reader.readLine().trim().replaceAll("[^0-9]","");
        AuthCheckedPhone checkedPhone = bridge.authCheckPhone(phone);
        System.out.println(checkedPhone.isRegistered());

        AuthSentCode sentCode = bridge.authSendCode(phone);
        System.out.println(sentCode.isRegistered());

        //22222
        System.out.println("Please, type the code from SMS: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String smsCode = reader.readLine().trim();
        AuthAuthorization authAuthorization = bridge.authSignIn(smsCode);
        System.out.println(authAuthorization.getUser());

        ArrayList<UserContact> contacts = bridge.contactsGetContacts();
        for (int i=0; i < contacts.size(); i++){
            System.out.println(contacts.get(i) + " " + contacts.get(i).getPhone());
        }

    }
}
