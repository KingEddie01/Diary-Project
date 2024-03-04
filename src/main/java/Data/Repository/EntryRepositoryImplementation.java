package Data.Repository;

import Data.Model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImplementation implements EntryRepository {
    List<Entry> entries = new ArrayList<>();

    @Override

    public Entry save(Entry entry) {
        if (entry.getId() == 0) {
            entry.setId(generateId());
            entries.add(entry);
        } else {
            entries.set(entry.getId(), entry);
        }
        return null;
    }

    @Override
    public void delete(Entry entry) {
        entries.remove(entry);


    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public Entry findEntryById(int id) {
        for (Entry entryObj : entries) {
            if (id == entryObj.getId())
                return entryObj;
        }
        return null;
    }

    @Override
    public void deleteAll() {
        entries.clear();
    }

    @Override
    public Entry findEntry(String ownerName, String title) {
        for (Entry entry : entries)
            if (entry.getOwnerName().equalsIgnoreCase(ownerName) && entry.getTitle().equals(title))
                return entry;

        throw new IllegalArgumentException("ENTRY NOT FOUND");
    }
    public int generateId(){
        return entries.size() + 1;
    }
}
