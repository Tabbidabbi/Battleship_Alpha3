package SaveLoad;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Game.Game;

public class SaveLoad {
	
	public static void save(Game game){
		try{
			FileOutputStream createFile = new FileOutputStream("save.txt");
			ObjectOutputStream writeFile = new ObjectOutputStream(createFile);
			
			writeFile.writeObject(game);
			writeFile.close();
		}
		catch(IOException e){
			e.printStackTrace();			
		}
	}
	
	public static Game load() {
		Game game = null;
		try{
			FileInputStream loadFile = new FileInputStream("save.txt");
			ObjectInputStream readFile = new ObjectInputStream(loadFile);
			
			try {
				game = (Game)readFile.readObject();
				
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			readFile.close();			
		}
		catch(IOException e){
			e.printStackTrace();			
		}		
		return game;
	}

}
