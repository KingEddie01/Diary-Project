package Services;

import Data.Model.Entry;
import Data.Repository.EntryRepository;
import Data.Repository.EntryRepositoryImplementation;

public class EntryServicesImplementation implements EntryServices {

    private final EntryRepository entryRepository = new EntryRepositoryImplementation();

    @Override
    public Entry addEntry(String ownerName, String title, String body) {
        Entry newEntry = new Entry();
        newEntry.setOwnerName(ownerName);
        newEntry.setTitle(title);
        newEntry.setBody(body);
        entryRepository.save(newEntry);
        return newEntry;

    }

    public long count(){
        return entryRepository.count();
    }


    @Override
    public void delete(String ownerName, String title) {
        Entry foundEntry = entryRepository.findEntry(ownerName, title);
        entryRepository.delete(foundEntry);


    }

    @Override
    public Entry findEntry(String ownerName, String title) {
        Entry entry = entryRepository.findEntry(ownerName,title);
        boolean entryIsNotFound = entry == null;
        if (entryIsNotFound){
            throw new IllegalArgumentException("Entry is not found");
        }
        return entry;

    }


}