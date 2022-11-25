package Tree;


interface Human {

    enum link {
        parent, child, brother, sister, husband, 
        wife, father, mother, dother, son
    }

    String getName();
}