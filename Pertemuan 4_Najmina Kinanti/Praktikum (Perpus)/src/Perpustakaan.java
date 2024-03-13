import java.util.ArrayList;
import java.util.List;

public class Perpustakaan {
    String name;
    String lokasi;
    ArrayList<Buku> listBuku;
    int jmlHariOperasional;

    Perpustakaan() {
        System.out.println("TEST");
        listBuku = new ArrayList<Buku>();
        jmlHariOperasional = 6;
    }

//    Perpustakaan(String namaPerpus, String lokasiPerpus, int jmlHari) {
//        name = namaPerpus;
//        lokasi = lokasiPerpus;
//        jmlHariOperasional = jmlHari;
//    }

    Perpustakaan(String name, String lokasi, int jmlHariOperasional) {
        this.name = name;
        this.lokasi = lokasi;
        this.jmlHariOperasional = jmlHariOperasional;
        listBuku = new ArrayList<Buku>();
    }

    void printSemuaBuku() {
        for (Buku buku : this.listBuku) {
            System.out.println(buku.judul);
        }
    }

    int jmlHariLibur() {
        int totalHari = 7;
        int hariLibur =  totalHari - jmlHariOperasional;

        return hariLibur;
    }

    void tambahBuku(List<Buku> bukuBaru)  {
        for(Buku b : bukuBaru) {
            this.listBuku.add( b);
        }
    }
}
