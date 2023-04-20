package FamilyTree.model.servises;
import FamilyTree.model.Tree;
import FamilyTree.model.fileManagement.SaveLoad;
import FamilyTree.model.nodes.Gender;
import FamilyTree.model.nodes.Person;
import FamilyTree.presenter.Presenter;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;

public class PersonService implements Service{
    private Presenter presenter;
    private Tree<Person> tree;
    private String name;
    private String secondName;
    private String surname;
    private Gender gender;
    private int yearOfBirth;
    private int yearOfDeath;
    private Person father;
    private Person mother;
    private List<String> questions = Arrays.asList(
            "Введите имя: ", // 0
            "1 - Муж. 2 - Жен. Выберете пол: ", // 1
            "Введите год рожедения: ", // 2 
            "Добавляемый человек жив? 1 - да, 2 - нет. -> ",// 3
            "Введите год смерти: ", // 4
            "Есть данные о родителях? 1 - Да. 2 - нет. -> ",// 5
            "Введите фамилию матери: ",//6
            "Выберете номер записи: ",//7
            "Введите фамилию отца: ",//8
            "Выберете номер записи: ",//9
            "Введите фамилию: ",//10
            "Введите отчество: "//11
            );
    private int currentQuestion ;//текущий номер вопроса, нужен для соответствия ответу
    List<Person> potentialFathers;
    List<Person> potentialMothers;
    
    public PersonService(Tree<Person> tree){
        this.tree = tree;
    }
    public PersonService(){
        this(new Tree<>());
    }

    @Override
    public void save(SaveLoad sl, String path) throws ClassNotFoundException, IOException{
        savePersonTree(tree, sl, path);
    }
    private void savePersonTree(Tree<Person> tree ,SaveLoad sl, String path) throws ClassNotFoundException, IOException {
        sl.save(tree, path);
        print("Файл успешно сохранен");  
    }

    @Override
    public void load(SaveLoad sl, String path) throws ClassNotFoundException, IOException  {//
            File dir = new File(path);
            if(dir.exists()){
                tree = (Tree<Person>) sl.load(path);//с этим ничего не сделать?
                print("Файл успешно загружен"); 
            }else{
                print("Файл не найден"); 
            }
    }
    
    public String getQuestion(int i){//по номеру запроса отправляет в ответ текст вопроса   
        // сохранить куданибудь i, чтобы понимать текущий вопрос и соответственно текущий ответ. 
        setCurrentQuestion(i);
        // как можно пропустить вопрос при необходимости?
        return questions.get(i);
    }

    public int getQuestionCount(){//определение количества вопросов для внешнего цикла по вопросам
        return questions.size();
    }
    protected void setCurrentQuestion(int currentQuestion) {//используется только внутри класса
        this.currentQuestion = currentQuestion;//устанавливаем номер текущего вопроса по индеку обращения к списку вопросов
        //чтобы понимать на какой вопрос пришел ответ
    }


    private void getSurnameFromFather(Person father, Gender genderOfchild){//задает фамилию и отчество добавляему человеку по данным отца
        String temp = father.getShortInfo();//"фамилия;имя;отчество"
        String tempSurname = temp.substring(0, temp.indexOf(";"));
        if(genderOfchild == Gender.m){//если добавляемый человек мужского пола
            secondName = father.getName() + "ович";//отчество
            surname = tempSurname;//фамилия
        }else{//если добавляемый человек женского пола
            secondName = father.getName() + "овна";//отчество
            surname = tempSurname + "а";//фамилия
        }
    }


    public void getAnswer(String msg){ //принимает ответ пользователя от модуля view и в зависимости от номера текущ вопроса обрабатывает ответ
        switch(currentQuestion){
            case 0://ввод имени
                name = msg;
                break;
            case 1://выбор пола
                if(msg.equals("1")){
                    gender=Gender.m;
                }
                else{
                    gender=Gender.f;
                }
                break;
            case 2://год рождения
                yearOfBirth = Integer.parseInt(msg);//добавить потом try catch
                break;
            case 3://жив ли человек?
                if(msg.equals("1")){//если жив
                    yearOfDeath = 0;
                    // skipQuestion();//пропускаем следующий вопрос!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    setQuestionNumber(5);//пропускаем 4 вопрос и переходим к 5
                }
                break;//если нет, то переход к следующему впросу, где попросят ввести дату смерти
            case 4://если не жив
                yearOfDeath = Integer.parseInt(msg);//добавить потом try catch
                break;
            case 5://данные о родителях
                if(msg.equals("2")){//если данных о родителях нет
                    mother = null;
                    father = null;
                    setQuestionNumber(10);//пропускаем поиск матери и отца и переходим к вводу фамилии вручную
                    //запросить информацию о фамилии и отчестве
                }
                break;
            case 6://поиск матери
                potentialMothers = tree.findNodes(msg);//получение списка совпадений по поиску
                if(potentialMothers.size()==0){//елси ничего не нашлось
                    print("Мать не найдена");
                    mother = null;
                    setQuestionNumber(8);//пропускаем 9 (выбор матери из списка) и переходим к 8 (поиск отца)
                }
                else{//если нашлось 
                    print(tree.showNodeList(potentialMothers));//отправка во вью через презентер списка возможных отцов, переведенного в текст
                }
                break;
            case 7: //выбор матери из списка
            int mindex = Integer.parseInt(msg);//добавить потом try catch
            if(mindex >= 0 && mindex < potentialMothers.size()){//проверка, что индекс в пределах массива
                Person tempMother = potentialMothers.get(mindex);
                if(tempMother.getGender()==Gender.f){//если выбранный из списка человек - женщина, 
                    mother = tempMother;//выбрать мать
                }
                else{//если пол выбранного человека - женский
                    print("Выбран человек не того пола, повторите ввод");
                    setQuestionNumber(7);//повторить выбор матери
                }
            }
            else{//если введен неправильный номер, повторить ввод
                print("Введен неверный номер, повторите ввод.");
                setQuestionNumber(7);//повторить выбор матери
            }
                break;    
            case 8://поиск отца
                potentialFathers = tree.findNodes(msg);//получение списка совпадений по поиску
                if(potentialFathers.size()==0){//если ничего не найдено
                    print("Отец не найден");
                    father = null;
                    setQuestionNumber(10);//пропускаем 9 (выбор отца из списка) и переходим к 10 ввод вручную фамилии
                }
                else{//если найдено
                    print(tree.showNodeList(potentialFathers));//отправка во вью через презентер списка возможных отцов, переведенного в текст
                }
                break;
            case 9://выбор отца из списка
                int index = Integer.parseInt(msg);//добавить потом try catch
                if(index >= 0 && index < potentialFathers.size()){//проверка, что индекс в пределах массива
                    Person tempFather = potentialFathers.get(index);
                    if(tempFather.getGender()==Gender.m){//если выбранный из списка человек - мужчина, 
                        father = tempFather;//выбрать отца
                        getSurnameFromFather(father, gender);//На основе отца сформировать фамилию и отчество!
                    }
                    else{//если пол выбранного человека - женский
                        print("Выбран человек не того пола, повторите ввод");
                        setQuestionNumber(9);//повторить выбор отца
                    }
                }
                else{//если введен неправильный номер, повторить ввод
                    print("Введен неверный номер, повторите ввод.");
                    setQuestionNumber(9);//повторить выбор отца
                }
                break;
            case 10://ввод фамилии
                surname = msg; 
                break;
            case 11://ввод отчества
                secondName = msg;
                break;
        }   
    }


    @Override
    public void addNode() {
        Person person = new Person(name, secondName, surname, gender, yearOfBirth, yearOfDeath, father, mother);
        if (!tree.getNodeList().contains(person)){//если нет такой записи !!!!! почему то не отрабатывает, можно добавить дубль
            tree.addNode(person, father, mother);//добавляем person в дерево. person добавится в список детей к отцу и матери, если они не null
            print("Человек успешно добавлен в дерево");
        }else{
            print("Такой человек уже есть в семейном дереве");
        }
        
    }

    @Override
    public void searchNode(String text) {
        
    }


    private void setQuestionNumber(int number){//недоступен снаружи. изменяет счетчик номера вопроса в презентере
        presenter.setQuestionNumber(number);//чтобы пропускать один или несколько вопросов
        //устанавливаем номер счетчика в презентере, он обращается по номеру в Сервис к списку вопросов
        //этот номер автоматом становится текущим вопросом currentQuestion, дополнительно его не надо устанавливать
    }


    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    private void print(String text){
        presenter.print(text);
    }

    @Override
    public String getAllPersons() {
        return tree.toString();
    }
    
}    
