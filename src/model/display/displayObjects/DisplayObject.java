package java_oop_homeWork.src.model.display.displayObjects;

import java_oop_homeWork.src.model.display.DisplayInfo;
import java_oop_homeWork.src.model.display.displayFields.Field;

import java.util.ArrayList;

public abstract class DisplayObject {

    private DisplayInfo displayInfo;
    protected ArrayList<Field> fields;

    public DisplayObject(DisplayInfo displayInfo){
        this.displayInfo = displayInfo;
        fields = new ArrayList<Field>();
    }

    public String prepareForPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(displayInfo.getHeader());
        for (Field item:fields) {
            String title = item.getTitle();
            sb.append(title);
            if (title != "") sb.append(displayInfo.getRelationSign());
            sb.append(item.getDisplay());
            sb.append(displayInfo.getDelimiter());
        }
        sb.append(displayInfo.getFooter());
        return sb.toString();
    }


}
