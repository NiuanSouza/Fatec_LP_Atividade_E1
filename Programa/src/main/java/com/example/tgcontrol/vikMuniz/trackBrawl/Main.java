package com.example.tgcontrol.vikMuniz.trackBrawl;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Fighter fighter1 = new Fighter();
        fighter1.age = 28;
        fighter1.weight = 85.5;

        Fighter fighter2 = new Fighter();
        fighter2.age = 31;
        fighter2.weight = 72.0;

        System.out.println("--- Apresentação dos Lutadores ---");
        fighter1.apresetention();
        fighter2.apresetention();
        System.out.println("---------------------------------");

        Local arena = new Local();
        String localInfo = arena.calculateLocal(48, 120, 500);

        Fight mainEvent = new Fight();
        mainEvent.participants = "Lutador 1 vs. Lutadora 2";
        mainEvent.local = localInfo;
        mainEvent.time = new Date();

        System.out.println("\n--- Detalhes do Evento ---");
        boolean didFightStart = mainEvent.fightBegin();
        System.out.println("\nA luta começou? " + didFightStart);
    }
}