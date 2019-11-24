package Main;

import Vue.Interface;

import java.io.IOException;

public class app {

    public static void main (String args[]) throws IOException {

        Thread t = new Thread(new Interface());

    }


}
