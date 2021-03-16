package sk.stuba.fei.uim.oop;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Monopoly {

    public void startGame(){

        Scanner num_of_players = new Scanner(System.in);
        Scanner nick = new Scanner(System.in);

        System.out.println("Enter the number of players (2-4): ");
        int numPlayers = num_of_players.nextInt(); //reads int from user

        List<Player> players = new ArrayList<>();

        for(int i=1; i<numPlayers+1; i++){

            System.out.print("Name of player " + i + ": ");
            String name = nick.nextLine();
            Player locPlayer = new Player(name);
            players.add(locPlayer);

        }

        printPlayerInfo(players);



    }

    public void printPlayerInfo(List<Player> players){
        System.out.println("\nPlayers actual info:");
        int i = 1;
        for(Player s:players){
            System.out.println("Hrac " + i + ":\t" + s.getPlayerName() + "\t\tMoney:\t" + s.getPlayerMoney() + "\t\tPosition:\t" + s.getPlayerPos());
            i++;
        }
    }
}
