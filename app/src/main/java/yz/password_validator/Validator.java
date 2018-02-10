package yz.password_validator;

import java.util.regex.Pattern;

/**
 * Created by YZ on 2018-02-09.
 */

public class Validator {

    //Number of rules passed
    private int Strength = 0;

    //Some Patterns
    private Pattern Digits = Pattern.compile("[0-9]");
    private Pattern LowerCaseLetters = Pattern.compile("[a-z]");
    private Pattern UpperCaseLetters = Pattern.compile("[A-Z]");
    private Pattern SpecialCharacters = Pattern.compile("[^0-9a-zA-Z]");

    //Constructor
    public Validator()
    {
    }

    /*
     * Checks whether a string is a sufficiently strong password according to some set of rules,
     * and returns the number of rules that the string passed.
     */

    public int Validate(String password){

        //Test rules
        notPassword(password);
        enoughLength(password);
        digit(password);
        letterCases(password);
        specialCharacter(password);

        //Store Strength
        int S = this.Strength;

        //Reset Strengh
        this.Strength = 0;

        return S;
    }

    //Rule 1: The password shall not be “password” (case insensitive).
    public int notPassword(String password) {
        if(password.equalsIgnoreCase("password")) return 0;
        Strength ++;
        return 1;
    }

    //Rule 2: The password shall be at least 8 characters long.
    public int enoughLength(String password) {
        if(password.length()<8) return 0;
        this.Strength ++;
        return 1;
    }

    //Rule 3: The password shall have at least 1 digit.
    public int digit(String password) {
        if(!Digits.matcher(password).find()) return 0;
        this.Strength ++;
        return 1;
    }

    //Rule 4: The password shall have both upper and lower case.
    public int letterCases(String password) {
        if(!(LowerCaseLetters.matcher(password).find() && UpperCaseLetters.matcher(password).find())) return 0;
        this.Strength ++;
        return 1;
    }

    //Rule 5: The password shall have at least 1 special character.
    public int specialCharacter(String password) {
        if(!SpecialCharacters.matcher(password).find()) return 0;
        this.Strength ++;
        return 1;
    }
}
