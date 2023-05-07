package view.toChoose;

public class ToChooseFormat implements ToChooseInterface{

    public int toChoose(){
        ToReadAnswer answer=new ToReadAnswer();
        System.out.println("Выберите формат загрузочного файла:\n"+

            "1 - Бинарный_файл.dat\n"+ 

            "2 - Текстовый_файл.txt\n");

            return answer.readAnswer();
    }
}