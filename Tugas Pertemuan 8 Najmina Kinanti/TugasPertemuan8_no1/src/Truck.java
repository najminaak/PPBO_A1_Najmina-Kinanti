public class Truck extends Vehicle {

    private int cargoCapacity;

    public Truck(String brand, int year, double rentalPrice, int cargoCapacity) {
        super(brand, year, rentalPrice);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double hitungDiscount() {
        double disc = super.hitungDiscount();
        if(cargoCapacity > 2000) {
            disc += 0.1;
        }
        return disc;
    }

    @Override
    public void displayInfo() {
        System.out.println("Detail Truk : ");
        super.displayInfo();
        System.out.println("Kapasitas Kargo : " + cargoCapacity);
        System.out.println("Total Diskon : " + String.format("%.1f", hitungHargaDiskon()));
        System.out.println("Harga sewa setelah diskon : " + hitungHargaSetelahDiskon());
        System.out.println("--------------------------------");
    }
}
