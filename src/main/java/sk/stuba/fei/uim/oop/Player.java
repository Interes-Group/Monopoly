package sk.stuba.fei.uim.oop;

import java.util.Random;

public class Player {
    private static int counter = 0;
    private final String name;
    private final int id;
    private double money;
    private int position;


    public Player(String name) {
        this(name, 1000000, 0);
    }

    public Player(String name, int money, int position){
        this.name = name;
        this.money = money;
        this.position = position;
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

    public void payRent(RealEstateField realestate){
        if(!(realestate.getOwner().getPlayerName()).equals("bank")){
            this.payMoney(realestate.getRent(), realestate.getOwner());
            System.out.println("You paid rent " + realestate.getRent() + " to " + realestate.getOwner().getPlayerName() + " for this property!");
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

}
