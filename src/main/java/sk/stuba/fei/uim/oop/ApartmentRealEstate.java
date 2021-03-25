package sk.stuba.fei.uim.oop;

public class ApartmentRealEstate extends RealEstateField{

    private static final double RENT_RATE = 0.9;
    private static final double PRICE = 400000;

    public ApartmentRealEstate(Player bank){
        this.price = PRICE;
        this.rent = this.price * RENT_RATE;
        this.owner = bank;
    }

    public void printBuilding(){
        System.out.println("Bulding type: APARTMENT\t\tPrice: " + this.getPrice() + "\t\tRent: " + this.getRent() + "\t\tOwner: " + this.getOwner().getPlayerName());
    }

}
