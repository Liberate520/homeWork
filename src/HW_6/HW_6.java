package HW_6;

import java.util.*;

public class HW_6 {
    public static List<String> parameter(){
        return Arrays.asList("Brand1");
    }


    public static List<NoteBook> filter(List<NoteBook> initialList){
        List<NoteBook> filteredList = new ArrayList<>();
        List<String> filter = parameter();

        for (NoteBook noteBook: initialList) {
            for (String param: filter){
                if (noteBook.getBrand().equals(param)){
                    filteredList.add(noteBook);
                }
            }
        }
        return filteredList;
    }
    public static void main(String[] args) {
        List<NoteBook> list = new ArrayList<NoteBook>();
        NoteBook noteBook1 = new NoteBook("Brand1", true, "SpaceGray");
        NoteBook noteBook2 = new NoteBook("Brand2", false, "Gray");
        NoteBook noteBook3 = new NoteBook("Brand3", true, "Pink");
        NoteBook noteBook4 = new NoteBook("Brand4", true, "Black");
        NoteBook noteBook5 = new NoteBook("Brand2", false, "Black");
        NoteBook noteBook6 = new NoteBook("Brand1", true, "White");
        NoteBook noteBook7 = new NoteBook("Brand3", true, "Green");
        list.add(noteBook1);
        list.add(noteBook2);
        list.add(noteBook3);
        list.add(noteBook4);
        list.add(noteBook5);
        list.add(noteBook6);
        list.add(noteBook7);
        Map<String, Integer> filter = new HashMap<>();

        Scanner in = new Scanner(System.in);

        String r = "P";
        while (!r.equals("N")) {
            System.out.println("Введите фазвание фильтра и его значение через пробел: ");
            String input = in.nextLine();
            String[] keyValue = input.split(" ");
            filter.put(keyValue[0], Integer.parseInt(keyValue[1]));
            System.out.println("Добавить еще фильтр?(Y/N): ");
            r = in.nextLine();
        }
        in.close();
        System.out.println(filter);


    }


}
