import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Family_tree {
    private static Scanner iscan = new Scanner(System.in);
    static String file_name = "bd.csv";
    public static void main(String[] args) {
        FileCSV bd_file = new FileCSV();
        Map<Integer, LinkedHashMap<String, String>> bd_tree = bd_file.readFile(file_name);
        Tree family_tree = new Tree(bd_tree);

        System.out.printf("Генеалогическое древо загружено!\nСостоит из %d человек",family_tree.persons_list.size());

        StringBuilder help = new StringBuilder();
        help.append("\nОсновные комманды консоли:\n");
        help.append("show - показывает всех участников дерева");
        help.append("id: 1679946500 - показывает подробную информацию о человеке");
        help.append("new.Name - Добавить нового человека(создает и присваевает id)");
        help.append("add.1679946500.sex.male - Добавить пол id:1679946500 ");
        help.append("add.1679946500.mother.1679946400 - Добавить id:1679946500 - мать id:1679946400");
        help.append("add.1679946500.father.1679946400 - Добавить id:1679946500 - отца id:1679946400");

        String command;
        while (true) {
            command = fromUsersConsole("\n: ");
            if (command.equals("break"))
                break;

            if (command.equals("show"))
                family_tree.show();

            if (command.contains("id:")){
                String id_s = command.replaceAll("id:","").trim();
                int id = Integer.parseInt(id_s);
                System.out.println( family_tree.persons_list.get(id) );
            }

            if (command.equals("save")){
                bd_file.convertPersonslistToMap(family_tree.persons_list);

                bd_file.saveFile(file_name);
            }

            if (command.contains("add.")){
                String[] edit_arr = command.split("\\.");
                
                int id = Integer.parseInt(edit_arr[1]);
                String key = edit_arr[2];
                try {
                    int id_key = Integer.parseInt(edit_arr[3]);
                    Person pers = family_tree.persons_list.get(id_key);
                    Person led_pers = family_tree.persons_list.get(id);

                    if (key.equals("father")){
                        led_pers.setFather(pers);
                        pers.setPerson_childs(led_pers);
                        }
                    if (key.equals("mother")){
                        led_pers.setMother(pers);
                        pers.setPerson_childs(led_pers);
                        }
                    // if (key.equals("child"))
                    //     family_tree.persons_list.get(id).setPerson_childs(pers);  
                } catch (Exception e) {
                    if (key.equals("sex"))
                        family_tree.persons_list.get(id).setPerson_sex(edit_arr[3]);
                }
                
            }
            
            if (command.contains("new.")){
                String[] edit_arr = command.split("\\.");
                String name = edit_arr[1];
                family_tree.addPersons(name);
            } 
                // new.person.Petrov Sergey
                // add.1679945990.father.1679925750
                // searchById
                // addPersonsParents

                
        }
     
    }

    public static String fromUsersConsole(String msg) {
        System.out.print(msg);
        return iscan.nextLine();
    }
}
