
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Family family = new Family("Цезарь", 'м');
        family.addChild("Цезарь", "сын цезаря", 'м');
        family.addChild("Цезарь", "дочь цезаря", 'ж');
        family.addChild("сын цезаря", "сын1 сына цезаря", 'м');
        family.addChild("сын цезаря", "дочь сына цезаря", 'ж');
        family.addChild("сын цезаря", "сын2 сына цезаря", 'м');
        family.addChild("дочь цезаря", "сын1 дочери цезаря", 'м');
        family.addChild("дочь цезаря", "дочь дочери цезаря", 'ж');
        family.addChild("дочь цезаря", "сын2 дочери цезаря", 'м');
        family.addChild("сын1 дочери цезаря", "правнук цезаря", 'м');
        family.addChild("сын1 сына цезаря", "правнука цезаря", 'м');
        System.out.println("Приветствует мастер генеологического дерева");
        Controller<Family> con = new Controller<>(family);
        con.funct(family);
    }
}     
