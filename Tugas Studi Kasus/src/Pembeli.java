public class Pembeli {

    private String nama;
    private Toko.TipeBarang barangDiBeli;
    private int jumlahBarang;

    public Pembeli(String nama, Toko.TipeBarang barangDiBeli, int jumlahBarang) {
        this.nama = nama;
        this.barangDiBeli = barangDiBeli;
        this.jumlahBarang = jumlahBarang;
    }

    public String getNama() {
        return nama;
    }

    public Toko.TipeBarang getBarangDiBeli() {
        return barangDiBeli;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }
}
