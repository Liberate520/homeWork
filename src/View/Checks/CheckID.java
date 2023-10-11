package View.Checks;

public class CheckID {
    public static int checkIDs(String id) {
        try{
            int ID = Integer.parseInt(id);
            return ID;
        }catch (NumberFormatException e){
            System.out.println("Некорректные данные " + e);
        }
        return 9999;
    }
}
