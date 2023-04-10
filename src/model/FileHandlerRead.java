package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import view.Console;

public class FileHandlerRead<T> implements SaveAs<T>
{
    
    public static <T> void Reader() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream("text.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        T t1 = (T) ois.readObject();
        ois.close();
        System.out.println("вывод 1: " + t1);
    }    

    public static <T> String ReadTxt() throws IOException, ClassNotFoundException
    {
        
        FileReader fr = new FileReader("file.txt");
        BufferedReader buff = new BufferedReader(fr);
        String str;
        System.out.println("\nВывод из файла формата .txt\n ");
        StringBuilder sb = new StringBuilder();
            while((str = buff.readLine()) != null)
            {
                sb.append(str);
                System.out.println(str);
            }
        buff.close();
        System.out.println("Данные восстановлены! ");
        return sb.toString();
    }

    public static<T> String ReadMD() throws IOException, ClassNotFoundException
    {
        
        FileReader fr = new FileReader("file.md");
        BufferedReader buff = new BufferedReader(fr);
        String str;
        System.out.println("\nВывод из файла формата .md\n ");
        StringBuilder sb = new StringBuilder();
            while((str = buff.readLine()) != null)
            {
                sb.append(str);
                System.out.println(str);
            }
        buff.close();
        System.out.println("Данные восстановлены! ");
        return sb.toString();
    }

    public static <T> String ReadDoc() throws IOException, ClassNotFoundException
    {
    
        FileReader fr = new FileReader("file.doc");
        BufferedReader buff = new BufferedReader(fr);
        String str;
        System.out.println("\nВывод из файла формата .doc\n ");
        StringBuilder sb = new StringBuilder();
            while((str = buff.readLine()) != null)
            {
                sb.append(str);
                System.out.println(str);
            }
        buff.close();
        System.out.println("Данные восстановлены! ");
        return sb.toString();
    }


    @Override
    public int SaveFormat(T t) throws ClassNotFoundException, IOException 
    {
        
        int number = Console.Start2(t);

            switch (number)
            {
                case 1:
                  int number2 = Console.Start3(t);
                    switch (number2)
                    {
                        case 1:
                            Reader();
                            System.out.println("Загрузка данных в программу из бинарного файла успешно завершена!\n");
                            FileHandlerSave fhs1 = new FileHandlerSave();
                            return fhs1.SaveFormat(t);
                        case 2:
                            ReadTxt();
                            System.out.println(" file.txt формата был успешно считан: \n");
                            FileHandlerSave fhs2 = new FileHandlerSave();
                            return fhs2.SaveFormat(t);
                        case 3:
                            ReadDoc();
                            System.out.println(" file.doc формата был успешно считан: \n");
                            FileHandlerSave fhs3 = new FileHandlerSave();
                            return fhs3.SaveFormat(t);

                        case 4:
                            ReadMD();
                            System.out.println(" file.md формата был успешно считан: \n");
                            FileHandlerSave fhs4 = new FileHandlerSave();
                            return fhs4.SaveFormat(t);

                        case 5:
                            System.out.println("Вы вышли из программы.");
                            Console.exit();
                            break;
          
                        default: break;
                    }  
                
                
                case 2:
                    FileHandlerSave fhs5 = new FileHandlerSave();
                    return fhs5.SaveFormat(t);

                case 3: 
                    System.out.println("Вы вышли из программы!");
                    Console.exit();
                    break;

                default : break;    
            } 
           
            return 1;   
    }    
}

