package com.britenight.Model.FamilyTree;

import com.britenight.Model.Person.Person;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FamilyTree<E extends Comparable<Object>> implements Serializable, Iterable<FamilyTreeNode<E>> {
    private final ArrayList<E> objArray;
    private final ArrayList<Relation<E>> relations;

    public FamilyTree() {
        relations = new ArrayList<>();
        objArray = new ArrayList<>();
    }

    //region Relations
    public void addRelation(Relation<E> relation) {
        relations.add(relation);
        if (relation.getRelationObjectType() == RelationType.Parent) {
            Relation<E> tmpRelation = new Relation<>(relation.getRelationObject(), relation.getMainObject(), RelationType.Child);
            relations.add(tmpRelation);
        }
        else if (relation.getRelationObjectType() == RelationType.Child) {
            Relation<E> tmpRelation = new Relation<>(relation.getRelationObject(), relation.getMainObject(), RelationType.Parent);
            relations.add(tmpRelation);
        }
    }

    public void removeRelation(Relation<E> relation) {
        if (relation.getRelationObjectType() == RelationType.Parent) {
            Relation<E> tmpRelation = new Relation<>(relation.getRelationObject(), relation.getMainObject(), RelationType.Child);
            relations.remove(tmpRelation);
        }
        else if (relation.getRelationObjectType() == RelationType.Child) {
            Relation<E> tmpRelation = new Relation<>(relation.getRelationObject(), relation.getMainObject(), RelationType.Parent);
            relations.remove(tmpRelation);
        }
        relations.remove(relation);
    }

    public List<Relation<E>> getRelations() {
        return relations;
    }

    public List<Relation<E>> getRelations(E object, boolean isMainObject) {
        return relations.stream().filter(relation ->
                isMainObject && relation.getMainObject().equals(object)
                        || !isMainObject && relation.getRelationObject().equals(object)).collect(Collectors.toList());
    }

    public List<Relation<E>> getRelations(E object, boolean isMainObject, RelationType searchFor) {
        return relations.stream().filter(relation ->
                (isMainObject && relation.getMainObject().equals(object) || !isMainObject && relation.getRelationObject().equals(object))
                        && relation.getRelationObjectType() == searchFor).collect(Collectors.toList());
    }
    //endregion

    //region Objects
    public void addObject(E object) {
        objArray.add(object);
    }

    public void removeObject(E object) {
        var tmp = relations.stream().filter(relation -> relation.getRelationObject() == object
                || relation.getMainObject() == object).collect(Collectors.toList());
        for (Relation<E> i : tmp) {
            relations.remove(i);
        }
        objArray.remove(object);
    }

    public List<E> getObjects() {
        return objArray;
    }
    //endregion

    //region FamilyTreeNodes
    private List<E> getRelativeObjects(List<Relation<E>> relations, boolean isMainObject) {
        List<E> list = new ArrayList<>();

        for (Relation<E> i : relations) {
            if (isMainObject)
                list.add(i.getRelationObject());
            else
                list.add(i.getMainObject());
        }

        return list;
    }

    public ArrayList<FamilyTreeNode<E>> getNodes() {
        ArrayList<FamilyTreeNode<E>> list = new ArrayList<>();

        for (E p : objArray) {
            List<Relation<E>> relations = getRelations(p, true);
            list.add(new FamilyTreeNode<E>(p, relations));
        }

        return list;
    }
    //endregion

    //region Overrides
    @Override
    public Iterator<FamilyTreeNode<E>> iterator() {
        return new Iterator<>() {
            final Iterator<FamilyTreeNode<E>> nodesIterator = getNodes().iterator();
            @Override
            public boolean hasNext() {
                return nodesIterator.hasNext();
            }

            @Override
            public FamilyTreeNode<E> next() {
                return nodesIterator.next();
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        getNodes().forEach(action);
    }

    @Override
    public Spliterator<FamilyTreeNode<E>> spliterator() {
        return getNodes().spliterator();
    }
    //endregion
}
