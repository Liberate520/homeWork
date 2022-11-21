
//    @Liberate520
// мой тг
public class Main {
    public static void main(String[] args) {
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
        family.printFamily();
    }
} 
