package sk.stuba.fei.uim.oop;

public class HotelRealEstate extends RealEstateField{
    private static final double RENT_RATE = 0.5;
    private static final double PRICE = 700000;

    public HotelRealEstate(){
        this.price = PRICE;
        this.rent = this.price * RENT_RATE;
        this.owner = "Nobody";
    }

    public void printBuilding(){
        System.out.println("Bulding type: HOTEL\t\tPrice: " + this.getPrice() + "\t\tRent: " + this.getRent() + "\t\tOwner: " + this.getOwner());
    }
}
