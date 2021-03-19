package sk.stuba.fei.uim.oop;

public class ApartmentRealEstate extends RealEstateField{

    private static final double RENT_RATE = 0.3;
    private static final double PRICE = 400000;

    public ApartmentRealEstate(){
        this.price = PRICE;
        this.rent = this.price * RENT_RATE;
        this.owner = "Nobody"; //0 -> nobody owns it, otherwise player's [ID]
    }

    public void printBuilding(){
        System.out.println("Bulding type: APARTMENT\t\tPrice: " + this.getPrice() + "\t\tRent: " + this.getRent() + "\t\tOwner: " + this.getOwner());
    }

}
