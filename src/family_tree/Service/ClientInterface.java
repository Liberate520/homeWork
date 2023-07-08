package family_tree.Service;

import java.util.Scanner;

public class ClientInterface {
    private Scanner sc;
    private int clientChoise;

    public ClientInterface(Scanner sc, int clientChoise) {
        this.sc = sc;
        this.clientChoise = clientChoise;
    }

    public ClientInterface(Scanner sc) {
        this(sc, 0);
    }

    public void work(int clientChoise){
        while(clientChoise != 10) {
            System.out.println("Работа с генеалогическим древом.");
            System.out.println("Что необходимо сделать:\n[1] - Добавить человека");
            System.out.println("[2] - Добавить дату смерти\n[3] - Добавить семью в дерево");
            System.out.println("[4] - Добавить ребенка\n[5] - Добавить родителей");
            System.out.println("[6] - Найти человека\n[7] - Показать все дерево");
            System.out.println("[8] - Сохранить дерево в файл\n[9] - Загрузить дерево из файла");
            System.out.println("[10] - Выход");
            clientChoise = sc.nextInt();
            switch (clientChoise) {
                case 1:
                    AddHuman();
                    break;
                case 2:
                    SetDeathDate();
                    break;
                case 3:
                    AddFamily();
                    break;
                case 4:
                    AddChild();
                    break;
                case 5:
                    AddParents();
                    break;
                case 6:
                    FindHuman();
                    break;
                case 7:
                    ShowAllTree();
                    break;
                case 8:
                    SaveTree();
                    break;
                case 9:
                    LoadTree();
                    break;
                case 10:
                    break;
                default:
                    System.out.println("\nНекорректный выбор!\n");
                    break;
            }
        }
    }

    private void LoadTree() {
    }

    private void SaveTree() {
    }

    private void ShowAllTree() {
    }

    private void FindHuman() {
    }

    private void AddParents() {
    }

    private void AddChild() {
    }

    private void AddFamily() {
    }

    private void SetDeathDate() {
    }

    private void AddHuman() {
    }
}
