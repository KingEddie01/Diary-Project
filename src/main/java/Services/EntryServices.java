package Services;

import Data.Model.Entry;

public interface EntryServices {
    Entry addEntry(String ownerName, String title, String body);


    long count();


    void delete(String ownerName, String title);

    Entry findEntry(String ownerName,String title);
}
