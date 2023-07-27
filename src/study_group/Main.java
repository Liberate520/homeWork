package study_group;

import study_group.service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        service.addStudent("Паша", 18);
        service.addStudent("Маша", 20);
        service.addStudent("Саша", 17);
        service.addStudent("Даша", 19);

        System.out.println(service.getStudentInfo());
        service.sortByName();
        System.out.println(service.getStudentInfo());
        service.sortByAge();
        System.out.println(service.getStudentInfo());



    }
}
