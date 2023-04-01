import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlerSave implements SaveAs
{
    
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



        public static int Start1(FamilyTree familyTree)
        {
            tablo1.tabloSave();
            int number = ScanNumber.ScanOperationNumber();
            while(number < 1 || number > 5)
              {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                tablo1.tabloSave();
                number = ScanNumber.ScanOperationNumber();
              }  
        return number;
        }

        @Override
        public int SaveFormat(FamilyTree familyTree) throws ClassNotFoundException, IOException 
        {
            int number = Start1(familyTree);
        switch (number)
          {
          case 1:
          SaveTxt(familyTree);
          System.out.println("Поздравляю!\n" + "Файл формата .txt был успешно создан!\n");
        //   Start1(familyTree);
          SaveFormat(familyTree);

          return 1;

          case 2:
          SaveDoc(familyTree);
          System.out.println("Поздравляю!\n" + "Файл формата .doc был успешно создан!\n");
        //   Start1(familyTree);
          SaveFormat(familyTree);
         
          return 1;

          case 3:
          SaveMD(familyTree);
          System.out.println("Поздравляю!\n" + "Файл формата .md был успешно создан!\n");
        //   Start1(familyTree);
          SaveFormat(familyTree);
          
          return 1;

          case 4:
          FileHandlerRead fhr = new FileHandlerRead();
          return fhr.SaveFormat(familyTree); // !!!!!!!!!!!!!!!!!!

          case 5:
          System.out.println("Вы вышли из программы.");
          break;
          
          default:
           break;
          }  
         return 1;
        }
    }

