package model;
import view.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class FileHandlerSave implements SaveAs
{
        public static void Writer(FamilyTree familyTree) throws IOException, ClassNotFoundException
        {
            FileOutputStream fos = new FileOutputStream("text.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(familyTree);
            fos.close();
        }
    
        public static void SaveTxt(FamilyTree familyTree) throws IOException, ClassNotFoundException
        {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.txt");
            File file = new File(pathFile);
            FileWriter writer = new FileWriter(file.getAbsolutePath(), false);
            writer.write("\nTxt Format\n");
            writer.write(familyTree.toString()); 
            writer.flush(); 
        }   

        public static void SaveDoc(FamilyTree familyTree) throws IOException, ClassNotFoundException
        {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.doc");
            File file = new File(pathFile);
            FileWriter writer = new FileWriter(file.getAbsolutePath(), false);
            writer.write("<? Doc Format>\n");
            writer.write(familyTree.toString()); 
            writer.flush();    
        }     
        
        public static void SaveMD(FamilyTree familyTree) throws IOException, ClassNotFoundException
        {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("/file.md");
        File file = new File(pathFile);
        FileWriter writer = new FileWriter(file.getAbsolutePath(), false);
        writer.write("##<MD Format>\n");
        writer.write(familyTree.toString()); 
        writer.flush(); 
        }  


        @Override
        public int SaveFormat(FamilyTree familyTree) throws ClassNotFoundException, IOException 
        {
            int number = Console.Start1(familyTree);
            
            switch (number)
                {

                case 1:
                    Writer(familyTree);
                    System.out.println("Поздравляю!\n" + "Бинарный файл txt.bin был успешно создан!\n");
                    SaveFormat(familyTree);

                case 2:
                    SaveTxt(familyTree);
                    System.out.println("Поздравляю!\n" + "Файл формата .txt был успешно создан!\n");
                    SaveFormat(familyTree);

                case 3:
                    SaveDoc(familyTree);
                    System.out.println("Поздравляю!\n" + "Файл формата .doc был успешно создан!\n");
                    SaveFormat(familyTree);

                case 4:
                    SaveMD(familyTree);
                    System.out.println("Поздравляю!\n" + "Файл формата .md был успешно создан!\n");
                    SaveFormat(familyTree);

                case 5:
                    FileHandlerRead fhr = new FileHandlerRead();
                    return fhr.SaveFormat(familyTree); 

                case 6:
                    System.out.println("Вы вышли из программы.");
                    Console.exit();
                    break;
          
                default: break;
          } 
        return 0;
        }
}

