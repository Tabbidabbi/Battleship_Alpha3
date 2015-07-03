package Gameobjects.Playfield;

import IO.IO;

public class Field {

    private boolean isShot;

    private boolean isWater;

    private boolean isHit;

    private boolean hasShip;

    private boolean active;

    private String playerStatus;

    private String opponentStatus;

    private String fieldNumber;

    private int shipNumber;
    
    
    	public Field() {
		this.isShot = false;
		this.isWater = true;
		this.isHit = false;
		this.hasShip = false;
                this.active = true;
		this.playerStatus = "~";
                this.opponentStatus = "~";
    }

    public boolean isIsShot() {
        return isShot;
    }

    public void setIsShot(boolean isShot) {
        this.isShot = isShot;
    }

    public boolean getIsWater() {
        return isWater;
    }

    public void setIsWater(boolean isWater) {
        this.isWater = isWater;
    }

    public boolean isIsHit() {
        return isHit;
    }

    public void setIsHit(boolean isHit) {
        this.isHit = isHit;
    }

    public boolean isHasShip() {
        return hasShip;
    }

    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(String playerStatus) {
        this.playerStatus = playerStatus;
    }

    public String getOpponentStatus() {
        return opponentStatus;
    }

    public void setOpponentStatus(String opponentStatus) {
        this.opponentStatus = opponentStatus;
    }

    public String getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(String fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public int getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(int shipNumber) {
        this.shipNumber = shipNumber;
    }
    
    public void printPlayerPlayfield(){
		IO.print(this.playerStatus + "\t");
//		IO.printPlayerPlayfield(fieldnumber);
	}
	
	/**
	 * Methode zum Ausgeben des aktuellen Status aus Gegnersicht
	 */
	public void prinOpponentPlayfield(){
		IO.print(this.opponentStatus + "\t");
	}
    
    
}
