public class Vehicle {

    private String brand;
    private int year;
    private double rentalPrice;

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public Vehicle(String brand, int year, double rentalPrice) {
        this.brand = brand;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    public double hitungDiscount(){
        double disc = 0.0;
        if(year < 2010) {
            disc += 0.1;
        }
        return disc;
    }

    public double hitungHargaDiskon() {
        return hitungDiscount() * rentalPrice;
    }



    public double hitungHargaSetelahDiskon() {
        return rentalPrice - hitungHargaDiskon();
    }

    public void displayInfo() {
        System.out.println("Merk : " + getBrand());
        System.out.println("Tahun : " + getYear());
        System.out.println("Harga Sewa : " + getRentalPrice());
    }
}
