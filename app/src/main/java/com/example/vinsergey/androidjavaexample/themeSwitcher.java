package com.example.vinsergey.androidjavaexample;

public class themeSwitcher {

    private static boolean state = false;

    public static boolean getState() {
        return state;
    }

    public static void setState(boolean state) {
        themeSwitcher.state = state;
    }
}
