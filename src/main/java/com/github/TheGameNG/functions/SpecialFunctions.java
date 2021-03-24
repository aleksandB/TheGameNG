package com.github.TheGameNG.functions;

import java.util.Random;


public class SpecialFunctions {

    public double myRandom(double min, double max) {
        Random r = new Random();
        return (r.nextInt((int)((max-min)*1000+1))+min*1000) / 1000.000;


    }



}
