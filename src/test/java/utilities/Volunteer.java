package utilities;

import java.security.SecureRandom;
import java.util.Random;

public class Volunteer {
    String firstName;
    String lastName;
    String email;
    String phone;
    String password;
    String confirmPassword;

    public Volunteer(int firstNameLength, int lastNameLength, int phoneAdditionalLength, int passwordLowerCount, int passwordUpperCount, int passwordSpecialCount, int confirmPasswordType) {
        this.firstName = generateFirstName(firstNameLength);
        this.lastName = generateLastName(lastNameLength);
        this.phone = generatePhone(phoneAdditionalLength);
        this.password = generatePassword(passwordLowerCount, passwordUpperCount, passwordSpecialCount);
        this.confirmPassword = generateConfirmPassword(confirmPasswordType);
    }

    public String generateFirstName(int length) {
        String firstNameValue = null;

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            // Generating a random lowercase letter (ASCII values: 97 to 122)
            char randomChar = (char) (random.nextInt(26) + 'a');
            stringBuilder.append(randomChar);
        }

        firstNameValue = stringBuilder.toString();

        return firstNameValue;
    }

    public String generateLastName(int length) {
        String lastNameValue = null;

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            // Generating a random lowercase letter (ASCII values: 97 to 122)
            char randomChar = (char) (random.nextInt(26) + 'a');
            stringBuilder.append(randomChar);
        }

        lastNameValue = stringBuilder.toString();

        return lastNameValue;
    }

    public String generatePassword(int lowercaseCount, int uppercaseCount, int specialSymbolCount){
        String passwordValue = null;

        String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
        String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[{]};:',<.>/?";
        
        SecureRandom random = new SecureRandom();
        StringBuilder passwordBuilder = new StringBuilder();

        for (int i = 0; i < lowercaseCount; i++) {
            char randomLowercase = LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length()));
            passwordBuilder.append(randomLowercase);
        }

        for (int i = 0; i < uppercaseCount; i++) {
            char randomUppercase = UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length()));
            passwordBuilder.append(randomUppercase);
        }

        for (int i = 0; i < specialSymbolCount; i++) {
            char randomSpecialSymbol = SPECIAL_SYMBOLS.charAt(random.nextInt(SPECIAL_SYMBOLS.length()));
            passwordBuilder.append(randomSpecialSymbol);
        }

        // Shuffle the password characters to ensure randomness
        String tempPassword = passwordBuilder.toString();
        char[] passwordArray = tempPassword.toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passwordArray[index];
            passwordArray[index] = passwordArray[i];
            passwordArray[i] = temp;
        }
        
        passwordValue = passwordArray.toString();

        return passwordValue;
    }
    
    public String generateConfirmPassword(int type){
        String confirmPasswordValue = null;
        if (type == 1){
            confirmPasswordValue = password;
        }
        else if (type == 2) {
            confirmPasswordValue = generatePassword(5, 4,1);
        }
        return confirmPasswordValue;
    }

    public String generatePhone(int additionalDigits){
        String phoneValue = null;

        SecureRandom random = new SecureRandom();
        StringBuilder phoneNumberBuilder = new StringBuilder("+3809");

        for (int i = 0; i < additionalDigits; i++) {
            int randomDigit = random.nextInt(10); // Random digit from 0 to 9
            phoneNumberBuilder.append(randomDigit);
        }

        phoneValue = phoneNumberBuilder.toString();

        return phoneValue;
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
}
