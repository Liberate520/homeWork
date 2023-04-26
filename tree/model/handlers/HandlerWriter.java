package model.handlers;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class HandlerWriter extends Handler implements Writer {

    public HandlerWriter() {
        super();
    }

    @Override
    public boolean saveToFile(Saveable object) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(super.getFilePathOut() + super.getFileNameOut()));
            out.writeObject(object);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;

    }

}
