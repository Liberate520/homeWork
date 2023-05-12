package OOP_Prodject;

import java.util.ArrayList;

public class Creator {
    public Character create(ArrayList<String> data) throws Exception {
        if (dataCheck(data)) {
            throw new LackOfDataException();
        } else if (data.size() > 8) {
            throw new ExcessOfDataException();

        } else {
            Character c = createCharacter(data.get(0), data.get(2));
            profModify(data.get(1), c);
            c.setHealthPoints(c.getHealthPoints() + Integer.parseInt(data.get(3)));
            c.setAttack(c.getAttack() + Integer.parseInt(data.get(4)));
            c.setSpeed(c.getSpeed() + Integer.parseInt(data.get(5)));
            c.setResist(c.getResist() + Integer.parseInt(data.get(6)));
            c.setMana(c.getMana() + Integer.parseInt(data.get(7)));

            return c;

        }

    }

    private Character createCharacter(String race, String name) {
        Character c = new Character(name);
        switch (race) {
            case "Elf":
                c = new Elf(name);
                break;
            case "Dwarf":
                c = new Dwarf(name);
                break;
            case "Human":
                c = new Human(name);
                break;
            case "Goblin":
                c = new Goblin(name);
                break;

        }
        return c;
    }

    private Boolean dataCheck(ArrayList<String> data) {
        Boolean flag = false;
        for (String d : data) {
            if (d.equals("")) {
                flag = true;
            }
        }

        return flag;
    }

    private void profModify(String prof, Character c) {
        switch (prof) {
            case "Warrior":
                Warrior warrior = new Warrior(prof);
                warrior.modify(c);
                break;
            case "Killer":
                Killer killer = new Killer(prof);
                killer.modify(c);
                break;
            case "Tank":
                Tank tank = new Tank(prof);
                tank.modify(c);
                break;
            case "Magician":
                Magician mag = new Magician(prof);
                mag.modify(c);
                break;
            case "Healer":
                Healer healer = new Healer(prof);
                healer.modify(c);
                break;
            case "Barbarian":
                Barbarian barbarian = new Barbarian(prof);
                barbarian.modify(c);
                break;
        }
    }
}
