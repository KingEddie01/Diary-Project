import Services.EntryServices;
import Services.EntryServicesImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntryServicesImplTest {

    private EntryServices entryServices;

    @BeforeEach
    public void setUp(){
        entryServices = new EntryServicesImplementation();
    }
    @Test
    public void testThatEntryCanBeAdded(){
        entryServices.addEntry("ownerName","title","body");
        assertEquals(1, entryServices.count());
    }
    @Test
    public void testThatEntryCanBeDeletedByTitle(){
        entryServices.addEntry("ownerName","title","body");
        entryServices.addEntry("Eddie","Striving","Kinging");
        assertEquals(2, entryServices.count());
        entryServices.delete("ownerName","title");
        assertEquals(1,entryServices.count());

    }
    @Test
    public void testThatEntriesCanBeCounted(){
        entryServices.addEntry("Moyin","Great God","God loves me");
        entryServices.addEntry("Sophea","Beautiful","LOve lives here");
        assertEquals(2,entryServices.count());
    }
    @Test
    public void testThatFindEntryCanThrowExceptionIfEntryIsNotFound(){
        entryServices.addEntry("ownerName","title","body");
        entryServices.addEntry("Eddie","Striving","Kinging");
        assertEquals(2, entryServices.count());
        assertThrows(IllegalArgumentException.class,()-> entryServices.findEntry("Moyin","life"));
    }
    @Test
    public void testThatFindEntryCanThrowExceptionIfEntryWeWantToDeleteIsNotFound(){
        entryServices.addEntry("ownerName","title","body");
        entryServices.addEntry("Eddie","Striving","Kinging");
        assertEquals(2, entryServices.count());
        assertThrows(IllegalArgumentException.class,()-> entryServices.findEntry("Joel","zaza"));

    }

}
