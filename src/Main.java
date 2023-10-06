import FileWork.FileWork;
import Human.Gender;
public class Main {
    public static void main(String[] args ){
        Service service = new Service();
//        Service service = (Service)filework.read("Family.dat");
        service.addHuman("Vasja", "Pupkin", Gender.M, 22);
        service.addHuman("Petya", "Zupkin", Gender.M,45);
        service.addHuman("Vasja", "Grivkin", Gender.M, 64);
        service.addHuman("Olga", "Kuzina", Gender.W, 11);
        service.addHuman("Natasha", "Ivanova", Gender.W, 55);
        service.addHuman("Andrey", "Kozlov", Gender.M, 33);
        service.addHuman("Alex", "Petrov", Gender.M,12);
        service.addHuman("Masha", "Medvedeva", Gender.W,72);
        service.addHuman("Gora", "Kornev", Gender.M, 60);
        service.addHuman("Dunja", "Kulakova", Gender.W, 25);


        FileWork filework = new FileWork();


       filework.write(service, "Family.dat");
        System.out.println(service.getHumanListInfo());
        service.sortAge();
        System.out.println(service.getHumanListInfo());
        service.sortName();
        System.out.println(service.getHumanListInfo());


    }
}
