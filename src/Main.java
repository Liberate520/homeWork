import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTolstoy = new FamilyTree();
        //Human member1 = new Human(1828,1920, "Лев Николаевич Толстой",null,null);
        //Human member2 = new Human(1844,1919, "Софья Андреевна Толстая",null,null);
        Member member1 = new Member(1685,1728, "Иван Петрович Толстой",Gender.Male,null,null);
        Member member2 = new Member(1693,1748, "Прасковья Михайловна Ртищева",Gender.Female,null,null);
        Member human3 = new Member(1727,1811, "Александра Ивановна Щетинина",Gender.Female,member1,member2);
        Member human4 = new Member(1721,1803, "Андрей Иванович Толстой",Gender.Male,member1,member2);
        Member human5 = new Member(1724,1811, "Николай Иванович Горчаков",Gender.Male,member1,member2);
        Member human6 = new Member(1757,1820, "Прасковья Васильевна Толстая",Gender.Female,null,null);
        Member human7 = new Member(1757,1820, "Илья Андреевич Толстой",Gender.Male,human4,null);
        Member human8 = new Member(1757,1820, "Полагея Николаевна Горчакова",Gender.Female,human5,null);

        List<Member> members = new ArrayList(Arrays.asList(member1,member2,human3,human4,human5,human6,human7,human8));
        familyTolstoy.addAllMember(members);

        System.out.println("Члены семьи: "+ familyTolstoy);
        System.out.println("Дети :"+ member1.getChildren());
    }
}
