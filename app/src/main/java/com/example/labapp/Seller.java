package com.example.labapp;

public final class Seller {
    double latitude,longitude;
    int id;
    String name,objectSelled;
    String[] options;
    public Seller(double lat,double lon,String name){
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
    }
    public Seller(double lat,double lon,String name,String object){
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
        this.objectSelled = object;
    }
    public void setData(double lat,double lon,String name,String obj){
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
        this.objectSelled = obj;
    }
    public double dist(double lat,double lon){
        return Math.abs(Math.pow(lat-this.latitude,2) - Math.pow(lon-this.longitude,2));
    }
    public String getData(){
        return this.name + " vinde " + this.objectSelled;
    }
}
