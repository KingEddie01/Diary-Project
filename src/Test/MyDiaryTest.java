import Data.Model.Diary;
import Data.Repository.DiaryRepositoryImplementation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyDiaryTest {
    DiaryRepositoryImplementation repositoryImpl = new DiaryRepositoryImplementation();
    @Test
    public void testForDiaryExist() {

        assertNotNull(repositoryImpl);

    }
    @Test
    public void testWeCanSaveDiary() {
        Diary diary = new Diary();
        repositoryImpl.save(diary);
        assertEquals(1, repositoryImpl.count());
    }
    @Test
    public void testOurSavedDiaryHasAnId(){
        Diary diary = new Diary();
        repositoryImpl.save(diary);
        assertEquals(1,diary.getId());
    }
    @Test
    public void testWeCanSaveMultipleDiaryObject(){
        Diary diary = new Diary();
        repositoryImpl.save(diary);
        assertEquals(1, repositoryImpl.count());
        Diary diary1 = new Diary();
        repositoryImpl.save(diary1);
        assertEquals(2,repositoryImpl.count());
    }
    @Test
    public void testWeCanFindDiaryById(){
        Diary diary = new Diary();
        repositoryImpl.save(diary);
        Diary diary1 = new Diary();
        repositoryImpl.save(diary1);
        assertEquals(2,repositoryImpl.count());
        assertEquals(diary1, repositoryImpl.findDiaryById(2));

    }
    @Test
    public void testWeCanDeleteDiary(){
        Diary diary = new Diary();
        repositoryImpl.save(diary);
        assertEquals(diary, repositoryImpl.findDiaryById(1));
        Diary diary1 = new Diary();
        repositoryImpl.save(diary1);
        assertEquals(diary1, repositoryImpl.findDiaryById(2));
        assertEquals(2,repositoryImpl.count());
        repositoryImpl.delete(diary);
        assertNull(repositoryImpl.findDiaryById(1));

    }
    @Test
    public void testWeCanDeleteALLDiaryObject() {
        Diary diary = new Diary();
        repositoryImpl.save(diary);
        assertEquals(diary, repositoryImpl.findDiaryById(1));
        Diary diary1 = new Diary();
        repositoryImpl.save(diary1);
        assertEquals(diary1, repositoryImpl.findDiaryById(2));
        Diary diary2 = new Diary();
        repositoryImpl.save(diary2);
        assertEquals(diary1, repositoryImpl.findDiaryById(2));
        assertEquals(3, repositoryImpl.count());
        repositoryImpl.deleteAll();
        assertEquals(0, repositoryImpl.count());
    }


}
