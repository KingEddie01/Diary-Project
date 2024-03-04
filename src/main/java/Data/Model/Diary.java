package Data.Model;

import java.util.ArrayList;
import java.util.List;

public class Diary{
    private String userName;
    private String password;
    private final List<Entry>entries = new ArrayList<Entry>();
    private Boolean isLocked;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;

    }


}




