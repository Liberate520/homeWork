import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class main {
    public static void main(String[] args) {
        List<Laptops> laptops = new ArrayList<>();
        Laptops l1 = new Laptops();
        Laptops l2 = new Laptops();
        Laptops l3 = new Laptops();
        Laptops l4 = new Laptops();
        Laptops l5 = new Laptops();
        l1.setId(123);
        l2.setId(223);
        l3.setId(323);
        l4.setId(423);
        l5.setId(523);
        l1.setPrice(1000);
        l2.setPrice(1200);
        l3.setPrice(1100);
        l4.setPrice(1400);
        l5.setPrice(1200);
        l1.setBrand("Acer");
        l2.setBrand("Apple");
        l3.setBrand("HP");
        l4.setBrand("Acer");
        l5.setBrand("Asus");
        laptops.add(l1);
        laptops.add(l2);
        laptops.add(l3);
        laptops.add(l4);
        laptops.add(l5);
        TreeMap<String, Integer> charact = new TreeMap<>();
        charact.put("id", 0);
        charact.put("price", 1);
        charact.put("brand", 2);
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Выберите параметр сортировки: %s\n", charact.keySet());
        String command = scanner.nextLine();
        if (charact.get(command) == 2) {
            System.out.println("Выберите бренд");
            String param = scanner.nextLine();
            System.out.println(filterCheck(laptops, 2, param));
        } else {
            System.out.println("Введите нижнюю границу");
            int down = scanner.nextInt();
            System.out.println("Введите верхнюю границу");
            int up = scanner.nextInt();
            System.out.println(filterBorder(laptops, charact.get(command), down, up));
        }
    }

    public static TreeMap<Integer, Integer> filterBorder(List<Laptops> laptopList, int num, int down, int up) {
        int criteria;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        if (num == 0) {
            for (Laptops laptops : laptopList) {
                criteria = laptops.getId();
                if (criteria >= down && criteria <= up) {
                    map.put(criteria, criteria);
                }
            }
        }

        if (num == 1) {
            for (Laptops laptops : laptopList) {
                criteria = laptops.getPrice();
                if (criteria >= down && criteria <= up) {
                    map.put(laptops.getId(), criteria);
                }
            }
        }
        return map;
    }

    public static TreeMap<Integer, String> filterCheck(List<Laptops> laptopList, int num, String param) {
        String parameter;
        TreeMap<Integer, String> map = new TreeMap<>();

        if (num == 2) {
            for (Laptops laptops : laptopList) {
                parameter = laptops.getBrand();
                if (parameter.equals(param)) {
                    map.put(laptops.getId(), parameter);
                }
            }
        }
        return map;
    }
}