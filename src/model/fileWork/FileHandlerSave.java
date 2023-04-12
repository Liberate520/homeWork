package model.fileWork;
import view.Console;
import view.Starts.Start1;
import view.Starts.interfaceStart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import model.*;
import model.fileWork.Format.SaveDoc.InterfaceSave;
import model.fileWork.Format.SaveDoc.SaveBinFormat;
import model.fileWork.Format.SaveDoc.SaveDocFormat;
import model.fileWork.Format.SaveDoc.SaveMdFormat;
import model.fileWork.Format.SaveDoc.SaveTextFormat;


public class  FileHandlerSave<T> implements SaveAs<T>
{
        
        @Override
        public int SaveFormat(T t) throws ClassNotFoundException, IOException 
        {
            interfaceStart interfaceStart = new Start1();
            int number = interfaceStart.start();
            
            switch (number)
                {

                case 1:
                    InterfaceSave interfaceSave1 = new SaveBinFormat();
                    interfaceSave1.write(t);
                    System.out.println("Поздравляю!\n" + "Бинарный файл txt.bin был успешно создан!\n");
                    SaveFormat(t);

                case 2:
                    InterfaceSave interfaceSave2 = new SaveTextFormat();
                    interfaceSave2.write(t);
                    System.out.println("Поздравляю!\n" + "Файл формата .txt был успешно создан!\n");
                    SaveFormat(t);

                case 3:
                    InterfaceSave interfaceSave3 = new SaveDocFormat();
                    interfaceSave3.write(t);
                    System.out.println("Поздравляю!\n" + "Файл формата .doc был успешно создан!\n");
                    SaveFormat(t);

                case 4:
                    InterfaceSave interfaceSave4 = new SaveMdFormat();
                    interfaceSave4.write(t);
                    System.out.println("Поздравляю!\n" + "Файл формата .md был успешно создан!\n");
                    SaveFormat(t);

                case 5:
                    FileHandlerRead fhr = new FileHandlerRead();
                    return fhr.SaveFormat(t); 

                case 6:
                    System.out.println("Вы вышли из программы.");
                    Console.exit();
                    break;
          
                default: break;
                }
               
        return 0;
        }
}

