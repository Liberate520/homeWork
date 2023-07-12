package family_tree.infrastucture.try_catch;

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
