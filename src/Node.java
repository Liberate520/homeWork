import java.util.List;

/**
 * @author Mikhail Latypov
 * class Node будет обозначать связь с нодами: с родителями, детьми и т.д.
 * Семейное древо будет содержать не список людей, а вот этих нод.
 */
public class Node {
    Human human;
    Node father, mother;
    List<Node> children;
}
