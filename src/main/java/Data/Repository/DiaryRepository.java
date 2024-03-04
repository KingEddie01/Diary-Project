package Data.Repository;

import Data.Model.Diary;

import java.util.List;

public interface DiaryRepository {
    Diary save(Diary diary);

    void delete(Diary diary);

    long count();

    Diary findDiaryById(int id);

    Diary findDiaryByUsername(String username);

    void deleteAll();


   List< Diary> findAll(String username);

    int generateId();


}
