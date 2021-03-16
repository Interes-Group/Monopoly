package sk.stuba.fei.uim.oop;

public class Player {
    private String name;
    private int money;
    private int position;


    public Player(String name) {
        this(name, 1000000, 0);
    }

    public Player(String name, int money, int position){
        this.name = name;
        this.money = money;
        this.position = position;
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

}
