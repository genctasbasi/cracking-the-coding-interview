package com.escmobile.lab.crackingthecodinginterview.chapter_13_java;

import android.util.Log;

import org.junit.Test;

public class JavaTests {


    @Test
    public void privateConstructor() {
        Child c = new Child();
        c.getName();
    }


    class Parent {
        private Parent() {
        }

        void getName() {
        }

    }

    class Child extends Parent {

        Child() {
        }

        @Override
        void getName() {
        }
    }

}
