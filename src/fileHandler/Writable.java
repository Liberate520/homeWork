package fileHandler;

import obj.Gender;
import obj.human.Human;

import java.io.*;
import java.time.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public interface Writable<E> {
    boolean save(Serializable tree,String path);
    Object read(String path);

//    static void saveFamilyTreeToFile(FamilyTree tree) {
//        String filePath = "tree2.txt";
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            List<Human> list = tree.getList();
//            for (Human human : list) {
//                writer.write(human.getFstName() + ";" + human.getLstName() + ";" + human.getBornDate() +
//                        ";" + human.getBornDate() + ";" + human.getGender() + ";" + human.getMother() +
//                        ";" + human.getFather());
//                writer.newLine();
//            }
//            System.out.println("Successfully upload " + filePath);
//        } catch (IOException e) {
//            System.err.println("Failed " + e.getMessage());
//        }
//    }
//
//
//    static FamilyTree readFamilyTreeFromFile() {
//        String filePath = "tree2.txt";
//        FamilyTree tree = new FamilyTree();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split(";");
//                Human human = new Human(data[0], data[1], getData(data[2]), getData(data[3]),
//                        getGender(data[4]),getHuman(data[5]), getHuman(data[6]));
//                tree.add(human);
//            }
//            System.out.println("Successfully download " + filePath);
//        } catch (IOException e) {
//            System.err.println("Failed " + e.getMessage());
//        }
//        return tree;
//    }

//    static LocalDate getData(String data){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return LocalDate.parse(data, formatter);
////        String[] datas = data.split("-");
////        int[] das = {Integer.parseInt(datas[0]),Integer.parseInt(datas[1]),Integer.parseInt(datas[2])};
////        LocalDate dt = LocalDate.of(das[0], das[1], das[2]);
////        return dt;
//        //ДР: 1950-04-10 ДС: 2012-06-20
//    }

    private static LocalDate getData(String dateString) {
        String[] dates = dateString.split("-");
        return LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
    }

    private static boolean dateTrue(String dateString){
        if(dateString != null && dateString != "" && dateString != "\n"){
            return true;
        }
        return false;
    }

    private static boolean isHuman(String human){
        if(human != null && human !=""){
            return true;
        }
        return false;
    }


    static Gender getGender(String data){
        if(data.equals("MALE")){
            return Gender.MALE;
        } else if (data.equals("FEMALE")){
            return Gender.FEMALE;
        }
        return null;
    }

    static Human getHuman(String data){
        if(data.equals("null")){
            return null;
        }
        String fstName = getValue(data, "Фамилия: ([A-Za-z]+)");
        String lstName = getValue(data, "Имя: ([A-Za-z]+)");
        Gender gender = getGender(getValue(data, "Пол: ([A-Za-z]+)"));
        LocalDate bornDate;
        LocalDate deathDate;
        Human mother;
        Human father;
//        System.out.println(getValue(data, "ДР: (\\d{4}-\\d{2}-\\d{2})"));
//        System.out.println(getValue(data, "ДС: (\\d{4}-\\d{2}-\\d{2})"));
        if(dateTrue(getValue(data, "ДР: (\\d{4}-\\d{2}-\\d{2})"))){
            bornDate = getData(getValue(data, "ДР: (\\d{4}-\\d{2}-\\d{2})"));
        } else{bornDate = null;}

        if(dateTrue(getValue(data, "ДС: (\\d{4}-\\d{2}-\\d{2})"))){
            deathDate = getData(getValue(data, "ДР: (\\d{4}-\\d{2}-\\d{2})"));
        } else{deathDate = null;}

        String m = getValue(data, "Мама: ([А-Яа-яA-Za-z]+)");
        if(isHuman(m)){
            mother = getHuman(m);
        } else{mother = null;}

        String f = getValue(data, "Папа: ([А-Яа-яA-Za-z]+)");
        if(isHuman(f)){
            father = getHuman(f);
        } else{father = null;}

        return new Human(fstName,lstName,bornDate,deathDate,gender,mother,father);

    }

    private static String getValue(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}


