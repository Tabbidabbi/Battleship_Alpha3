package Gameobjects.Ships;

import java.io.Serializable;

import IO.IO;

public abstract class Ship implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7853606283486598296L;

	private int size;

    private boolean sunk;

    private int number;

    private boolean orientation;

    private int reloadTime;

    private int currentReloadTime;

    private int shootRange;

    private int hitpoints;

    private String sign;

    private String name;
    
       public Ship(String sign, int size, boolean sunk, int number, boolean orientation, int reloadTime, int currentReloadTime, int shootRange, String name) {
        this.sign = sign;
        this.number = number;
        this.size = size;
        this.sunk = sunk;
        this.orientation = orientation;
        this.reloadTime = reloadTime;
        this.currentReloadTime = currentReloadTime;
        this.shootRange = shootRange;
        this.hitpoints = size;
        this.name = name;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getIsSunk() {
        return sunk;
    }

    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOrientation() {
        return orientation;
    }

    public void setOrientation(boolean orientation) {
        this.orientation = orientation;
    }

    public int getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(int reloadTime) {
        this.reloadTime = reloadTime;
    }

    public int getCurrentReloadTime() {
        return currentReloadTime;
    }

    public void setCurrentReloadTime() {
        this.currentReloadTime = this.reloadTime + 1;
    }
    
    //Setzt ReloadTime einen Z�hler runter
    public void setDownReloadTime() {
        this.currentReloadTime--;
    }

    public int getShootRange() {
        return shootRange;
    }

    public void setShootRange(int shootRange) {
        this.shootRange = shootRange;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints() {
    	this.hitpoints--;
    	if(getHitpoints() == 0){
    		setSunk(true);
    		IO.println("Schiff wurde versenkt.");
    		//test
    		IO.println(getNumber()+ " " + getName() + " " + getHitpoints() + " " + getIsSunk());
    	}
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
       
       
}
