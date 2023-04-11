//package treePackage;

public class Service {

    public HumanInterface humanForSort;

    public Service(HumanInterface humanForSort) {
        this.humanForSort = humanForSort;
    }

    public void sortByName() {

        humanForSort.getHumanList().sort(new HumanComparatorByName());

    }

    public void sortByFamily() {

        humanForSort.getHumanList().sort(new HumanComaratorByFamily());

    }

    

}

// public void sortById(){
// group.getStudentList().sort(new StudentComparatorById());
// }
