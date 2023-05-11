package OOP_Prodject;

import java.util.Random;

public class Elf extends Character {

    public Elf(String name) {
        super(name, "", 120, 0, 1, 6, 120, 40, 5, 5, 4);

    }

    @Override
    public void speak() {
        Random r = new Random();
        int phrase_number = r.nextInt(0, 5);

        switch (phrase_number) {
            case 0:
                System.out.println(String.format("Ой, нечаянно в гнома наступил, говорят к деньгам"));
                break;
            case 1:
                System.out.println(String.format("Во мне течет эльфийская кровь"));
                break;
            case 2:
                System.out.println(String
                        .format("Как говорил мой дед: 'Я твой пра-пра-дед, твой дед вон там в песочнице сидит!!!'"));
                break;
            case 3:
                System.out.println(String.format("*Смотрит с высока, как на г...нома*"));
                break;
            case 4:
                System.out.println(String.format("*Величаво молчит*"));
                break;
        }

    }

}
