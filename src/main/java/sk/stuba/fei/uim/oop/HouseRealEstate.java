package sk.stuba.fei.uim.oop;

public class HouseRealEstate extends RealEstateField{

    private static final double RENT_RATE = 0.2;
    private static final double PRICE = 200000;

    public HouseRealEstate(Player bank){
        this.price = PRICE;
        this.rent = RENT_RATE * this.price;
        this.owner = bank;
    }

    public void printBuilding(){
        System.out.println("Bulding type: HOUSE\t\tPrice: " + this.getPrice() + "\t\tRent: " + this.getRent() + "\t\tOwner: " + this.getOwner().getPlayerName());
    }
}
