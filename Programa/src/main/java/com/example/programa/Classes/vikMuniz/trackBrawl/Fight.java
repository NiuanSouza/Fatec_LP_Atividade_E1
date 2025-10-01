package com.example.programa.Classes.vikMuniz.trackBrawl;

import java.util.Date;

public class Fight {
    private Fighter fighter1;
    private Fighter fighter2;
    private Local local;
    private Date time;

    public Fight(Fighter f1, Fighter f2, Local local) {
        this.fighter1 = f1;
        this.fighter2 = f2;
        this.local = local;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean fightBegin() {
        return fighter1 != null && fighter2 != null && local != null;
    }

    public String getDetails() {
        String details = "\n--- Detalhes do Evento ---";
        details += "\nParticipantes: " + fighter1.getFighterName() + " vs. " + fighter2.getFighterName();
        details += "\nLocal do confronto: " + local.getInfo();
        details += "\nHorário: " + (time != null ? time.toString() : "Não definido");
        details += "\nA luta começou? " + (fightBegin() ? "SIM" : "NÃO");
        return details;
    }
}