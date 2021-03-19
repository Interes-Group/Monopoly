package sk.stuba.fei.uim.oop;

public class RealEstateField extends Field{

    protected double price;
    protected double rent;
    protected String owner;


    public double getPrice() {
        return this.price;
    }

    public double getRent() {
        return this.rent;
    }

    public String getOwner() {
        return this.owner;
    }

    public void printBuilding(){}
}
