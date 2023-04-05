public class Main {
    static String file_name = "bd.csv";

    public static void main(String[] args) {
        FileCSV bd_file = new FileCSV(file_name);
        Tree<Person> family_tree = bd_file.readFile();
        
        Service service = new Service(family_tree, bd_file);
        ConsoleUI console = new ConsoleUI();
        new Presenter(service, console);

        console.start();
    }
}
