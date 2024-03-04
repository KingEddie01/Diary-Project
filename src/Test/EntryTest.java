import Data.Model.Entry;
import Data.Repository.EntryRepositoryImplementation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntryTest {
    EntryRepositoryImplementation entryRepositoryImpl = new EntryRepositoryImplementation();

    @Test
    public void testForEntryObject() {
        assertNotNull(entryRepositoryImpl);
    }

    @Test
    public void testWeCanSaveEntry() {
        Entry entry = new Entry();
        entryRepositoryImpl.save(entry);
        assertEquals(1, entryRepositoryImpl.count());
    }

    @Test
    public void testWeCanDeleteEntry() {
        Entry entry = new Entry();
        entryRepositoryImpl.save(entry);
        assertEquals(1, entryRepositoryImpl.count());
        Entry entry1 = new Entry();
        entryRepositoryImpl.save(entry1);
        assertEquals(2, entryRepositoryImpl.count());
        entryRepositoryImpl.delete(entry);
        assertNull(entryRepositoryImpl.findEntryById(1));
    }

    @Test
    public void testOurEntryHasId() {
        Entry entry = new Entry();
        entryRepositoryImpl.save(entry);
        assertEquals(1, entry.getId());
    }

    @Test
    public void testWeCanFindEntryById() {
        Entry entry = new Entry();
        entryRepositoryImpl.save(entry);
        assertEquals(entry, entryRepositoryImpl.findEntryById(1));
        Entry entry1 = new Entry();
        entryRepositoryImpl.save(entry1);
        assertEquals(entry1, entryRepositoryImpl.findEntryById(2));
    }

    @Test
    public void testWeCanDeleteAllSavedEntries() {
        Entry entry = new Entry();
        entryRepositoryImpl.save(entry);
        assertEquals(1, entryRepositoryImpl.count());
        Entry entry1 = new Entry();
        entryRepositoryImpl.save(entry1);
        assertEquals(2, entryRepositoryImpl.count());
        Entry entry2 = new Entry();
        entryRepositoryImpl.save(entry2);
        assertEquals(3,entryRepositoryImpl.count());
        entryRepositoryImpl.deleteAll();
        assertEquals(0,entryRepositoryImpl.count());

    }
}
