package Models.FamilyTree;

import Models.Relation.Relation;
import Models.Relation.RelationType;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class FamilyTree<E extends Comparable<E>> implements Serializable, Iterable<Node<E>> {
    private String treeName;
    private final LinkedList<Node<E>> nodes = new LinkedList<>();


    public FamilyTree(String name) {
        treeName = name;
    }


    //region RelationsManagement

        public void marry(Node<E> firstObject, Node<E> secondObject) {
            firstObject.getRelations().add(new Relation<>(secondObject.getMainObject(), RelationType.Spouse));
            secondObject.getRelations().add(new Relation<>(firstObject.getMainObject(), RelationType.Spouse));
        }

        public void divorce(Node<E> firstObject, Node<E> secondObject) {
            firstObject.getRelations().remove(new Relation<>(secondObject.getMainObject(), RelationType.Spouse));
            secondObject.getRelations().remove(new Relation<>(firstObject.getMainObject(), RelationType.Spouse));
        }

        @SafeVarargs
        public final void addParent(Node<E> child, Node<E>... parents) {
            for (Node<E> parent : parents) {
                child.getRelations().add(new Relation<>(parent.getMainObject(), RelationType.Parent));
                parent.getRelations().add(new Relation<>(child.getMainObject(), RelationType.Child));
            }
        }

        @SafeVarargs
        public final void removeParent(Node<E> child, Node<E>... parents) {
            for (Node<E> parent : parents) {
                child.getRelations().remove(new Relation<>(parent.getMainObject(), RelationType.Parent));
                parent.getRelations().remove(new Relation<>(child.getMainObject(), RelationType.Child));
            }
        }

        @SafeVarargs
        public final void addChild(Node<E> parent, Node<E>... children) {
            for (Node<E> child : children) {
                parent.getRelations().add(new Relation<>(child.getMainObject(), RelationType.Child));
                child.getRelations().add(new Relation<>(parent.getMainObject(), RelationType.Parent));
            }
        }

        @SafeVarargs
        public final void removeChild(Node<E> parent, Node<E>... children) {
            for (Node<E> child : children) {
                parent.getRelations().remove(new Relation<>(child.getMainObject(), RelationType.Child));
                child.getRelations().remove(new Relation<>(parent.getMainObject(), RelationType.Parent));
            }
        }

        @SafeVarargs
        public final void addSibling(Node<E> object, Node<E>... siblings) {
            for (Node<E> sibling : siblings) {
                object.getRelations().add(new Relation<>(sibling.getMainObject(), RelationType.Sibling));
                sibling.getRelations().add(new Relation<>(object.getMainObject(), RelationType.Sibling));
            }
        }

        @SafeVarargs
        public final void removeSibling(Node<E> object, Node<E>... siblings) {
        for (Node<E> sibling : siblings) {
            object.getRelations().remove(new Relation<>(sibling.getMainObject(), RelationType.Sibling));
            sibling.getRelations().remove(new Relation<>(object.getMainObject(), RelationType.Sibling));
        }
    }

    //endregion

    //region NodesManagement

        public void addNode(Node<E> node) {
            // Ищем людей, с которыми у node есть relations
            for (Node<E> relativeNode : nodes.stream()
                    .filter(x -> node.getRelations().stream()
                    .anyMatch(eRelation -> eRelation.getObject().equals(x.getMainObject())))
                    .collect(Collectors.toList())) {

                // Для каждого relation из node которая относится к relativeNode, добавляем обратную relation в relativeNode
                for (Relation<E> relation : node.getRelations().stream()
                        .filter(eRelation -> eRelation.getObject().equals(relativeNode.getMainObject()))
                        .collect(Collectors.toList())) {
                    relativeNode.getRelations().add(new Relation<>(node.getMainObject(), relation.getObjectType().getOppositeType()));
                }
            }
            nodes.add(node);
        }

        public void removeNode(Node<E> node) {
            // Удаляем все relation у других объектов к этому объекту
            for (Node<E> n : nodes) {
                n.getRelations().removeIf(eRelation -> eRelation.getObject().equals(node.getMainObject()));
            }
            nodes.remove(node);
        }

        public void sort(Comparator<? super Node<E>> c) {
            nodes.sort(c);
        }

    //endregion

    //region Getters

    public String getTreeName() {
        return treeName;
    }

    public LinkedList<Node<E>> getNodes() {
        return nodes;
    }

    //endregion

    //region Setters

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    //endregion

    //region DefaultOverride

    @Override
    public Iterator<Node<E>> iterator() {
        return new Iterator<Node<E>>() {
            private final Iterator<Node<E>> nodesIterator = nodes.iterator();

            @Override
            public boolean hasNext() {
                return nodesIterator.hasNext();
            }

            @Override
            public Node<E> next() {
                return nodesIterator.next();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("FamilyTree: %s", treeName));

        for (Node<E> node : nodes) {
            stringBuilder.append("\n\n");
            stringBuilder.append(node);
        }

        return stringBuilder.toString();
    }

    //endregion
}
