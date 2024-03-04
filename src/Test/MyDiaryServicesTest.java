import Data.dto.request.UserRegistrationRequest;
import Services.MyDiaryServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MyDiaryServicesTest {

    UserRegistrationRequest registrationRequest;

    @BeforeEach
    void startEachTestWith(){
        registrationRequest = new UserRegistrationRequest();
        registrationRequest.setPassword("password");
        registrationRequest.setUsername("username");
    }

    @Test
    public void testWeCanRegister() {
        MyDiaryServiceImplementation myDiaryServiceImplementation = new MyDiaryServiceImplementation();
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(1, myDiaryServiceImplementation.count());
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(2, myDiaryServiceImplementation.count());

    }
    @Test
    public void testWeCannotRepeatUsername(){
        MyDiaryServiceImplementation myDiaryServiceImplementation = new MyDiaryServiceImplementation();
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(1, myDiaryServiceImplementation.count());
        assertThrows(IllegalArgumentException.class,()-> myDiaryServiceImplementation.register
                (registrationRequest));
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(2,myDiaryServiceImplementation.count());
    }

    @Test
    public void testForCount(){
        MyDiaryServiceImplementation myDiaryServiceImplementation = new MyDiaryServiceImplementation();
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(1, myDiaryServiceImplementation.count());
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(2, myDiaryServiceImplementation.count());
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(3, myDiaryServiceImplementation.count());
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(4, myDiaryServiceImplementation.count());

    }
    @Test
    public void testWeCanDeleteDiary(){
        MyDiaryServiceImplementation myDiaryServiceImplementation = new MyDiaryServiceImplementation();
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(1, myDiaryServiceImplementation.count());
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(2, myDiaryServiceImplementation.count());
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(3, myDiaryServiceImplementation.count());
        myDiaryServiceImplementation.register(registrationRequest);
        assertEquals(4, myDiaryServiceImplementation.count());
        myDiaryServiceImplementation.delete("username");
        assertEquals(3,myDiaryServiceImplementation.count());


    }








    }

