package Gameobjects.Ships;

public class Frigate extends Ship {

	String name = "Fregatte";
	
	//Frigate positionieren
	
	public Frigate(int number){
		super("F", 4, false, number, false, 2, 0, 2, "Fregatte");
		// TODO Auto-generated constructor stub
	}

	//Getter und Setter Methoden
	
        @Override
	public String getName() {
		return name;
	}

        @Override
	public void setName(String name) {
		this.name = name;
	}
}
