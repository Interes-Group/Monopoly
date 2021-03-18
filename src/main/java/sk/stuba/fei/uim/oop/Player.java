package sk.stuba.fei.uim.oop;

import java.util.Random;

public class Player {
    private static int counter = 0;
    private String name;
    private int id;
    private int money;
    private int position;


    public Player(String name) {
        this(name, 1000000, 1);
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

        if(this.position>24){
            this.position = this.position - 24;
        }

    }

    public String getPlayerName() {
        return this.name;
    }

    public int getPlayerMoney() {
        return this.money;
    }

    public int getPlayerPos() {
        return this.position;
    }

    public int getPlayerID() {
        return this.id;
    }

}
