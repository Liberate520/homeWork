/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Human ancestor1 = new Human("John  Johnson", 1900, Gender.male);
        Human ancestor2 = new Human("Eliza  Johnson", 1910, Gender.female);
        Human ancestor3 = new Human("Donald  Ferguson", 1915, Gender.male);
        Human secondGen1 = new Human("Mike  Johnson", 1920, Gender.male);
        Human secondGen2 = new Human("Betty  Ferguson", 1930, Gender.female, null, ancestor3);
        Human thirdGen1 = new Human("Bobby  Johnson", 1940, Gender.male, secondGen2, secondGen1);
        Human thirdGen2 = new Human("Christine  Johnson", 1950, Gender.female);      
        Human thirdGen3 = new Human("Steve  Gomez", 1960, Gender.male, secondGen2, null);      
        
        FamilyTree family = new FamilyTree();
        family.addNewMember(ancestor1);
        family.addNewMember(ancestor2);
        family.addNewMember(ancestor3);
        family.addNewMemberChild(secondGen1, ancestor1);
        family.addNewMemberChild(secondGen1, ancestor2);
        family.addNewMember(secondGen2);
        family.addNewMember(thirdGen1);
        family.addNewMember(thirdGen2);
        family.addNewMember(thirdGen3);

        System.out.println(family);  
        
        System.out.println(secondGen2.getStringPresentationChildren());
    }
}

/*
 * OUTPUT
 * 
 * John  Johnson (1900) [male] 1 children,
 * Eliza  Johnson (1910) [female] 1 children,
 * Donald  Ferguson (1915) [male] 1 children,
 * Mike  Johnson (1920) [male] 1 children,  father: John  Johnson  mother: Eliza  Johnson
 * Betty  Ferguson (1930) [female] 2 children,  father: Donald  Johnson
 * Bobby  Johnson (1940) [male] 0 children,  father: Mike  Johnson  mother: Betty  Johnson
 * Christine  Johnson (1950) [female] 0 children,
 * Steve  Johnson (1960) [male] 0 children,  mother: Betty  Johnson
 * 
 * Bobby  Johnson (1940) [male] 0 children,  father: Mike  Johnson  mother: Betty  Johnson
 * Steve  Gomez (1960) [male] 0 children,  mother: Betty  Johnson
 * 
 * 
 */