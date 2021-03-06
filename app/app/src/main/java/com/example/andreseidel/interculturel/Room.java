package com.example.andreseidel.interculturel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndreSeidel on 07/12/16.
 */

public class Room implements Serializable{
    private String name;
    private List<RouterInRoom> routers = new ArrayList<RouterInRoom>();

    public Room(String name){
        this.name = name;
    }

    public Room(){}

    public void add(RouterInRoom rout){
        for(RouterInRoom router : routers){
            if ( router.getBssid().equals(rout.getBssid()) ) {
                router.addSample(rout.getSumSamples());
                return;
            }
        }
        routers.add(rout);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RouterInRoom> getRouters() {
        return routers;
    }

    public void setRouters(List<RouterInRoom> routers) {
        this.routers = routers;
    }

    public String toString(){
        String str = "Room " + this.getName() + " [";

        boolean first = true;
        for (RouterInRoom router : routers){
            if (!first) {
                str += " // ";
            } else {
                first = false;
            }
            str += router.toString();
        }
        str += "]";
        return str;
    }

    public String toCSV(){
        String str = this.getName();

        for (RouterInRoom router : routers){
            str += "===" + router.toCSV();
        }
        return str;
    }

    public String getRoutersAsString(){
        String str = "";
        boolean first = true;
        for(RouterInRoom r: this.routers){
            if(first) {
                str += r.toString();
                first = false;
            } else {
                str += "\n" + r.toString();
            }
        }
        return str;
    }

}
