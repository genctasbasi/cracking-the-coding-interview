package com.escmobile.lab.crackingthecodinginterview.chapter_05_bit_operations;

import org.junit.Test;

public class BitOperationTests {

    @Test
    public void test_5_0_get_bit() {

        int bitValue = getBit(6, 1);

        int c = 1 << 1;
    }

    int getBit(int num, int i) {
        // num is 0110
        return (1 << i);
    }
}

