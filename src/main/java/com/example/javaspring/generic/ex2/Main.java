package com.example.javaspring.generic.ex2;

import java.util.ArrayList;
import java.util.List;

class Electronies {
}

class Tv extends Electronies {
}

class Radio extends Electronies {
}

public class Main {

    public static void main(String[] args) {
        /*List<Tv> tvs = new ArrayList<>();
        tvs.add(new Tv());
        tvs.add(new Tv());
        List<? extends Electronies> electronies = tvs;
        for (Electronies e : electronies) {
            System.out.println(e);
        }

        //List<? super Electronies> wrongElectronies = tvs;
        //electronies.add(new Tv());*/

        List<? super Electronies> list = new ArrayList<Electronies>();
        list.add(new Tv());
        list.add(new Radio());

    }

}
