package member;

import family.Family;

import java.io.Serializable;
import java.util.*;

public interface Member extends Serializable, Comparable<Member> {
    /**
     * Add to Family connection
     * @param family which family to connect
     */
    void addFamily(Family<? extends Member> family);

    /**
     * Add 'connection' to 'other member
     */
    void addConnection(Member member, Connection connection);

    String getName();

    void changeName(String newName);

    Set<? extends Member> getRelatedMembers(Connection connection);

    Set<Family<? extends Member>> getFamilies();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    String toString();

    @Override
    int compareTo(Member otherMember);
}
