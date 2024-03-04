package Services;

import Data.Model.Diary;
import Data.Model.Entry;
import Data.dto.request.UserRegistrationRequest;

public interface MyDiaryServices {
   void register(UserRegistrationRequest registrationRequest);
   Diary findByUsername(String username);
   long count();

   void delete(String username);

   void lock(String username);
   void unlock(String username, String password);
   public Entry addEntry(String username, String title, String body);

   public Entry findEntry(String username, String title);

}

