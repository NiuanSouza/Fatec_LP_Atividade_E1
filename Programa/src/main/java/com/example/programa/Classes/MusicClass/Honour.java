package com.example.programa.Classes.MusicClass;

public class Honour {
    private String virtue;
    private String expression;
    private String message;
    private String honourReturn;

    public Honour(String virtue, String expression, String message) {
        this.virtue = virtue;
        this.expression = expression;
        this.message = message;
    }

    public String singPraise() {

        honourReturn = ("In " + virtue + ", we " + expression + " " + message + ".");
        return honourReturn;
    }
}

