import java.util.ArrayList;

public class Keranjang {
    ArrayList<Barang> listBarang = new ArrayList<>();

    void tambahBarang(Barang barang) {
        int totalBarangSaatIni = totalBarang();
        if (totalBarangSaatIni + barang.jumlahBarang <= 5) {
            listBarang.add(barang);
            System.out.println("Berhasil memasukkan ke keranjang");
        } else {
            System.out.println("Wes too, keranjange wes mbludhag!!!!");
        }
    }

    int totalBarang() {
        int total = 0;
        for (Barang barang : this.listBarang) {
            total += barang.jumlahBarang;
        }
        return total;
    }

    int totalHarga() {
        int total = 0;
        for (Barang barang : this.listBarang) {
            total += barang.hargaBarang * barang.jumlahBarang;
        }
        return total;
    }

    void printHasil() {
        System.out.println("Jumlah Barang di Keranjang Saat Ini : " + totalBarang());
        System.out.println("Barang Pada Keranjang:");
        for (int i = 0; i < listBarang.size(); i++) {
            System.out.println("# " + listBarang.get(i).namaBarang + ", jumlah : " + listBarang.get(i).jumlahBarang);
        }
        System.out.println("Total Harga Yang Harus Dibayar : " + totalHarga());
    }
}