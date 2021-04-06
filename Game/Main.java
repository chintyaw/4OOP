package Game;

import java.util.Scanner;
import CardDeck.Player;
import Help.*;
import Exceptions.InvalidColorException;
import Exceptions.InvalidNumberException;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String command;
        boolean start = false, exit = false;

        System.out.println();
        System.out.println("WELCOME TO HIJI");
        Game game = null;

        Player playergiliran = null;
        Hiji hiji = new Hiji(playergiliran, game);
        Thread t = new Thread(hiji);

        while (!exit)
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
            System.out.print("Insert command: ");
            command = input.next();

            if (start)
            {
                playergiliran = game.players.get(game.giliran);
                hiji = new Hiji(playergiliran, game);
                t = new Thread(hiji);
                if (playergiliran.getHiji() == false && playergiliran.getJumlah() == 1)
                {
                    t.start();
                }
            }

            if (command.equals("Start"))
            {
                if (!start) {
                    start = true;
                    game = new Game();
                }
                else {
                    System.out.println("You have started the game.");
                }
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
                    System.out.println();
                    playergiliran = game.players.get(game.giliran);
                    System.out.println("LIST KARTU ANDA");
                    playergiliran.ListCards();
                    System.out.println();
                }
            }

            else if (command.equals("Help"))
            {
                Help.HelpMenu();
            }

            else if (command.equals("PlayerTurn"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");

                }
                else
                {
                    game.ViewPlayerTurn();
                }
            }

            else if (command.equals("Draw"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");

                }
                else
                {
                    game.PlayerDraw();
                }
            }

            else if (command.equals("HIJI"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");
                }
                else
                {
                    playergiliran = game.players.get(game.giliran);

                    if (playergiliran.getJumlah() != 1)
                    {
                        System.out.println();
                        System.out.println("Anda memiliki lebih dari satu kartu.");
                        playergiliran.addCard(game.deck.draw());
                        playergiliran.addCard(game.deck.draw());
                        System.out.println("Anda mengambil 2 kartu!");
                        game.nextPlayer();
                    }

                    else
                    {
                        if (playergiliran.getHiji() == false) //belum hiji
                        {
                            t.interrupt();
                        }
                    }
                }

            }

            else if (command.equals("Discard"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");

                }
                else
                {
                    try{
                        game.discard();
                    } catch (InvalidColorException e) {
                        System.out.println(e.getErrorMessage());
                    } catch (InvalidNumberException e) {
                        System.out.println(e.getErrorMessage());
                    }
                }
            }

            else
            {
                System.out.println("Command not found. Please type 'Help'");
            }
        }
        input.close();
    }
}
