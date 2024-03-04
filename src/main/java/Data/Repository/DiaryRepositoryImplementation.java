package Data.Repository;

import Data.Model.Diary;

import java.util.ArrayList;

import java.util.List;

public class DiaryRepositoryImplementation implements DiaryRepository {
    List<Diary> myDiaries = new ArrayList<>();

    @Override
    public Diary save(Diary diary) {
        if(diaryDoesNotExist(diary))
            saveNewDiary(diary);
        return savedDiary(diary);

    }

    private Diary savedDiary(Diary diary) {
        return diary;
    }

    private void saveNewDiary(Diary diary) {
        diary.setId(generateId());
        myDiaries.add(diary);
    }

    private boolean diaryDoesNotExist(Diary diary) {
        boolean diaryExistsInDb = myDiaries.contains(diary);
        boolean diaryHasAnId = diary.getId() == 0;
        return !(diaryExistsInDb || diaryHasAnId);
    }

    @Override
    public void delete(Diary diary) {
        Diary dairy = findDiaryById(diary.getId());
        myDiaries.remove(dairy);
    }
   @Override
    public long count() {
        return myDiaries.size();
    }

    @Override
    public Diary findDiaryById(int id) {
        return null;
    }


    @Override
    public Diary findDiaryByUsername(String username) {
        for (Diary diary : myDiaries) {
            if (diary.getUserName().equalsIgnoreCase(username));
            return diary;
        }
        return null;
    }
    @Override
    public void deleteAll() {
        myDiaries.clear();
    }

    @Override
    public List<Diary> findAll(String username) {
        return myDiaries;
    }

    @Override
    public int generateId(){
        return myDiaries.size() + 1;
    }


}




