import java.util.List;

public interface IFamilyTree<T extends LiveBeing<T>> {
    List<T> getLiveBeings();

    public void setLiveBeings(List<T> liveBeings);

    void addLiveBeing(T liveBeing, T father, T mother);
}
