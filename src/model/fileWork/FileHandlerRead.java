package model.fileWork;

import java.io.IOException;
import model.fileWork.Format.ReadDoc.ReadBin;
import model.fileWork.Format.ReadDoc.ReadDoc;
import model.fileWork.Format.ReadDoc.ReadMd;
import model.fileWork.Format.ReadDoc.ReadTxt;
import model.fileWork.Format.ReadDoc.interfaceRead;
import view.Starts.Start2;
import view.Starts.Start3;
import view.Starts.interfaceStart;

public class FileHandlerRead<T> implements SaveAs<T>
{
    boolean flag = true;
    

    @Override
    public int SaveFormat(T t) throws ClassNotFoundException, IOException 
    {
        while(flag)
        {
            interfaceStart interfaceStart = new Start2();
            int number = interfaceStart.start();
        
            switch (number)
            {
                case 1:
                    interfaceStart interfaceStart1 = new Start3();
                    int number2 = interfaceStart1.start();
            
                    switch (number2)
                    {
                        case 1:
                            interfaceRead interfaceRead1 = new ReadBin();
                            interfaceRead1.read(t);
                            System.out.println("Загрузка данных в программу из бинарного файла успешно завершена!\n");
                            FileHandlerSave fhs1 = new FileHandlerSave();
                            return fhs1.SaveFormat(t);
                        case 2:
                            interfaceRead interfaceRead2 = new ReadTxt();
                            interfaceRead2.read(t);
                            System.out.println(" file.txt формата был успешно считан: \n");
                            FileHandlerSave fhs2 = new FileHandlerSave();
                            return fhs2.SaveFormat(t);
                        case 3:
                            interfaceRead interfaceRead3 = new ReadDoc();
                            interfaceRead3.read(t);
                            System.out.println(" file.doc формата был успешно считан: \n");
                            FileHandlerSave fhs3 = new FileHandlerSave();
                            return fhs3.SaveFormat(t);

                        case 4:
                            interfaceRead interfaceRead4 = new ReadMd();
                            interfaceRead4.read(t);
                            System.out.println(" file.md формата был успешно считан: \n");
                            FileHandlerSave fhs4 = new FileHandlerSave();
                            return fhs4.SaveFormat(t);

                        case 5:
                            System.out.println("Вы вышли из программы.");
                            flag = false;
                            break;
          
                        default: break;
                    }  
                
                case 2:
                    FileHandlerSave fhs5 = new FileHandlerSave();
                    return fhs5.SaveFormat(t);

                case 3: 
                    System.out.println("Вы вышли из программы!");
                    flag = false;
                    break;
                    

                default : break;    
            } 
        }   
            return 1;   
    }    
}

