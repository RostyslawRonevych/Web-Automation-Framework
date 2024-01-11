package org.example.Model;

import org.instancio.Instancio;
import java.util.List;
import java.util.stream.Stream;

import static org.instancio.Select.field;

public class BeyondAccount {
    String name;
    String email;
    String phone;
    String password;


    public static Stream<BeyondAccount> createBeyondStreamValid() {
        List<BeyondAccount> list = Instancio.ofList(BeyondAccount.class)
                .size(1)
                .generate(field(BeyondAccount::getName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(BeyondAccount::getEmail), gen -> gen.text().pattern("#c#c#c#c#c#c@mailinator.com"))
                .generate(field(BeyondAccount::getPhone), gen -> gen.text().pattern("+38095#d#d#d#d#d#d#d"))
                .generate(field(BeyondAccount::getPassword), gen -> gen.text().pattern("test1234"))
                .create();
        Stream<BeyondAccount> beyondStream = list.stream();
        return beyondStream;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getPassword(){
        return this.password;
    }

}
