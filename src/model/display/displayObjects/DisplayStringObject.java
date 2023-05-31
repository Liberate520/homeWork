package java_oop_homeWork.src.model.display.displayObjects;

import java_oop_homeWork.src.model.display.DisplayInfo;
import java_oop_homeWork.src.model.display.displayFields.StringField;

public class DisplayStringObject extends DisplayObject {
    public DisplayStringObject(DisplayInfo displayInfo, String string) {
        super(displayInfo);
        fields.add(new StringField("", string));
    }
}
