package com.example.hotelManagement;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class firstTest {
    @Test
    public void simpleAssertion() {
        int f =1;
        int s = 4;

        int r = 2 +3;
        assertTrue(r == f+s);
    }
}
