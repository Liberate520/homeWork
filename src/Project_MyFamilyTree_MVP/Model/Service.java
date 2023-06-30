package Project_MyFamilyTree_MVP;

public class Service {
    private Saveable saveable;
    private final String filesave = "C:\\Users\\sc23\\Documents\\\u0423\u0447\u0435\u0431\u0430 \u0420\u0430\u0437\u0440\u0430\u0431\u043E\u0442\u0447\u0438\u043A\\\u041F\u0440\u0430\u043A\u0442\u0438\u043A\u0443\u043C\\\u041E\u041E\u041F\\Project_FamilyTree\\FamilyTree.txt";
    private FamilyTree<Human> humans;
    
    public FamilyTreeService(FamilyTree<Human> humans) {
        this.humans = humans;
    }

    public FamilyTreeService(){
        humans = new FamilyTree<>();
    }

    public boolean saveMethod(){
        if (saveable == null){
            return false;
        }
        return saveable.saveMethod(humans, filesave);
    }

    public boolean load(){
        if (saveable == null){
            return false;
        }
        humans = (FamilyTree<Human>) saveable.readMethod(filesave);
        if (humans == null){
            humans = new FamilyTree<>();
        }
        return true;
    }

    public String addHumanInService(String name, LocalDate birthday, Gender gender){
        Human human = new Human(name, birthday, gender);
        humans.add(human);
        return "Человек успешно добавлен в дерево";
    }

    private Human findHuman(String name) {
        if (name != null){
            return activeTree.getByName(name);
        }
        return null;
    }

    public void setSaveable(Saveable saveable) {
        this.saveable = saveable;
    }

    public void sortByName(){
        humans.sortByName();
    }

    public void sortByAge(){
        humans.sortByAge();
    }

    public String getHumanList() {
        return humans.getHuman();
    }
}
    
































//System.out.printl (humans.findHuman ("Иванов Сергей Максимович"));   //Использование метода поиска человека в древе

//System.out.println (humans.getHuman (Иванов Сергей Максимович));     //Получение информации о человеке в древе

//humans.sortByName();  //Использование метода сортировки людей по имени
//humans.sortByAge();   //Использование метода сортиовки людей по возрасту















 //FamilyTree humans = (FamilyTree) saveable.readMethod(filesave);


        //View view = new Console();    //Использование консоли
        //view.buttonStart();

        //saveable.saveMethod(humans, filesave);


//"C:\Users\sc23\Documents\Учеба Разработчик\Практикум\ООП\Project_MyFamilyTree_MVP\FamilyTree.txt"
