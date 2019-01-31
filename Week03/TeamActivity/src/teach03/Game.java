package teach03;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Game {

    Player player;

    /**
     * Constructor for Game
     * @param p
     */
    public Game(Player p) {
        player = p;
    }

    /**
     * Saves the game
     */
    void saveGame() throws FileNotFoundException {
        // Serialize the player
        Gson gPlayer = new Gson();

        // save the Json to the gameSave object.
        String gameSave = gPlayer.toJson(player);

        // Make print out instance
        try (PrintWriter out = new PrintWriter("gameSave.txt")){
            out.println(gameSave);
        }
    }

    /**
     * Takes a filename and creates a new player object from the deserialized
     * JSON and creates a new instance of Game
     *
     * @param filename
     * @return
     */
    static Game loadGame(String filename) throws IOException {
        // load the file
        String save = readFile(filename);

        // create new player from JSON String 'save'
        Player player = new Gson().fromJson(save, Player.class);

        // create the new game
        Game nGame = new Game(player);
        return nGame;
    }

    private static String readFile(String filename) throws IOException {
        String file = Files.readAllLines(Paths.get(filename)).get(0);

        return file;
    }

}
