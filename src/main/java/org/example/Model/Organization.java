package org.example.Model;

import org.instancio.Instancio;

import java.util.List;
import java.util.stream.Stream;

import static org.instancio.Select.field;

public class Organization {
    String firstName;
    String lastName;
    String email;
    String phone;
    String password;
    int sex;
    String confirmPassword;
    String organizationName;
    int categories;
    String position;
    String about;

    public static Stream<Organization> createOrganizationStreamValid() {
        List<Organization> list = Instancio.ofList(Organization.class)
                .size(1)
                .generate(field(Organization::getFirstName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(Organization::getLastName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(Organization::getEmail), gen -> gen.text().pattern("#c#c#c#c#c#c@cskarb.ngo"))
                .generate(field(Organization::getPhone), gen -> gen.text().pattern("+38095#d#d#d#d#d#d#d"))
                .generate(field(Organization::getPassword), gen -> gen.text().pattern("#C#C#d#c#c#a#a#a#a##"))
                .generate(field(Organization::getSex), gen -> gen.ints().min(1).max(2))
                .generate(field(Organization::getOrganizationName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(Organization::getCategories), gen -> gen.ints().min(1).max(10))
                .generate(field(Organization::getPosition), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(Organization::getAbout), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .create();
        Stream<Organization> organizationStream = list.stream();
        return organizationStream;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
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

    public String getConfirmPassword(){
        return this.confirmPassword;
    }

    public String getOrganizationName(){
        return this.organizationName;
    }

    public int getCategories(){
        return this.categories;
    }

    public String getPosition(){
        return this.position;
    }

    public String getAbout(){
        return this.about;
    }

    public int getSex(){
        return this.sex;
    }
}
