import humans.*;

public class Main {
    public static void main(String[] args){
        String path = "tree.txt";
        Service service = new Service();
        service.addFamilyMember(Gender.Male, "Ivan", "Ivanov");
        service.addFamilyMember(Gender.Female, "Olga", "Ivanova");
        service.getFamilyTree().getMarried("Ivan", "Olga");
        service.getFamilyTree().addChild("Ivan", Gender.Female, "Masha");
        service.getFamilyTree().addChild("Olga", Gender.Male, "Kolya");
        service.addFamilyMember(Gender.Male, "Sergey", "Sergeev");
        service.getFamilyTree().getMarried("Masha", "Sergey");
        service.getFamilyTree().addChild("Masha", Gender.Male, "Misha");
        service.getInfo();
        System.out.println();
        service.sortByName();
        service.getInfo();
        System.out.println();
        service.sortByAmountOfChildren();
        service.getInfo();
//        service.save(service.getFamilyTree(), path);
//        FamilyTree newFamilyTree = service.upload(path);
//        Service newService = new Service(newFamilyTree);
//        newService.getFamilyTree().getInfo();
    }
}
