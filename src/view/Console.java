package view;

import java.io.IOException;
import java.util.Scanner;

import model.human.Human;
import presenter.Presenter;

public class Console implements View {

   private Scanner scanner;
   private Presenter presenter;
   private boolean isWorking = true;

   public Console() {
      scanner = new Scanner(System.in);

   }

   private void printInvitationForUser() {
      System.out.println();
      String str = "Выберите операцию и ввделите соответсвующую цифру: \n" +
            "1 - для печати списка дерева с детьми \n" +
            "2 - для записи и сохранения в файл списка родственников \n" +
            "3 - для получения списка родственников \n" +
            "4 - для сортировки списка по выбранному параметру \n" +
            "5 - для ввода данных и добавления в список \n" +
            "6 - для поиска родственника по имени \n" +
            "0 - для завершения работы \n";
      System.out.println(str);
   }

   @Override
   public void start() throws IOException, ClassNotFoundException {
      printInvitationForUser();
      while (isWorking) {
         int operationNumber = scanner.nextInt();
         switch (operationNumber) {
            case 0:
               exit();
               break;
            case 1:
               presenter.printChildren();
               printInvitationForUser();
               break;
            case 2:
               presenter.writeTreeInFile();
               System.out.printf("Вы успешно сохранили список в файл \'%s.%s\' !\n", presenter.getFileName(),
                     presenter.getFileType());
               printInvitationForUser();
               break;
            case 3:
               System.out.printf("Генеалогическое древо, прочитанное из файла \"%s.%s\":\n", presenter.getFileName(),
                     presenter.getFileType());
               presenter.readFromFile();
               presenter.print();
               printInvitationForUser();
               break;
            case 4:
               System.out.println("Для сортировки по имени введите цифру 1:\n"
                     + "для сортировки по году рождения введите цифру 2: \n" + "ддя сортировки по id введите 3:");
               try {
                  int sortNumber = scanner.nextInt();
                  presenter.sortByParameter(sortNumber);
                  printInvitationForUser();
               } catch (Exception e) {
                  System.out.println("Ошибка ввода!" + e);
               }
               break;
            case 5:
               Human human = presenter.readNewHuman();
               presenter.addHuman(human);
               printInvitationForUser();
               break;
            case 6:
               presenter.getHumanByName();
               printInvitationForUser();
               break;
            default:
               System.out.println("Некорректный номер операции!");
               printInvitationForUser();
         }

      }
   }

   private void exit() {
      System.out.println("Работа завершена, приходите ещё!");
      scanner.close();
      isWorking = false;
   }

   @Override
   public void setPresenter(Presenter presenter) {
      this.presenter = presenter;
   }
}
