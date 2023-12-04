package WorkSeminar.model.Persona.Builder;

public class InputID {
    public static long inputsID(){
        try {
            System.out.println("Укажите ID обрабатываемого персонажа: ");
            long ID = Long.parseLong(Input.inputs());
            return ID;
        } catch (Exception ex){
            System.out.println("Не сработал ввод ID");
            ex.printStackTrace();
        }
        return -1;
    }
}
