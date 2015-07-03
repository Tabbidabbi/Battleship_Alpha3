package Gameobjects.Ships;

public abstract class Ship {

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

    public boolean isSunk() {
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

    public void setCurrentReloadTime(int currentReloadTime) {
        this.currentReloadTime = currentReloadTime;
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

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
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
