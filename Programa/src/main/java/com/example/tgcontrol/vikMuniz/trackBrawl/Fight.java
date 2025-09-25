package com.example.tgcontrol.vikMuniz.trackBrawl;

import java.util.Date;

public class Fight {
    public String participants;
    public String local;
    public Date time;

    public boolean fightBegin() {
        System.out.println("A luta vai começar!");
        System.out.println("Participantes: " + this.participants);
        System.out.println("Local do confronto: " + this.local);
        System.out.println("Horário: " + this.time);
        return true;
    }
}