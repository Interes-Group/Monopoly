package sk.stuba.fei.uim.oop;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Monopoly {

    private static final int NUMBER_OF_FIELDS = 24;

    public void playGame(){

        //Creating scanners for inputs
        Scanner num_of_players = new Scanner(System.in);
        Scanner nick = new Scanner(System.in);
        Scanner playerOption = new Scanner(System.in);
        Scanner playerYesNo = new Scanner(System.in);

        //default player -> meaning he owns every property from the start (banker) and sells them to players
        Player bank = new Player("bank", 999999999,0);

        //Creating players
        System.out.println("Enter the number of players (2+): ");
        int numPlayers = num_of_players.nextInt(); //reads int from user
        while(numPlayers<=1){
            System.out.println("Enter the number of players (2+): ");
            numPlayers = num_of_players.nextInt(); //reads int from user
        }

        List<Player> players = new ArrayList<>();

        for(int i=1; i<numPlayers+1; i++){

            System.out.print("Name of player " + i + ": ");
            String name = nick.nextLine();
            Player localPlayer = new Player(name);
            players.add(localPlayer);

        }

        printPlayersInfo(players);

        //collections for chance card
        List<Double> cards1 = new ArrayList<>();
        List<Double> cards2 = new ArrayList<>();

        //cards
        cards1.add(250000.0);
        cards1.add(500000.0);
        cards1.add(-250000.0);
        cards1.add(-500000.0);
        cards1.add(-600000.0);


        //Creating game-board
        Field[] gameboard = new Field[NUMBER_OF_FIELDS];

        for(int i=0; i<NUMBER_OF_FIELDS; i++) {
            if (i == 0) {
                gameboard[i] = new StartField();
            } else if (i == 3 || i == 9 || i == 15 || i == 21) {
                gameboard[i] = new ChanceField();
            } else if (i == 6) {
                gameboard[i] = new PrisonField();
            } else if (i == 12) {
                gameboard[i] = new PoliceField();
            } else if (i == 18) {
                gameboard[i] = new TaxField();
            } else if (i == 1 || i == 2 || i == 4 || i == 5) {
                gameboard[i] = new HouseRealEstate(bank);
            } else if (i == 7 || i == 8 || i == 10 || i == 11) {
                gameboard[i] = new ApartmentRealEstate(bank);
            } else if (i == 13 || i == 14 || i == 16 || i == 17) {
                gameboard[i] = new VillaRealEstate(bank);
            } else {
                gameboard[i] = new HotelRealEstate(bank);
            }
        }

        //Game-cycle
        System.out.println();
        int i = 1;
        while(players.size() > 1){
            System.out.println("----------------------------ROUND " + i + "----------------------------\n");
            for(Player s:players) {
                if (s.getPrisonLaps()==0){
                    System.out.println("____________________" + s.getPlayerName() + "'s turn____________________");
                    System.out.println("Press R to roll dice! Dont mispell!");
                    char playerChose = playerOption.next().charAt(0);
                    while(playerChose!='R'){
                        System.out.println("Press R to roll dice! Dont mispell!");
                        playerChose = playerOption.next().charAt(0);
                    }

                    s.rollDice();
                    s.printPlayerInfo();
                    System.out.println();

                    if(gameboard[s.getPlayerPos()] instanceof RealEstateField){
                        gameboard[s.getPlayerPos()].printBuilding();
                        s.payRent((RealEstateField)gameboard[s.getPlayerPos()]);
                        if(s.getPlayerMoney()<0){
                            s.killPlayer(players, gameboard, bank); //if has money < 0 -> kill him and setOwner of his realestate to bank
                            break;
                        }
                        System.out.println("Do you want to buy this property?\t [y/n]");
                        char choice = playerYesNo.next().charAt(0);
                        while(choice!='y' && choice!='n'){
                            System.out.println("Do you want to buy this property?\t [y/n]");
                            choice = playerYesNo.next().charAt(0);
                        }

                        if (choice == 'y') {
                            s.buyProperty((RealEstateField)gameboard[s.getPlayerPos()]);
                            s.printPlayerInfo();
                            System.out.println();
                        }
                    }

                    if(gameboard[s.getPlayerPos()] instanceof StartField){
                        gameboard[s.getPlayerPos()].makeAction();
                    }

                    if(gameboard[s.getPlayerPos()] instanceof TaxField){
                        gameboard[s.getPlayerPos()].makeAction();
                        s.takeMoney(500000);
                        if(s.getPlayerMoney()<0){
                            s.killPlayer(players, gameboard, bank); //if has money < 0 -> kill him and setOwner of his realestate to bank
                            break;
                        }
                    }

                    if(gameboard[s.getPlayerPos()] instanceof ChanceField){
                        gameboard[s.getPlayerPos()].makeAction();
                        s.addMoney(((ChanceField) gameboard[s.getPlayerPos()]).drawCard(cards1, cards2));
                        if(s.getPlayerMoney()<0){
                            s.killPlayer(players, gameboard, bank); //if has money < 0 -> kill him and setOwner of his realestate to bank
                            break;
                        }
                        s.printPlayerInfo();


                    }

                    if(gameboard[s.getPlayerPos()] instanceof PrisonField){
                        gameboard[s.getPlayerPos()].lockPlayer(s);
                    }

                    if(gameboard[s.getPlayerPos()] instanceof PoliceField){
                        gameboard[s.getPlayerPos()].makeAction();
                        s.setPlayerPos(6);
                        gameboard[s.getPlayerPos()].lockPlayer(s);
                    }

                }
                else{
                    System.out.println("____________________" + s.getPlayerName() + "'s turn____________________");
                    s.printPlayerInfo();
                    System.out.println();
                    System.out.println("You are in prison for " + (s.getPrisonLaps()) + " rounds, skipping this turn!");
                    s.setPrisonLaps(s.getPrisonLaps()-1);
                    System.out.println();
                }
            }
            i++;
        }

        System.out.println("\nCongratulations " + players.get(0).getPlayerName() + ", you won the game!");
    }

    private void printPlayersInfo(List<Player> players){
        System.out.println("\nPlayers actual info:");
        int i = 1;
        for(Player s:players){
            System.out.println("Player " + i + ":\t[" + s.getPlayerID() + "]" + s.getPlayerName() + "\t\tMoney:\t" + s.getPlayerMoney() + "\t\tPosition:\t" + s.getPlayerPos());
            i++;
        }
    }

}
