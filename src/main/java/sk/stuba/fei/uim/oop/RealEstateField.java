package sk.stuba.fei.uim.oop;

public class RealEstateField extends Field{

    protected double price;
    protected double rent;
    protected Player owner;

    public double getPrice() {
        return this.price;
    }

    public double getRent() {
        return this.rent;
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player player){
        this.owner = player;
    }

    public void printBuilding(){}
}
