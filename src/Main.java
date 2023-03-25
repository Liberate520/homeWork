import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTolstoy = new FamilyTree();
        //Human human1 = new Human(1828,1920, "Лев Николаевич Толстой",null,null);
        //Human human2 = new Human(1844,1919, "Софья Андреевна Толстая",null,null);
        Human human1 = new Human(1685,1728, "Иван Петрович Толстой",Gender.Male,null,null);
        Human human2 = new Human(1693,1748, "Прасковья Михайловна Ртищева",Gender.Female,null,null);
        Human human3 = new Human(1727,1811, "Александра Ивановна Щетинина",Gender.Female,human1,human2);
        Human human4 = new Human(1721,1803, "Андрей Иванович Толстой",Gender.Male,human1,human2);
        Human human5 = new Human(1724,1811, "Николай Иванович Горчаков",Gender.Male,human1,human2);
        Human human6 = new Human(1757,1820, "Прасковья Васильевна Толстая",Gender.Female,null,null);
        Human human7 = new Human(1757,1820, "Илья Андреевич Толстой",Gender.Male,human4,null);
        Human human8 = new Human(1757,1820, "Полагея Николаевна Горчакова",Gender.Female,human5,null);

        List<Human> members = new ArrayList(Arrays.asList(human1,human2,human3,human4,human5,human6,human7,human8));
        familyTolstoy.addMember(members);
        human1.setChildren(human3);
        human1.setChildren(human4);
        human1.setChildren(human5);
        human2.setChildren(human3);
        human2.setChildren(human4);
        human2.setChildren(human5);
        human4.setChildren(human7);
        human5.setChildren(human8);

        System.out.println("Члены семьи: "+ familyTolstoy);
        System.out.println("Дети :"+ human1.getChildren());
    }
}
