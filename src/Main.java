import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static List<Person> listPerson = new ArrayList<>();
    private static List<Ancestry> listAncestry = new ArrayList<>();
    public static void main (String[] args) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        listPerson.add(new Person("Baiden", "male",sdf.parse("1947-09-20")));
        listPerson.add(new Person("BaidenFather", "male",sdf.parse("1917-09-20"),sdf.parse("2017-09-20")));
        listPerson.add(new Person("BaidenMather", "female",sdf.parse("1919-07-20"),sdf.parse("2015-09-20")));
        listPerson.add(new Person("BaidenChildren1", "male",sdf.parse("1990-09-20")));
        listPerson.add(new Person("BaidenChildren2", "female",sdf.parse("1991-09-20")));
        listPerson.add(new Person("BaidenChildren3", "male",sdf.parse("1992-09-20")));
        listPerson.add(new Person("BaidenChildren4", "male",sdf.parse("1993-09-20")));
        listPerson.add(new Person("BaidenGrandFazer", "male",sdf.parse("1894-09-20"),sdf.parse("1998-09-20")));
        listPerson.add(new Person("BaidenGrandMother", "female",sdf.parse("1896-09-20"),sdf.parse("1998-09-20")));
        Person.printListPerson(listPerson);
        addAncestry();
        if (listAncestry.size()!=0){
            System.out.println(listAncestry.get(0).ChildrentoSring());
        }
    }
    // добавление персоны в базу и описание родственных связей
    public static void addAncestry(){
        addAncestry(null);
    }
    public static void addAncestry(Person cur){
        Integer chois;
        Integer chois1;
        Integer markAncestry;
        Person addPerson;
        Scanner scan = new Scanner(System.in);
        if (cur==null){
            System.out.println("\nВыберете персону для добавления родословной или 0 для выхода:\n");
            Person.printListPerson(listPerson);
            chois=scan.nextInt()-1;
            if (chois<0) return;
            cur=listPerson.get(chois);
            System.out.println(cur);
        }
        while (true){
            System.out.println("------------");
            System.out.println("\nВыберете желаемое действие:\n1. Добавление отца\n2. Добавление матери\n3. Добавление детей\n0. Выход ");
            chois1=scan.nextInt();
            if (chois1==0) return;
            System.out.print("\nВыберете персону для ");
            switch (chois1) {
                case (1): {
                    System.out.println("добавления в поле отец");
                    break;
                }
                case (2): {
                    System.out.println("добавления в поле мать");
                    break;
                }
                case (3): {
                    System.out.println("добавления в поле дети");
                    break;
                }
            }
            Person.printListPerson(listPerson);
            chois=scan.nextInt()-1;
            if (chois<0) return;
            addPerson=listPerson.get(chois);
            markAncestry=searchListAncestry(listAncestry, cur);
            if (markAncestry<0){
                listAncestry.add(new Ancestry(cur));
                markAncestry=0;
            }
            switch (chois1) {
                case (1): {
                    listAncestry.get(markAncestry).setFather(addPerson);
                    break;
                }
                case (2): {
                    listAncestry.get(markAncestry).setMother(addPerson);
                    break;
                }
                case (3): {
                    listAncestry.get(markAncestry).addChildren(addPerson);
                    break;
                }
            }
            System.out.println(listAncestry);
        }
    }
    // //печать списка персон
    // public static void Person.(List<Person> listPerson){
    //     Integer count=0;
    //     while (count<listPerson.size()){
    //         System.out.println(++count+". "+listPerson.get(count-1));
    //         // count++;
    //     }
    // }

    // поиск нужной записи в базе
    public static int searchListAncestry(List<Ancestry> listAncestry, Person cur){
        Integer count=0;
        while (count<listAncestry.size()){
            if (listAncestry.get(count) != null){
                if(listAncestry.get(count).getCurPerson()==cur){
                    return count;
                }
            }
        }
        return -1;
    }
}
