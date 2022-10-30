package HW_6;

import java.util.*;

public class HW_6 {

    public static void filterList(HashMap<String, Integer> filter, List<NoteBook> initialList){
        for (Map.Entry<String,Integer> entry: filter.entrySet()){
            for (int i = (initialList.size()-1); i>=0; i--){
                switch (entry.getKey()){
                    case ("RAM"):
                        if ((initialList.get(i).getRam() < entry.getValue())){
                            initialList.remove(initialList.get(i));
                        }
                    case ("HDD"):
                        if ((initialList.get(i).getHdd() < entry.getValue())){
                            initialList.remove(initialList.get(i));
                        }
                    case ("Resolution"):
                        if ((initialList.get(i).getRes() < entry.getValue())){
                            initialList.remove(initialList.get(i));
                        }
                }
            }
        }
    }
    public static void main(String[] args) {
        List<NoteBook> list = new ArrayList<>();
        NoteBook noteBook1 = new NoteBook(16,1080,480);
        NoteBook noteBook2 = new NoteBook(32,720,480);
        NoteBook noteBook3 = new NoteBook(16,2000,480);
        NoteBook noteBook4 = new NoteBook(8,4000,1000);
        NoteBook noteBook5 = new NoteBook(8,1080,500);
        NoteBook noteBook6 = new NoteBook(8,2000,240);
        NoteBook noteBook7 = new NoteBook(16,720,1000);
        list.add(noteBook1);
        list.add(noteBook2);
        list.add(noteBook3);
        list.add(noteBook4);
        list.add(noteBook5);
        list.add(noteBook6);
        list.add(noteBook7);
        System.out.println("Изначальный список: " + list);
        HashMap<String, Integer> filter = new HashMap<>();

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

        filterList(filter, list);

        System.out.println(list);



    }


}
