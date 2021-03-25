package sk.stuba.fei.uim.oop;

public class HotelRealEstate extends RealEstateField{
    private static final double RENT_RATE = 1;
    private static final double PRICE = 700000;

    public HotelRealEstate(Player bank){
        this.price = PRICE;
        this.rent = this.price * RENT_RATE;
        this.owner = bank;
    }

    public void printBuilding(){
        System.out.println("Bulding type: HOTEL\t\tPrice: " + this.getPrice() + "\t\tRent: " + this.getRent() + "\t\tOwner: " + this.getOwner().getPlayerName());
    }
}
