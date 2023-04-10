package model;
import view.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class  FileHandlerSave<T> implements SaveAs<T>
{
        public static <T> void Writer(T t) throws IOException, ClassNotFoundException
        {
            FileOutputStream fos = new FileOutputStream("text.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            fos.close();
        }
    
        public static <T> void SaveTxt(T t) throws IOException, ClassNotFoundException
        {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.txt");
            File file = new File(pathFile);
            FileWriter writer = new FileWriter(file.getAbsolutePath(), false);
            writer.write("\nTxt Format\n");
            writer.write(t.toString()); 
            writer.flush(); 
        }   

        public static <T> void SaveDoc(T t) throws IOException, ClassNotFoundException
        {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.doc");
            File file = new File(pathFile);
            FileWriter writer = new FileWriter(file.getAbsolutePath(), false);
            writer.write("<? Doc Format>\n");
            writer.write(t.toString()); 
            writer.flush();    
        }     
        
        public static <T> void SaveMD(T t) throws IOException, ClassNotFoundException
        {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("/file.md");
        File file = new File(pathFile);
        FileWriter writer = new FileWriter(file.getAbsolutePath(), false);
        writer.write("##<MD Format>\n");
        writer.write(t.toString()); 
        writer.flush(); 
        }  


        @Override
        public int SaveFormat(T t) throws ClassNotFoundException, IOException 
        {
            int number = Console.Start1();
            
            switch (number)
                {

                case 1:
                    Writer(t);
                    System.out.println("Поздравляю!\n" + "Бинарный файл txt.bin был успешно создан!\n");
                    SaveFormat(t);

                case 2:
                    SaveTxt(t);
                    System.out.println("Поздравляю!\n" + "Файл формата .txt был успешно создан!\n");
                    SaveFormat(t);

                case 3:
                    SaveDoc(t);
                    System.out.println("Поздравляю!\n" + "Файл формата .doc был успешно создан!\n");
                    SaveFormat(t);

                case 4:
                    SaveMD(t);
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

