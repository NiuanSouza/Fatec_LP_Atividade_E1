package com.example.programa.Classes.MusicClass;

public class Honour {
    private int id;
    private String virtue;
    private String expression;
    private String message;
    private String honourReturn;

    public Honour(String virtue, String expression, String message) {
        this.virtue = virtue;
        this.expression = expression;
        this.message = message;
    }

    public Honour(int id, String virtue, String expression, String message) {
        this.id = id;
        this.virtue = virtue;
        this.expression = expression;
        this.message = message;
    }

    public String singPraise() {
        honourReturn = ("In " + virtue + ", we " + expression + " " + message + ".");
        return honourReturn;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getVirtue() { return virtue; }
    public String getExpression() { return expression; }
    public String getMessage() { return message; }

    public void setVirtue(String virtue) { this.virtue = virtue; }
    public void setExpression(String expression) { this.expression = expression; }
    public void setMessage(String message) { this.message = message; }
}