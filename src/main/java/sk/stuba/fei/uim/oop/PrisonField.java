package sk.stuba.fei.uim.oop;

public class PrisonField extends Field{

    public void lockPlayer(Player player){
        player.setPrisonLaps(3);
        System.out.println("Oh no! You have been locked in prison for 3 rounds!");
    }

}
