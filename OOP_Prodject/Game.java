package OOP_Prodject;

import java.rmi.server.SocketSecurityException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {

        View view = new View();
        ArrayList<String> c_data = view.data_import();
        Creator creator = new Creator();
        try {
            Character new_character = creator.create(c_data);
            System.out.println(new_character.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
