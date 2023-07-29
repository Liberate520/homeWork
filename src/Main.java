import view.Console;
import view.View;


public class Main {

    public static void main(String[] args) {

        // Human olgaKartaeva = new Human("Olga", "Serduk", LocalDate.of(1965, 3, 13), Gender.Female);
        // Human sergeyKartaev = new Human("Sergey", "Kartaev", LocalDate.of(1964, 6, 15), Gender.Male);

        View view = new Console();
        view.start();

    }
}
