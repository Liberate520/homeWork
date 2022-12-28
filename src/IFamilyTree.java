
import java.util.List;

public interface IFamilyTree<T extends LiveBeing> {
    List<T> getLiveBeings();

    void addLiveBeing(T liveBeing, T father, T mother);
}
