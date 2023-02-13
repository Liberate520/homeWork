package homeWork;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("______________");
        Human Ivan = new Human("Иван", "Иванов", "Иванович", GenderType.муж, 1960, 03, 07, "Валентина", "Николай", "Ольга");
        System.out.println(Ivan);

        ArrayList<Child> children = new ArrayList<>();

        Child Pavel = new Child("Павел", "Иванов", "Иванович", GenderType.муж,1990, 12, 02, "нет", Ivan.getName(), "Валентина");

        Child Aleksandra = new Child("Александра", "Иванова", "Ивановна", GenderType.жен,1998, 10, 12, "нет", Ivan.getName(), "Валентина");

        
        Ivan.addChild(children, Pavel);
        Ivan.addChild(children, Aleksandra);    
        Ivan.allChildren();

    }


} 

