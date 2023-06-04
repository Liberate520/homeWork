package Zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Radio radio = new Radio();

        List<Speakble> speakbles = new ArrayList<>();
        speakbles.add(cat);
        speakbles.add(dog);
        speakbles.add(radio);
        speakAll(speakbles);
    }

    static void speakAll(List<Speakble> speakbleList) {
        for (Speakble speakble: speakbleList) {
            speakble.speak();
        }
    }
}
