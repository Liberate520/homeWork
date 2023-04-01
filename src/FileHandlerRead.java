import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandlerRead implements SaveAs
{

    public static void ReadTxt() throws IOException, ClassNotFoundException
    {
        
        FileReader fr = new FileReader("file.txt");
        BufferedReader buff = new BufferedReader(fr);
        String str;
        System.out.println("\nВывод из файла формата .txt\n ");
            while((str = buff.readLine()) != null)
            {
                System.out.println(str);
            }
        buff.close();
    }

    public static void ReadMD() throws IOException, ClassNotFoundException
    {
        
        FileReader fr = new FileReader("file.md");
        BufferedReader buff = new BufferedReader(fr);
        String str;
        System.out.println("\nВывод из файла формата .md\n ");
            while((str = buff.readLine()) != null)
            {
                System.out.println(str);
            }
        buff.close();
    }

    public static void ReadDoc() throws IOException, ClassNotFoundException
    {
    
        FileReader fr = new FileReader("file.doc");
        BufferedReader buff = new BufferedReader(fr);
        String str;
        System.out.println("\nВывод из файла формата .doc\n ");
            while((str = buff.readLine()) != null)
            {
                System.out.println(str);
            }
        buff.close();
    }


    public static int Start2(FamilyTree familyTree)
        {
            tablo11.tabloRead11();
            int number = ScanNumber.ScanOperationNumber();
            while(number < 1 || number > 3)
            {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                tablo11.tabloRead11();
                number = ScanNumber.ScanOperationNumber();
            }
          return number;
        }
        
        public static int Start3(FamilyTree familyTree)
        {
            tablo2.tabloRead2();
            int number = ScanNumber.ScanOperationNumber();
            while(number < 1 || number > 4)
            {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                tablo11.tabloRead11();
                number = ScanNumber.ScanOperationNumber();
            }
          return number;
        }



    @Override
    public int SaveFormat(FamilyTree familyTree) throws ClassNotFoundException, IOException 
    {
        int number = Start2(familyTree);

            switch (number)
            {
                case 1:
                   int number2 = Start3(familyTree);
                    switch (number2)
                    {
                        case 1:
                            ReadTxt();
                            System.out.println(" file.txt формата был успешно считан: \n");
                            // tablo11.tabloRead11();
                            FileHandlerSave fhs1 = new FileHandlerSave();
                            return fhs1.SaveFormat(familyTree);
                        case 2:
                            ReadDoc();
                            System.out.println(" file.doc формата был успешно считан: \n");
                            // tablo11.tabloRead11();
                            FileHandlerSave fhs2 = new FileHandlerSave();
                            return fhs2.SaveFormat(familyTree);

                        case 3:
                            ReadMD();
                            System.out.println(" file.md формата был успешно считан: \n");
                            // tablo11.tabloRead11();
                            FileHandlerSave fhs3 = new FileHandlerSave();
                            return fhs3.SaveFormat(familyTree);

                        case 4:
                            System.out.println("Вы вышли из программы.");
                            break;
          
                        default: break;
                    }  
                
                
                case 2:
                return SaveFormat(familyTree);

                case 3:
                break;
            }    
            return 1;   
    }    
}
