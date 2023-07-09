package family_tree.model.infrastucture.try_catch;

public class TryLong {

    public long try_long (String string){
        long lng;
        try {
           lng = Long.parseLong(string);
            } catch (Exception e) {
                lng = -1;
            }
        return lng;
    }
}
