package Data.Repository;

import Data.Model.Diary;
import Data.Model.Entry;

public interface EntryRepository {
    Entry save(Entry entry);

    void delete(Entry entry);

    long count();

    Entry findEntryById(int id);

    void deleteAll();

    Entry findEntry(String ownerName, String title);
}
