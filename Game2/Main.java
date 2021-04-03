package Game;

import java.util.Scanner;
import java.util.ArrayList;
import CardDeck.Deck;
import CardDeck.Player;
import Cards.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String command;
        boolean start = false,exit = false;

        System.out.println("Welcome to HIJI");
        Game game = null;

        while (!exit)
        {
            System.out.print("Insert command: ");
            command = input.next();

            if (command.equals("Start"))
            {
                start = true;
                game = new Game();
            }

            else if (command.equals("PlayerList"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");

                }
                else
                {
                    game.PlayerList();
                }
            }

            else if (command.equals("CardList"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");

                }
                else
                {
                    Player playergiliran = game.players.get(game.giliran);
                    playergiliran.ListCards();
                }
            }

            else if (command.equals("Help"))
            {
                System.out.println("List of Commands:");
                System.out.println("- Start");
                System.out.println("- CardList");
                System.out.println("- Discard");
                System.out.println("- Draw");
                System.out.println("- HIJI");
                System.out.println("- PlayerList");
                System.out.println("- PlayerTurn");
                System.out.println("- Help");
            }

            else if (command.equals("PlayerTurn"))
            {
                if (game.clockwise == true)
                {


                }
                else
                {

                }
            }

            else
            {
                System.out.println("Command not found. Please type 'Help'");
            }
        }


    }
}
