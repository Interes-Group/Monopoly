package sk.stuba.fei.uim.oop;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Monopoly {

    private static final int NUMBER_OF_FIELDS = 24;

    public void startGame(){

        //Creating scanners for inputs
        Scanner num_of_players = new Scanner(System.in);
        Scanner nick = new Scanner(System.in);
        Scanner playerOption = new Scanner(System.in);

        //Creating players
        System.out.println("Enter the number of players (2-4): ");
        int numPlayers = num_of_players.nextInt(); //reads int from user

        List<Player> players = new ArrayList<>();

        for(int i=1; i<numPlayers+1; i++){

            System.out.print("Name of player " + i + ": ");
            String name = nick.nextLine();
            Player localPlayer = new Player(name);
            players.add(localPlayer);

        }

        printPlayersInfo(players);

        //Creating game-board

        List<Field> fields = new ArrayList<>();

        for(int i=1; i<NUMBER_OF_FIELDS; i++){
            if(i==1){
                StartField localField = new StartField();
                fields.add(localField);
            }

            else if(i==4 || i==10 || i== 16 || i==22){
                ChanceField localField = new ChanceField();
                fields.add(localField);
            }

            else if(i==7){
                PrisonField localField = new PrisonField();
                fields.add(localField);
            }

            else if(i==13){
                PoliceField localField = new PoliceField();
                fields.add(localField);
            }

            else if(i==19){
                TaxField localField = new TaxField();
                fields.add(localField);
            }

            else{
                RealEstateField localField = new RealEstateField();
                fields.add(localField);
            }
        }

        //Game-cycle
        System.out.println();
        int i = 1;
        while(players.size() > 1){
            System.out.println("-------Round " + i + "-------\n");
            for(Player s:players){
                System.out.println(s.getPlayerName() + "'s turn: R -> skip buy and roll dice\t B -> buy property and roll after");
                char playerChose = playerOption.next().charAt(0);

                switch (playerChose){
                    case 'B':
                        System.out.println();
                        printPlayersInfo(players);
                        s.rollDice();
                        printPlayerInfo(s);
                        break;

                    case 'R':
                        s.rollDice();
                        printPlayerInfo(s);
                        System.out.println();
                        break;

                    default:
                        System.out.println("Seems like you mispelled! Sorry, try again next turn!");
                        System.out.println();


                }
            }
            i++;
        }
    }

    private void printPlayersInfo(List<Player> players){
        System.out.println("\nPlayers actual info:");
        int i = 1;
        for(Player s:players){
            System.out.println("Player " + i + ":\t[" + s.getPlayerID() + "]" + s.getPlayerName() + "\t\tMoney:\t" + s.getPlayerMoney() + "\t\tPosition:\t" + s.getPlayerPos());
            i++;
        }
    }

    private void printPlayerInfo(Player s){
        System.out.println("[" + s.getPlayerID() + "]" + s.getPlayerName() + "\t\tMoney:\t" + s.getPlayerMoney() + "\t\tPosition:\t" + s.getPlayerPos());
    }


}
