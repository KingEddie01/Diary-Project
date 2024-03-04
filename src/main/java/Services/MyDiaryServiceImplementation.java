package Services;

import Data.Model.Diary;
import Data.Model.Entry;
import Data.Repository.DiaryRepository;
import Data.Repository.DiaryRepositoryImplementation;
import Data.dto.request.UserRegistrationRequest;

public class MyDiaryServiceImplementation implements MyDiaryServices {

    private final DiaryRepository myRepository = new DiaryRepositoryImplementation();

    private final EntryServices myEntryServices = new EntryServicesImplementation();


    @Override
    public void register(UserRegistrationRequest registrationRequest) {
        if (validateUsername(registrationRequest.getUsername())) {
            Diary diary = new Diary();
            diary.setPassword(registrationRequest.getPassword());
            diary.setUserName(registrationRequest.getUsername());
            myRepository.save(diary);
        } else {
            throw new IllegalArgumentException("Username already taken");
        }
    }


    private boolean validateUsername(String username) {
        for (Diary myDiary : myRepository.findAll(username)) {
            if (myDiary.getUserName().equals(username)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }



    @Override
    public Diary findByUsername(String username) {
        for (Diary diary : myRepository.findAll(username)) {
            if (diary.getUserName().equals(username))
                return diary;
        }
        throw new IllegalArgumentException("Could not find "+username);
    }
    @Override
    public long count() {
        return myRepository.count();
    }
    @Override
    public void delete(String username) {
        Diary diary = findByUsername(username);
        myRepository.delete(diary);
        }

    @Override
    public void lock(String username) {
        Diary diary = findByUsername(username);
        diary.setIsLocked(true);
        myRepository.save(diary);
    }

    @Override
    public void unlock(String username, String password) {
        Diary diary = myRepository.findDiaryByUsername(username);
        if (diary == null)
            throw new IllegalArgumentException("Diary not found");
        if (diary.getPassword().equals(password))
            diary.setIsLocked(false);

        else
            throw new IllegalArgumentException("Incorrect password");
    }

    public Entry addEntry(String username, String title, String body){
        validateUsername(username);
        Entry entry = myEntryServices.addEntry(username, title, body);
        return entry;
    }
    public Entry findEntry(String username, String title){
        validateUsername(username);
        Entry entry = myEntryServices.findEntry(username, title);
        return entry;

    }



}








