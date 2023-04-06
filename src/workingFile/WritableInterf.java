package workingFile;

import human.Human;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface WritableInterf {

    void writeObj(Human human) ;


    void readObj(Human human);
}
