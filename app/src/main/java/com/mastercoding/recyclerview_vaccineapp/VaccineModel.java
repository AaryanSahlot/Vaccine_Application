package com.mastercoding.recyclerview_vaccineapp;

public class VaccineModel {

    private String title;
    private int image;

    //Now creating constructor
    public VaccineModel(String title, int image) {
        this.title = title;
        this.image = image;
    }

    //creating getters
    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
//    //-----------------------------> This is how we create our data model class for this



}
