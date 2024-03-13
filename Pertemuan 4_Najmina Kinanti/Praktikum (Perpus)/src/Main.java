import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Buku book = new Buku();
        book.judul = "Introduction to Software";
        book.id = 1;
        book.author = "Dwi";
        book.jmlHalaman = 100000;

        Buku book2 = new Buku();
        book2.judul = "Harry Potter";
        book2.id = 2;
        book2.author = "JK Rowling";
        book2.jmlHalaman = 789;

        Perpustakaan perpusSV = new Perpustakaan();
        perpusSV.name = "Perpustakaan Sekolah Vokasi";
        perpusSV.lokasi = "Sekip xx";

        perpusSV.listBuku.add(book);
        perpusSV.listBuku.add(book2);

        System.out.println(perpusSV.jmlHariOperasional);

        Perpustakaan perpusPusat = new Perpustakaan("Perpustakaan UGM", "UGM", 5);
        System.out.println(perpusPusat.lokasi);

        perpusPusat.listBuku.add(book2);
        perpusPusat.listBuku.add(book);

        perpusPusat.printSemuaBuku();

        int i = perpusPusat.jmlHariLibur();
        System.out.println(i);

        Buku b1 = new Buku();
        b1.judul = "OOP 1";
        Buku b2 = new Buku();
        b2.judul = "OOP 2";

        List<Buku> bukuBaru = new ArrayList<Buku>();
        bukuBaru.add(b1);
        bukuBaru.add(b2);
        perpusPusat.tambahBuku(bukuBaru);
        perpusPusat.printSemuaBuku();
    }
}