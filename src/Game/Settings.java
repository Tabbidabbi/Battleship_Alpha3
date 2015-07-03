package Game;

public class Settings {

    private int amountOfPlayer;

    private int amountOfKIPlayer;
    
    private int amountOfDestroyer;

    private int amountOfFrigate;

    private int amountOfCorvette;

    private int amountOfSubmarine;

    private int playfieldSize;
    
       // Konstanten
    final int SIZE_DESTRIOYER = 5;
    final int SIZE_FRIGATE = 4;
    final int SIZE_CORVETTE = 3;
    final int SIZE_SUBMARINE = 2;
    final int MIN_PLAYFIELD_SIZE = 8;
    final int MAX_PLAYFIELD_SIZE = 26;
    
    

    public Settings() {
        this.amountOfPlayer = 2;
        this.amountOfKIPlayer = 0;
        this.amountOfDestroyer = 1;
        this.amountOfFrigate = 1;
        this.amountOfCorvette = 2;
        this.amountOfSubmarine = 2;
        calculateMinPlayfieldSize();
    }
    
    
    



    //Instanzvariable ki spieler und im menu ki abfrage
    
    
    
    
    public int getAmountOfPlayer() {
        return amountOfPlayer;
    }

    public void setAmountOfPlayer(int amountOfPlayer) {
        this.amountOfPlayer = amountOfPlayer;
    }

    public int getAmountOfKIPlayer() {
        return amountOfKIPlayer;
    }

    public void setAmountOfKIPlayer(int amountOfKIPlayer) {
        this.amountOfKIPlayer = amountOfKIPlayer;
    }
    
    

    public int getAmountOfDestroyer() {
        return amountOfDestroyer;
    }

    public void setAmountOfDestroyer(int amountOfDestroyer) {
        this.amountOfDestroyer = amountOfDestroyer;
        calculateMinPlayfieldSize();
    }

    public int getAmountOfFrigate() {
        return amountOfFrigate;
    }

    public void setAmountOfFrigate(int amountOfFrigate) {
        this.amountOfFrigate = amountOfFrigate;
        calculateMinPlayfieldSize();
    }

    public int getAmountOfCorvette() {
        return amountOfCorvette;
    }

    public void setAmountOfCorvette(int amountOfCorvette) {
        this.amountOfCorvette = amountOfCorvette;
        calculateMinPlayfieldSize();
    }

    public int getAmountOfSubmarine() {
        return amountOfSubmarine;
    }

    public void setAmountOfSubmarine(int amountOfSubmarine) {
        this.amountOfSubmarine = amountOfSubmarine;
        calculateMinPlayfieldSize();
    }

    public int getPlayfieldSize() {
        return playfieldSize;
    }

    public void setPlayfieldSize(int playfieldSize) {
        this.playfieldSize = playfieldSize;
        if (this.playfieldSize < MIN_PLAYFIELD_SIZE) {
            this.playfieldSize = MIN_PLAYFIELD_SIZE;
        } else if (this.playfieldSize > MAX_PLAYFIELD_SIZE) {
            this.playfieldSize = MAX_PLAYFIELD_SIZE;
        }
        
    }
    
    private void calculateMinPlayfieldSize(){
        this.playfieldSize = (int) Math.ceil(Math.sqrt(3*(this.getAmountOfDestroyer() * SIZE_DESTRIOYER + this.getAmountOfFrigate() * SIZE_FRIGATE 
                + this.getAmountOfCorvette() * SIZE_CORVETTE + this.getAmountOfSubmarine() * SIZE_SUBMARINE)));
        
    
}
}
