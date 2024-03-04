package Controller;

import Data.Model.Diary;
import Data.Model.Entry;
import Data.dto.request.UserRegistrationRequest;
import Services.MyDiaryServiceImplementation;
import Services.MyDiaryServices;


public class DiaryController {
    MyDiaryServices diaryServiceImplementation = new MyDiaryServiceImplementation();

    public String registerUser(UserRegistrationRequest registrationRequest) {
        try {
            diaryServiceImplementation.register(registrationRequest);
            return "Registered Successfully";
        }
        catch (Exception error){
            return error.getMessage();
        }
    }
    public String lock(String username){
        diaryServiceImplementation.lock(username);
        return "Locked Successfully";
    }

    public String unlock(String username,String password){
        try {
            diaryServiceImplementation.unlock(username,password);
            return "Unlocked Successfully";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public String createEntry(String username,String title,String body) {
        try {
            diaryServiceImplementation.addEntry(username, title, body);
            return "Entry created successfully";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
    public String findEntry(String username,String title,String body){
        try {
            Entry entry = diaryServiceImplementation.findEntry(username, title);
            return entry.toString();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
    public void deleteEntry(String username, String title){
        Entry entry = diaryServiceImplementation.findEntry(username, title);
        if (entry.getOwnerName().equals(username) && entry.getTitle().equals(title)){
            Diary diary = diaryServiceImplementation.findByUsername(username);
            diaryServiceImplementation.delete(title);
        }
    }
}
