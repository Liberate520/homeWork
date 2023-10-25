package zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public static void main(String[] args) {
        Cat cat = new Cat("Vaska");
        Dog dog = new Dog("Boobik");
        Radio radio = new Radio();

        List<Speakble> speakbles = new ArrayList<>();
        speakbles.add(cat);
        speakbles.add(dog);
        speakbles.add(radio);

        speakAll(speakbles);
    }

    static void speakAll(List<Speakble> speakables) {
        for (Speakble speakble: speakables) {
            if (speakble instanceof Cat) {
                Cat cat = (Cat) speakble;
                System.out.print(cat.getName() + " speaks: ");
            }
            speakble.speak();
        }
    }
}
