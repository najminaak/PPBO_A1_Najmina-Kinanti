public class Car extends Vehicle {

    private Type type;

    public enum Type {
        CITY_CAR,
        FAMILY_CAR,
        PREMIUM_CAR
    }

    public Car(String brand, int year, double rentalPrice, Type type) {
        super(brand, year, rentalPrice);
        this.type = type;
    }

    @Override
    public double hitungDiscount() {
        double disc = super.hitungDiscount();
        if(type.equals(Type.FAMILY_CAR)) {
            disc += 0.05;
        } else if(type.equals(Type.PREMIUM_CAR)) {
            disc += 0.1;
        }
        return disc;
    }

    @Override
    public void displayInfo() {
        System.out.println("Detail Mobil : ");
        super.displayInfo();
        System.out.println("Tipe Mobil : " + type);
        System.out.println("Total Diskon : " + String.format("%.1f", hitungHargaDiskon()));
        System.out.println("Harga sewa setelah diskon : " + hitungHargaSetelahDiskon());
        System.out.println("--------------------------------");
    }
}
