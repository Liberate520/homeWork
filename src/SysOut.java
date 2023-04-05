import java.util.Scanner;


//НЕЗАВЕРШЕН (ПОДГОТОВКА)!!!

public class SysOut {

    public static void SysOut(){
        Scanner scn = new Scanner(System.in,"ibm866");

        System.out.println("Здравствуйте! Выберите интересующий вас пункт ");
        System.out.println("1. Показать семейное древо ");
        System.out.println("2. Показать дату рождения человека ");
        System.out.println("3. Показать Родителей человека ");
        System.out.println("4. Показать детей человека ");
        System.out.println("5. Показать жив человек или нет ");
        System.out.println("6. показать дату смерти человека ");
        System.out.println("7. Добавить нового человека семьи ");
        System.out.println("8. Сохранить семейное древо ");

        int answer = scn.nextInt();
        
        while(answer < 1 || answer > 8){
            System.out.println("Выберете интересующий вас пункт: ");
            System.out.println("1. Показать семейное древо ");
            System.out.println("2. Показать дату рождения человека ");
            System.out.println("3. Показать Родителей человека ");
            System.out.println("4. Показать детей человека ");
            System.out.println("5. Показать жив человек или нет ");
            System.out.println("6. показать дату смерти человека ");
            System.out.println("7. Добавить нового человека семьи ");
            System.out.println("8. Сохранить семейное древо ");

            answer = scn.nextInt();
        }
        if (answer == 1){
            // Здесь должен быть вывод дерева!!! 
        }
        if (answer == 2){
            System.out.println("Выберете человека для просмотра даты рождения: ");
            System.out.println("1. " + Main.person1);
            System.out.println("2. " + Main.person2);
            System.out.println("3. " + Main.person3);
            System.out.println("4. " + Main.person4);
            answer = scn.nextInt();

            while(answer < 1 || answer > 4){

                System.out.println("Выберете человека для просмотра даты рождения: ");
                System.out.println("1. " + Main.person1);
                System.out.println("2. " + Main.person2);
                System.out.println("3. " + Main.person3);
                System.out.println("4. " + Main.person4);
                answer = scn.nextInt();
            }
            if(answer == 1){        
                Main.person1.getDateOfBirth();
            }
            if(answer == 2){        
                Main.person2.getDateOfBirth();
            }
            if(answer == 3){        
                Main.person3.getDateOfBirth();
            }
            if(answer == 4){        
                Main.person4.getDateOfBirth();
            }           

        }
        if (answer == 3){
            System.out.println("Выберете человека для просмотра его родителей: ");
            System.out.println("1. " + Main.person1);
            System.out.println("2. " + Main.person2);
            System.out.println("3. " + Main.person3);
            System.out.println("4. " + Main.person4);
            answer = scn.nextInt();

            while(answer < 1 || answer > 4){

                System.out.println("Выберете человека для просмотра его родителей: ");
                System.out.println("1. " + Main.person1);
                System.out.println("2. " + Main.person2);
                System.out.println("3. " + Main.person3);
                System.out.println("4. " + Main.person4);
                answer = scn.nextInt();
            }
            if(answer == 1){        
                System.out.println("Отец: "); Main.person1.getFather(); 
                System.out.println("Мать: "); Main.person1.getMother();
            }
            if(answer == 2){        
                System.out.println("Отец: "); Main.person2.getFather(); 
                System.out.println("Мать: "); Main.person2.getMother();
            }
            if(answer == 3){        
                System.out.println("Отец: "); Main.person3.getFather(); 
                System.out.println("Мать: "); Main.person3.getMother();
            }
            if(answer == 4){        
                System.out.println("Отец: "); Main.person4.getFather(); 
                System.out.println("Мать: "); Main.person4.getMother();
            }           


        }
        if (answer == 4){

            System.out.println("Выберете человека для просмотра его детей: ");
            System.out.println("1. " + Main.person1);
            System.out.println("2. " + Main.person2);
            System.out.println("3. " + Main.person3);
            System.out.println("4. " + Main.person4);
            answer = scn.nextInt();
    
            if(answer == 1){        
                System.out.println("Дети: "); Main.person1.getChildrens();
            }
            if(answer == 2){        
                System.out.println("Дети: "); Main.person2.getChildrens();
            }
            if(answer == 3){        
                System.out.println("Дети: "); Main.person3.getChildrens();
            }
            if(answer == 4){        
                System.out.println("Дети: "); Main.person4.getChildrens();
            }           

        }
        if (answer == 5){
            System.out.println("Выберете человека для просмотра жив или нет: ");
            System.out.println("1. " + Main.person1);
            System.out.println("2. " + Main.person2);
            System.out.println("3. " + Main.person3);
            System.out.println("4. " + Main.person4);
            answer = scn.nextInt();
    
            if(answer == 1){        
                Main.person1.getAlive();
            }
            if(answer == 2){        
                Main.person2.getAlive();
            }
            if(answer == 3){        
                Main.person3.getAlive();;
            }
            if(answer == 4){        
                Main.person4.getAlive();;
            }           
            
        }
        if (answer == 6){
            System.out.println("Выберете человека для просмотра даты смерти: ");
            System.out.println("1. " + Main.person1);
            System.out.println("2. " + Main.person2);
            System.out.println("3. " + Main.person3);
            System.out.println("4. " + Main.person4);
            answer = scn.nextInt();

            while(answer < 1 || answer > 4){

                System.out.println("Выберете человека для просмотра даты смерти: ");
                System.out.println("1. " + Main.person1);
                System.out.println("2. " + Main.person2);
                System.out.println("3. " + Main.person3);
                System.out.println("4. " + Main.person4);
                answer = scn.nextInt();
            }
            if(answer == 1){        
                Main.person1.getDateOfDeath();
            }
            if(answer == 2){        
                Main.person2.getDateOfDeath();
            }
            if(answer == 3){        
                Main.person3.getDateOfDeath();
            }
            if(answer == 4){        
                Main.person4.getDateOfDeath();
            }   
            
        }
        if (answer == 7){
            Person new_person = new Person(null, null, null);
            System.out.println("Введите имя: ");
            new_person.setFirstName(scn.next());
            System.out.println("Введите фамилию: ");
            new_person.setSecondName(scn.next());
            System.out.println("Введите дату рождения: ");
            new_person.setDateOfBirth(scn.next());
            System.out.println("Выберите жив или нет: ");
            System.out.println("1. Жив ");
            System.out.println("2. Мертв ");
            answer = scn.nextInt(); 
            while(answer < 1 || answer > 2){
                System.out.println("Выберите жив или нет: ");
                System.out.println("1. Жив ");
                System.out.println("2. Мертв "); 
                answer = scn.nextInt(); 
            }
            if (answer == 1){
                new_person.setAlive(true);
            }
            if(answer == 2){
                new_person.setAlive(false);
            }
            // Здесь должно быть занесение нового человека в дерево!!! 
        }
        if (answer == 8){
            // Здесь должно быть занесение дерева в файл!!! 
        }

    scn.close();
    }
    
    
    
    
}
