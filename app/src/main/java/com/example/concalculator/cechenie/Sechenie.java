package com.example.concalculator.cechenie;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Sechenie implements Comparable<Sechenie> {
    private String name;
    private double momentOfResistance;
    private double momentOfInertia;
    private double mass;
    private static int compareId = 1;

    private static NavigableSet<Sechenie> listOfAllObjects = new TreeSet<Sechenie>();

    public Sechenie(String name, double momentOfResistance, double momentOfInertia, double mass) {
        this.name = name;
        this.momentOfResistance = momentOfResistance;
        this.momentOfInertia = momentOfInertia;
        this.mass = mass;
    }

//    public Sechenie (){
//    }
//
//    public void setName(String name){
//        this.name = name;
//    }
//
//    public void setMomentOfResistance(double momentOfResistance){
//        this.momentOfResistance = momentOfResistance;
//    }
//
//    public void setMomentOfInertia(double momentOfInertia){
//        this.momentOfInertia = momentOfInertia;
//    }
//
//    public void setMass(int mass){
//        this.mass = mass;
//    }

    public String getName(){
        return name;
    }

    public double getMomentOfResistance(){
        return momentOfResistance;
    }

    public double getMomentOfInertia() {
        return momentOfInertia;
    }

    public double getMass() {
        return mass;
    }

    public void infoSechenie(){
        System.out.println(name + " " + momentOfResistance + " " + momentOfInertia + " " + mass);
    }

    public void putIn(Sechenie obj) {
        listOfAllObjects.add(obj);
    }

    public static Sechenie checkMomentOfResistanceModified(Sechenie closestValue) {
        compareId = 1;
        if (listOfAllObjects.ceiling(closestValue) == null) return listOfAllObjects.floor(closestValue);
        if (listOfAllObjects.floor(closestValue) == null) return listOfAllObjects.ceiling(closestValue);

        return listOfAllObjects.ceiling(closestValue);
    }

    public static Sechenie checkMomentOfInertiaModified(Sechenie closestValue) {
        compareId = 2;
        if (listOfAllObjects.ceiling(closestValue) == null) return listOfAllObjects.floor(closestValue);
        if (listOfAllObjects.floor(closestValue) == null) return listOfAllObjects.ceiling(closestValue);

        return listOfAllObjects.ceiling(closestValue);
    }

    public static String getClosestMomentOfResistance(double closestValue) {
        Sechenie resultObj = checkMomentOfResistanceModified(new Sechenie("Search", closestValue, 0, 0));

        return "Номер профиля: " + resultObj.getName() + "\nМомент сопротивления: " + resultObj.getMomentOfResistance();
    }

    public static Sechenie checkMomentOfResistanceAndInertia(Sechenie closestValue) {
        Sechenie resultMomentSoprotivleniya = checkMomentOfResistanceModified(closestValue);
        double distanceCeilingInertsii = resultMomentSoprotivleniya.getMomentOfInertia() - closestValue.getMomentOfInertia();

        return distanceCeilingInertsii > 0 ? resultMomentSoprotivleniya : checkMomentOfInertiaModified(closestValue);
    }

    public static String getClosestMomentOfResistanceAndInertia(double closestOfResist, double closestOfInertia) {
        Sechenie resultObj = checkMomentOfResistanceAndInertia(new Sechenie("Search", closestOfResist, closestOfInertia, 0));

        return "Номер профиля: " + resultObj.getName() +
                "\nWy = " + resultObj.getMomentOfResistance() +  " см³" +
                "\nIy = " + resultObj.getMomentOfInertia() + " см⁴" +
                "\nМасса = " + resultObj.getMass() + " кг";
    }

    @Override
    public int compareTo(Sechenie o) {
        if (compareId == 1) {
            return this.getMomentOfResistance() < o.getMomentOfResistance() ? -1 : 1;
        }
        if (compareId == 2) {
            return this.getMomentOfInertia() < o.getMomentOfInertia() ? -1 : 1;
        }
        return 0;
    }

}
