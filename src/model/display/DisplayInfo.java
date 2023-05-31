package java_oop_homeWork.src.model.display;

import java.util.ArrayList;

public class DisplayInfo {
    private String header;
    private String relationSign;
    private String delimiter;
    private String footer;

    public DisplayInfo(String header, String relationSign, String delimiter, String footer){
        this.header = header;
        this.relationSign = relationSign;
        this.delimiter = delimiter;
        this.footer = footer;
    }

    public DisplayInfo(){
        this("\n", "", "", "");
    }

    public String getHeader() {
        return header;
    }

    public String getRelationSign(){
        return relationSign;
    }

    public String getDelimiter(){
        return delimiter;
    }

    public String getFooter(){
        return footer;
    }
}
