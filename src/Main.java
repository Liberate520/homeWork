import humans.*;

public class Main {
    public static void main(String[] args){
        String path = "tree.txt";
        Service humService = new Service();
        humService.addHuman(Gender.Male, "Ivan", "Ivanov");
        humService.addHuman(Gender.Female, "Olga", "Ivanova");
        humService.getMarried("Ivan", "Olga");
        humService.addChild("Ivan", Gender.Female,"Masha");
        humService.addChild("Olga", Gender.Male,"Kolya");
        humService.addHuman(Gender.Male, "Sergey", "Sergeev");
        humService.getMarried("Masha", "Sergey");
        humService.addChild("Masha", Gender.Male,"Misha");
        humService.sortByName();
        System.out.println(humService.getInfo());
        Service dogServ = new Service();
        dogServ.addDog(Gender.Male, "Tuzik");
        dogServ.addDog(Gender.Male, "Sharik");
        dogServ.addDog(Gender.Female, "Nayda");
        dogServ.sortByName();
        System.out.println(dogServ.getInfo());
//        humService.save(humService.addHuman(), path);
//        FamilyTree newFamilyTree = service.upload(path);
//        Service newService = new Service(newFamilyTree);
//        System.out.println(newService.getInfo());
    }}