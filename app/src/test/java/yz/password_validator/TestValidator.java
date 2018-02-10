package yz.password_validator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by YZ on 2018-02-09.
 */

public class TestValidator {
    Validator V = new Validator();

    @Test
    public void TestPassword() {
        assertTrue(V.notPassword("password")==0);
        assertTrue(V.notPassword("PASSWORD")==0);
        assertTrue(V.notPassword("pasSwoRd")==0);
        assertTrue(V.notPassword("DSFJ23234")==1);
    }

    @Test
    public void TestLength() {
        assertTrue(V.enoughLength("123")==0);
        assertTrue(V.enoughLength("1234567")==0);
        assertTrue(V.enoughLength("12345678")==1);
        assertTrue(V.enoughLength("123456789")==1);
    }

    @Test
    public void TestDigit() {
        assertTrue(V.digit("dfsfadfds")==0);
        assertTrue(V.digit("4332435623")==1);
        assertTrue(V.digit("jio934352")==1);
    }
    @Test
    public void TestLetterCase() {
        assertTrue(V.letterCases("sdfsdfsdf")==0);
        assertTrue(V.letterCases("SDFSDFS")==0);
        assertTrue(V.letterCases("sdfsfsdJIOSDFJ")==1);
    }

    @Test
    public void TestSpecialCharacter(){
        assertTrue(V.specialCharacter("dfiuh2343")==0);
        assertTrue(V.specialCharacter("dsdf#2423")==1);
        assertTrue(V.specialCharacter("294895!")==1);
        assertTrue(V.specialCharacter("dfj54^")==1);
        assertTrue(V.specialCharacter("$2342")==1);
        assertTrue(V.specialCharacter("@")==1);
    }

    @Test
    public void Validate() {
        assertTrue(V.Validate("password")==1);
        assertTrue(V.Validate("pas123")==2);
        assertTrue(V.Validate("jioji8923")==3);
        assertTrue(V.Validate("djf$2324")==4);
        assertTrue(V.Validate("S3dgfd$23")==5);
        assertTrue(V.Validate("78@Co")==4);
        assertTrue(V.Validate("jEB,Eddw")==4);
    }
}
