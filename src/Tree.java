public class Tree {
    Human human;

    public Tree(Human human)
    {
        this.human = human;
    }

    public void getChildren()
    {
        for(Human h : human.children)
            System.out.println(h.name + " " + h.surname);
    }

    public Human nextHuman(int i)
    {
        if(i >= human.children.size())
            throw new IndexOutOfBoundsException("no child at index (indexoutofbound) " + i);
        
        human = human.children.get(i);

        return human;
    }
}
