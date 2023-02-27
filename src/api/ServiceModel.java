package api;

import java.io.IOException;

public class ServiceModel implements Service
{
    private static final String EMPTY_ERROR = "Ошибка ввода!\r";
    private Integer menu;

    public FamilyTree<Person> familyTree;

    public ServiceModel()
    {
        FamilyTree<Person> familyTree = new FamilyTree<>();
    }
    public String get(String stringToParse) throws IOException, ClassNotFoundException {

        //familyTree = FamilyTree.initData();

        api.FileHandler fileHandler = new api.FileHandler();
        familyTree = (api.FamilyTree)fileHandler.read();

        String answer = "";
        if (stringToParse.equals(""))
        {
            return EMPTY_ERROR;
        }

        try
        {
            String[] args = stringToParse.split(" ");

            menu = Integer.parseInt(args[0]);
            switch(menu) {
                case 1:
                {
                    if (args.length == 1)
                    {
                        answer = "\nВведите имя, например: Михаил Федорович\n> ";
                    }
                    else
                    {
                        answer = familyTree.searchChildrenByFathersName(args[1] + " " + args[2]);
                    }
//                  System.out.printf("\nВведите имя, например: Михаил Федорович\n> ");
//                  nameToSearch = scan.nextLine();
//                  familyTree.searchChildrenByFathersName(nameToSearch);

                    break;
                }
                case 2:
                {
                    answer = familyTree.printAll();
                    break;
                }
                case 3:
                {
                    // Print using Iterator
                    for (api.Person person: familyTree)
                    {
                        answer += person.toString();
                    }
                    answer += "\n";
                    break;
                }
                case 4:
                {
                    familyTree.sortByName();
                    fileHandler.save(familyTree);

                    answer = "Отсортировано по имени!\n";
                    break;
                }
                case 5:
                {
                    familyTree.sortByDateOfBirth();
                    fileHandler.save(familyTree);

                    answer = "Отсортировано по дате рождения!\n";
                    break;
                }
                case 6:
                {
                    //fileHandler = new api.FileHandler();
                    answer = fileHandler.save(familyTree);

                    break;
                }
                case 7:
                {
                    familyTree = FamilyTree.initData();
                    answer = fileHandler.save(familyTree);

                    //fileHandler = new api.FileHandler();
                    familyTree = (api.FamilyTree)fileHandler.read();

                    answer = "Восстановление!\n";
//                    //familyTree.printAll();
                    break;
                }
                default:
                {
                    answer = "Ошибка ввода!\n";
                }
            }

            //String info = connection.getInfo(city);
            //Weather weather = formatter.parse(info);
            //String answer = weather.toString();

            return answer;
        }
        catch (NullPointerException e)
        {
            return "Ошибка ввода!\r";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
