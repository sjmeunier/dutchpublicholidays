package com.smeunier.dutchpublicholidays;

public class Holiday {
    private String date;
    private String name;
    private String day;
   
    public Holiday(){
        super();
    }
   
    public Holiday(String date, String day, String name) {
        super();
        this.date = date;
        this.name = name;
        this.day = day;
    }

    @Override
    public String toString() {
        return this.date + ". " + this.name;
    }
    
    public String getDate() {
        return this.date;
    }

    public String getDay() {
        return this.day;
    }
    
    public String getName() {
        return this.name;
    }
}
