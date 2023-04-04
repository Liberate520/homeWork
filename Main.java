import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner iscan = new Scanner(System.in);
    static String file_name = "bd.csv";
    public static void main(String[] args) {

        FileCSV bd_file = new FileCSV(file_name);
        Tree family_tree = bd_file.readFile();


        System.out.printf("Генеалогическое древо загружено!\nСостоит из %d человек",family_tree.size());

        StringBuilder help = new StringBuilder();
        help.append("\n\nОсновные комманды консоли:\n");
        help.append("show - показывает всех участников дерева\n");
        help.append("sort by name - показывает всех участников дерева с сортировкой по имени\n");
        help.append("id: 1679946500 - показывает подробную информацию о человеке\n");
        help.append("new.Name - Добавить нового человека(создает и присваевает id)\n");
        help.append("add.1679946500.sex.male - Добавить пол id:1679946500\n");
        help.append("add.1679946500.mother.1679946400 - Добавить id:1679946500 - мать id:1679946400\n");
        help.append("add.1679946500.father.1679946400 - Добавить отца, дети добавляются автоматически к родителям\n");
        help.append("save - сохраняет данные в файл\n");

        String command;
        System.out.println(help.toString());
        while (true) {
            command = fromUsersConsole("\n: ");
            if (command.equals("break"))
                break;

            if (command.equals("show"))
                System.out.println(family_tree);

            if (command.contains("id:")){
                String id_s = command.replaceAll("id:","").trim();
                int id = Integer.parseInt(id_s);
                System.out.println( family_tree.get(id) );
            }

            if (command.equals("save")){
                bd_file.saveFile(file_name, family_tree);
            }

            if (command.contains("add.")){
                String[] edit_arr = command.split("\\.");
                
                int id = Integer.parseInt(edit_arr[1]);
                String key = edit_arr[2];
                try {
                    int id_key = Integer.parseInt(edit_arr[3]);
                    Person pers = family_tree.get(id_key);
                    Person led_pers = family_tree.get(id);

                    if (key.equals("father")){
                        led_pers.setFather(pers);
                        pers.setPerson_childs(led_pers);
                        }
                    if (key.equals("mother")){
                        led_pers.setMother(pers);
                        pers.setPerson_childs(led_pers);
                        }
                    System.out.println( family_tree.get(id) ); 
                } catch (Exception e) {
                    if (key.equals("sex")){
                        family_tree.get(id).setPerson_sex(edit_arr[3]);
                        System.out.println( family_tree.get(id) );
                    }
                }
            }
            
            if (command.contains("new.")){
                String[] edit_arr = command.split("\\.");
                String name = edit_arr[1];
                family_tree.addPersons(name);
            } 

            if (command.contains("sort by name")){
                List<Person> persons_list = family_tree.getThePersonsList();
                // sortPersonsById(persons_list);
                sortPersonsByName(persons_list);
                System.out.println(persons_list.toString());
            }
                
        }
     
    }

    public static String fromUsersConsole(String msg) {
        System.out.print(msg);
        return iscan.nextLine();
    }


    public static void sortPersonsById(List<Person> pers_list) {
        pers_list.sort(new ComparatorById());
    }

    public static void sortPersonsByName(List<Person> pers_list) {
        pers_list.sort(new ComparatorByName());
    }
}
