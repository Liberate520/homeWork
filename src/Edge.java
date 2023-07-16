public class Edge {
    Node node;
    int ageCreatedChildren;
    Human children;

    Edge(Node node, int ageCreatedChildren, Human children){
        this.node = node;
        this.ageCreatedChildren = ageCreatedChildren;
        this.children = children;
    }
    Edge(Node node){
        this.node = node;
        this.ageCreatedChildren = 0;
        this.children = null;
    }
}
