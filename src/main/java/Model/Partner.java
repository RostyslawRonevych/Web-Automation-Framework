package Model;

import org.instancio.Instancio;
import java.util.List;
import java.util.stream.Stream;

import static org.instancio.Select.field;

public class Partner {
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

    public static Stream<Partner> createPartnerStreamValid() {
        List<Partner> list = Instancio.ofList(Partner.class)
                .size(1)
                .generate(field(Partner::getFirstName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(Partner::getLastName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(Partner::getEmail), gen -> gen.text().pattern("#c#c#c#c#c#c@cskarb.ngo"))
                .generate(field(Partner::getPhone), gen -> gen.text().pattern("+38095#d#d#d#d#d#d#d"))
                .generate(field(Partner::getPassword), gen -> gen.text().pattern("#C#C#d#c#c#a#a#a#a##"))
                .generate(field(Partner::getSex), gen -> gen.ints().min(1).max(2))
                .generate(field(Partner::getOrganizationName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(Partner::getCategories), gen -> gen.ints().min(1).max(10))
                .generate(field(Partner::getPosition), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(Partner::getAbout), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .create();
        Stream<Partner> partnerStream = list.stream();
        return partnerStream;
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
