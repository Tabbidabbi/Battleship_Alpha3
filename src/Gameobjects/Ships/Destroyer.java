package Gameobjects.Ships;

public class Destroyer extends Ship {

    String name = "Zerstörer";

	//Zerstörer positionieren
    public Destroyer(int number) {
        super("Z", 5, false, number, false, 3, 0, 3, "Zerstoerer");
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
