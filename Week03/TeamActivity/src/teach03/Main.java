package teach03;


import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // create new instance of player and game
        Player p = new Player("Bob the Destroyer", 100, 50, 100);
        // *Stretch* add equipment
        p.addEquipment("Master Sword", 100);
        Game g = new Game(p);

        // save the game
        g.saveGame();

        // Load the game
        Game nGame = g.loadGame("gameSave.txt");

        // check the outcome
        // added just so I can check in the debugger if the values are correct,
        // I understand that this is not the proper way to print the variable to the
        // screen.
        System.out.println(nGame);
    }
}
