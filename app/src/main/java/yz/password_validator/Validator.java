package yz.password_validator;

/**
 * Created by YZ on 2018-02-09.
 */

public class Validator {

    //Number of rules passed
    private int Strength = 0;

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

        //Store Strength
        int S = this.Strength;

        //Reset Strengh
        this.Strength = 0;

        return S;
    }

    //Rule 1: The password is not “password” (case insensitive)
    public int notPassword(String password) {
        if(!password.equalsIgnoreCase("password")) {
            Strength ++;
            return 1;
        }
        return 0;
    }
    //Rule 2: The password is at least 8 characters long
    public int enoughLength(String password) {
        if(password.length()<8) return 0;
        this.Strength ++;
        return 1;
    }
}
