
import javax.swing.*;
//very simple runner for our program. Don't mess with it.
public class Game implements Runnable {
    public void run() {
        SwingUtilities.invokeLater(new StartMenu());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}

//for is in check (boolean color)
//loop through baord//find all peices not your color
//loop again over all controlled squares
