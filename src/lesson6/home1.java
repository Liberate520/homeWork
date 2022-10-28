package lesson6;
import java.util.*;


public class home1 {

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void filterList(Map<String, Integer> filter, List<NoteBook> initialList){
        List<NoteBook> list = new ArrayList<>();

        for (Map.Entry<String,Integer> entry: filter.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < initialList.size(); i++){
                switch (key){
                    case ("RAM"):
                        if ((initialList.get(i).getRam() > value)){   
                            list.add(initialList.get(i));  
                        }
                        break;
                    case ("HDD"):
                        if ((initialList.get(i).getHdd() > value)){
                            list.add(initialList.get(i)); 
                        }
                        break;
                    case ("RESOLUTION"):
                        if ((initialList.get(i).getRes() > value)){
                            list.add(initialList.get(i));
                        }
                        break;
                }
            }
        }
        clearScreen();
        if(!list.isEmpty()){
            System.out.println("Вот что мне удалось найти: ");
        } else {
            System.out.println("Ничего не найдено :(");
        }
        printList(list);
        list.clear();

    }
    static void printList(List<NoteBook> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
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

        clearScreen();
        System.out.println("Добро пожаловать в наш маленький консольный магазин ноутбуков! Вот что у нас есть:");
        printList(list);

        Map<String, Integer> filter;
        filter = new HashMap<String,Integer>();

        Scanner in = new Scanner(System.in);

        String r = "Y";
        while (!r.equals("N")) {
            System.out.println("Для работы с фильтром введите название фильтра (RAM, HDD, Resolution) и через пробел минимальное начение (например 'HDD 400') : ");
            String input = in.nextLine().toUpperCase();
            String[] keyValue = input.split(" ");
            filter.put(keyValue[0], Integer.parseInt(keyValue[1]));
            filterList(filter, list);
            System.out.println("Попробовать еще?(Y/N): ");
            r = in.nextLine().toUpperCase();
        }
        in.close();
    }
}
