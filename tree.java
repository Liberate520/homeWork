package JAVA_OOP.seminar1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class tree {
    public static void my_write(ArrayList<Human> humans) throws IOException {
        FileWriter f_w = new FileWriter("humans.txt");
        for (Human item: humans) {
            f_w.append(item.getId()+"\n");
            f_w.append(item.getFirst_name()+"\n");
            f_w.append(item.getLast_name()+"\n");
            f_w.append(item.getbirth_year()+"\n");
            if (item.getMan()) f_w.append("1\n");
            else f_w.append("0\n");
            f_w.append(item.getId_father()+"\n");
            f_w.append(item.getId_mother()+"\n");}
        f_w.close();}

public static void my_read(ArrayList<Human> humans) throws IOException {
    ArrayList<String> log_list = new ArrayList<>();
    BufferedReader f_r = new BufferedReader(new FileReader("humans.txt"));
    String line;
    while ((line=f_r.readLine())!=null) log_list.add(line); f_r.close();

    for (int i = 0; i < log_list.size(); i++) {
        Human human = new Human(0, null, null, 0, false, 0, 0);
        human.setId(Integer.parseInt(log_list.get(i))); 
        human.setFirst_name(log_list.get(++i));;
        human.setLast_name(log_list.get(++i));
        human.setBirth_year(Integer.parseInt(log_list.get(++i)));
        if (log_list.get(++i).equals("1")) human.setMan(true);
        else human.setMan(false);
        human.setId_father(Integer.parseInt(log_list.get(++i)));
        human.setId_mother(Integer.parseInt(log_list.get(++i)));
        humans.add(human);}}

public static Human getHuman_id(int id, ArrayList<Human> humans) {
    Human human = new Human(id, null, null, id, false, id, id);
    for (Human item : humans) {if (item.getId()==id) human = item;}
    return human;}
    
    public static void main(String[] args) throws IOException {
        ArrayList<Human> humans = new ArrayList<>();
        Scanner scan = new Scanner(System.in); 
        int n1 = 1;
        int n2 = 1;       
        my_read(humans);
        for (Human item : humans) {item.find_parents(humans);}
        for (Human item : humans) {item.find_childrens(humans);}
        for (Human item : humans) {item.toString_1();}
        while (n1!=0||n2!=0){
            System.out.println();
            for (Human item : humans) {System.out.println(item.toString());}

            System.out.print("\nВведите ID исследуемого человека (0-exit): ");
            n1 = scan.nextInt();
            if (n1==0) break;
            System.out.print("Введите ID для установления степени родства (0-exit): ");
            n2 = scan.nextInt();
            if (n2==0) break;
            System.out.println("\n"+getHuman_id(n1, humans).toString());
            System.out.println(getHuman_id(n1, humans).getFamilyType(getHuman_id(n2, humans))+" для");
            System.out.println(getHuman_id(n2, humans).toString());}
            
        scan.close();

        // my_write(humans);


        


    }
    
}
