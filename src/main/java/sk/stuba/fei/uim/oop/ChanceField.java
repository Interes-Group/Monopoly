package sk.stuba.fei.uim.oop;

import java.util.List;
import java.util.Random;

public class ChanceField extends Field{
    public void makeAction(){
        System.out.println("Chance field! Draw a card a see what happens!");
    }

    public double drawCard(List<Double> cards1, List<Double> cards2){
        double randCard;
        if(cards1.size()>0){
            Random rand = new Random();
            randCard = cards1.get(rand.nextInt(cards1.size()));
            cards1.remove(randCard);
            cards2.add(randCard);
            System.out.println("Your card: " + randCard + " dollars!");
        }
        else{
            Random rand2 = new Random();
            randCard = cards2.get(rand2.nextInt(cards2.size()));
            cards2.remove(randCard);
            cards1.add(randCard);
            System.out.println("Your card: " + randCard + " dollars!");
        }

        return randCard;
    }

}
