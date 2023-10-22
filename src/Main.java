import member.FamilyMember;
import member.Gender;
import member.Parent;
import tree.FamilyTree;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        FamilyTree myTree = new FamilyTree();

        Parent member1 = new Parent(
                "Nadezhda",
                "Petrova",
                "Alexandrovna",
                Gender.Female,
                "28.02.1954");

        Parent member2 = new Parent(
                "Alexandr",
                "Petrov",
                "Sergeevich",
                Gender.Male,
                "01.09.1953", "14.02.2015");

        FamilyMember member3 = new FamilyMember(
                "Andrey",
                "Petrov",
                "Sergeevich",
                Gender.Male,
                "28.03.1980");

        FamilyMember member4 = new FamilyMember(
                "Olga",
                "Petrova",
                "Sergeevna",
                Gender.Female,
                "16.10.1989");

        member3.setMother(member1);
        member4.setMother(member1);
        member3.setFather(member2);
        member4.setFather(member2);

        member1.addChild(member3);
        member1.addChild(member4);
        member2.addChild(member3);
        member2.addChild(member4);

        myTree.addFamilyMember(member1);
        myTree.addFamilyMember(member2);
        myTree.addFamilyMember(member3);
        myTree.addFamilyMember(member4);

        System.out.println(myTree.getFamilyMembersInfo());
        System.out.println(member3.getMother());
        System.out.println(member4.getFather());
        System.out.println(member2.getChildren());

    }
}
