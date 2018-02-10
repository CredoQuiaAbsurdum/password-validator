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
    public void Validate() {
        assertTrue(V.Validate("password")==1);
        assertTrue(V.Validate("pas123")==1);
        assertTrue(V.Validate("jioji8923")==2);

    }
}
