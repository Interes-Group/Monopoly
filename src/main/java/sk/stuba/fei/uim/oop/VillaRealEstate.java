package sk.stuba.fei.uim.oop;

public class VillaRealEstate extends RealEstateField{

    private static final double RENT_RATE = 0.95;
    private static final double PRICE = 500000;

    public VillaRealEstate(Player bank){
        this.price = PRICE;
        this.rent = this.price * RENT_RATE;
        this.owner = bank;
    }

    public void printBuilding(){
        System.out.println("Bulding type: VILLA\t\tPrice: " + this.getPrice() + "\t\tRent: " + this.getRent() + "\t\tOwner: " + this.getOwner().getPlayerName());
    }
}
