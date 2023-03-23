package Notebook.UI;
import java.util.Scanner;
import Notebook.Core.MVP.Views.ViewRecord;

public class ConsoleRecord implements ViewRecord {
    private Scanner iScanner;

    public ConsoleRecord() {
        iScanner = new Scanner(System.in);
    }

    @Override
    public String getRecording() { 
        System.out.println("Input text:");   
        return iScanner.nextLine();
    }

    @Override
    public String getTitle() {  
        System.out.println("Input Author:");      
        return iScanner.nextLine();
    }

    @Override
    public void setRecording(String value) {
        System.out.println(value);
        
    }

    @Override
    public void setTitle(String value) {
        System.out.println(value);
        
    }
    
}
