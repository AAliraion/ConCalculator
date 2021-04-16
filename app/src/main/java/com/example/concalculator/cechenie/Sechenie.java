package com.example.concalculator.cechenie;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Sechenie implements Comparable<Sechenie> {
    private String name;
    private double momentOfResistance;
    private double momentOfInertia;
    private double mass;

    private static NavigableSet<Sechenie> listOfAllObjects = new TreeSet<Sechenie>();

    public Sechenie(String name, double momentOfResistance, double momentOfInertia, double mass) {
        this.name = name;
        this.momentOfResistance = momentOfResistance;
        this.momentOfInertia = momentOfInertia;
        this.mass = mass;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMomentOfResistance(double momentOfResistance){
        this.momentOfResistance = momentOfResistance;
    }

    public void setMomentOfInertia(double momentOfInertia){
        this.momentOfInertia = momentOfInertia;
    }

    public void setMass(int mass){
        this.mass = mass;
    }

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

    public void putIn(Sechenie obj) { // name method is awesome :)
        listOfAllObjects.add(obj);
    }


    public static Sechenie checkMomentOfInertia(Sechenie closestValueOfInertia) {
        if (listOfAllObjects.ceiling(closestValueOfInertia) == null) {
            return listOfAllObjects.higher(closestValueOfInertia);
        }
        if (listOfAllObjects.higher(closestValueOfInertia) == null) {
            return listOfAllObjects.ceiling(closestValueOfInertia);
        }

        double distanceCeilingInertia = listOfAllObjects.ceiling(closestValueOfInertia).getMomentOfInertia() - closestValueOfInertia.getMomentOfInertia();
        double distanceHigherInertia = closestValueOfInertia.getMomentOfInertia() - listOfAllObjects.higher(closestValueOfInertia).getMomentOfInertia();


        return distanceCeilingInertia > distanceHigherInertia ? listOfAllObjects.higher(closestValueOfInertia) : listOfAllObjects.ceiling(closestValueOfInertia);
    }

    public static Sechenie checkMomentOfResistance(Sechenie closestValueOfResistance) {
        if (listOfAllObjects.ceiling(closestValueOfResistance) == null) {
            return listOfAllObjects.higher(closestValueOfResistance);
        }
        if (listOfAllObjects.higher(closestValueOfResistance) == null) {
            return listOfAllObjects.ceiling(closestValueOfResistance);
        }

        double distanceCeilingResistance = listOfAllObjects.ceiling(closestValueOfResistance).getMomentOfResistance() - closestValueOfResistance.getMomentOfResistance();
        double distanceHigherResistance = closestValueOfResistance.getMomentOfResistance() - listOfAllObjects.higher(closestValueOfResistance).getMomentOfResistance();

        return distanceCeilingResistance > distanceHigherResistance ? listOfAllObjects.higher(closestValueOfResistance) : listOfAllObjects.ceiling(closestValueOfResistance);
    }

    public static String getClosestInertiaResistance(double closestValueOfInertia, double closestValueOfResistance) {
        Sechenie resultObj = checkMomentOfResistance(new Sechenie("Search", closestValueOfResistance, closestValueOfInertia, 0));
        if (resultObj.getMomentOfInertia() < closestValueOfInertia){
            Sechenie resultObj1 = checkMomentOfInertia(new Sechenie("Search", closestValueOfResistance, closestValueOfInertia, 0));
            return "Номер профиля: " + resultObj1.getName() + "\nWy = " + resultObj1.getMomentOfResistance() + " см³"+
                    "\nIy = " + resultObj1.getMomentOfInertia() + " см⁴"+ "\nМасса: " + resultObj1.getMass() + " кг";

        } else {
            return "Номер профиля: " + resultObj.getName() + "\nWy = " + resultObj.getMomentOfResistance() + " см³"+
                    "\nIy = " + resultObj.getMomentOfInertia() + " см⁴"+ "\nМасса: " + resultObj.getMass() + " кг";
        }
    }

    @Override
    public int compareTo(Sechenie o) {
        int result = this.getMomentOfInertia() < o.getMomentOfInertia() ? -1 : 1;
//
//        if (result > -2){
//            result = this.getMomentOfResistance() < o.getMomentOfResistance() ? -1 : 1;
//        }
        return result;
    }

}
