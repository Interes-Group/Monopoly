package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;


public class Player {
    private static int counter = 0;

    private final String name;
    private final int id;
    private double money;
    private int position;
    private int prisonLaps;


    public Player(String name) {
        this(name, 1000000, 0);
    }

    public Player(String name, int money, int position){
        this.name = name;
        this.money = money;
        this.position = position;
        this.prisonLaps = 0;
        counter++;
        this.id = counter;
    }

    public void rollDice(){
        //random number int range 1 - 6
        Random r = new Random();
        int num = r.nextInt((6-1)+1) + 1;
        System.out.println("You rolled number [" + num + "]!");
        this.position = this.position + num;

        if(this.position>23){
            this.position = this.position - 24;
            this.addMoney(200000);
            System.out.println("You get 200000 dollars for passing the start line!");
        }

    }

    public void buyProperty(RealEstateField realestate){
        if(realestate.getOwner().equals(this)){
            System.out.println("You already own this property!\n");
        }
        else{
            if(this.money>=realestate.getPrice()){
                if(realestate.getOwner().getPlayerName().equals("bank")){
                    this.takeMoney(realestate.getPrice());
                    System.out.println("You bought this property for " + realestate.getPrice() + "!");
                    realestate.setOwner(this);
                }
                else{
                    this.payMoney(realestate.getPrice(), realestate.getOwner());
                    System.out.println("You bought this property for " + realestate.getPrice() + " from " + realestate.getOwner().getPlayerName());
                    realestate.setOwner(this);
                }
            }
            else{
                System.out.println("You don't have enough money to buy this property!");
            }
        }
    }

    public void payRent(RealEstateField realestate){
        if(!(realestate.getOwner().getPlayerName()).equals("bank")){
            this.payMoney(realestate.getRent(), realestate.getOwner());
            System.out.println();
            System.out.println("You paid rent " + realestate.getRent() + " to " + realestate.getOwner().getPlayerName() + " for this property!");
            this.printPlayerInfo();
        }
    }

    public void killPlayer(List<Player> players, Field[] gameboard, Player bank){
        if(this.getPlayerMoney()<0){
            for(int i=0;i<24;i++){
                if(gameboard[i] instanceof RealEstateField){
                    ((RealEstateField) gameboard[i]).setOwner(bank);
                }
            }
            /*
            for(Player player: new ArrayList<>(players)){
                if(player.equals(this)){
                    players.remove(player);
                }
            }*/

            players.removeIf(n -> (n.equals(this)));
            System.out.println("You lost the game becuase you dont have enough money!");
        }
    }

    public void printPlayerInfo(){
        System.out.println("[" + this.getPlayerID() + "]" + this.getPlayerName() + "\t\tMoney:\t" + this.getPlayerMoney() + "\t\tPosition:\t" + this.getPlayerPos());
    }

    public String getPlayerName() {
        return this.name;
    }

    public double getPlayerMoney() {
        return this.money;
    }

    public int getPlayerPos() {
        return this.position;
    }

    public int getPlayerID() {
        return this.id;
    }

    public void addMoney(double money){
        this.money = this.money + money;
    }

    public void takeMoney(double money){
        this.money = this.money - money;
    }

    public void payMoney(double money, Player player){
        player.addMoney(money);
        this.takeMoney(money);
    }

    public int getPrisonLaps(){
        return this.prisonLaps;
    }

    public void setPrisonLaps(int laps){
        this.prisonLaps = laps;
    }

    public void setPlayerPos(int pos){
        this.position = pos;
    }

}
