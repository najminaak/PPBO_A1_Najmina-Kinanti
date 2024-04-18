import java.util.ArrayList;
import java.util.List;

public class Toko {
    private List<Pembeli> antrian;
    private Gudang gudangBarang;

    public static enum TipeBarang {
        MEJA,
        KURSI,
        LEMARI
    }

    public Toko() {
        this.antrian = new ArrayList<>();
        this.gudangBarang = new Gudang();
    }

    public Gudang getGudangBarang() {
        return gudangBarang;
    }

    public void tambahAntrian(Pembeli pembeli) {
        if (!antrianPenuh()) {
            antrian.add(pembeli);
            System.out.println("berhasil menambah antrian");
        } else {
            System.out.println("Maaf, antrian sudah penuh.");
        }
    }

    public void selesaikanAntrian() {
        if (!antrian.isEmpty()) {
            Pembeli pembeli = antrian.get(0);
            if (barangDiBeliTersedia(pembeli)) {
                int jumlahBarang = pembeli.getJumlahBarang();
                Toko.TipeBarang jenisBarang = pembeli.getBarangDiBeli();

                if (gudangBarang.slotBarang(jenisBarang)) {
                    for (int i = 0; i < jumlahBarang; i++) {
                        gudangBarang.keluarkanBarangDariGudang(jenisBarang);
                    }
                    System.out.println(jumlahBarang + " " + jenisBarang +
                            " berhasil dikeluarkan dari gudang");
                } else {
                    System.out.println("Maaf, stok gudang untuk " +
                            jenisBarang + " tidak mencukupi");
                    return;
                }
                System.out.println("antrian terdepan berhasil diselesaikan");
                antrian.remove(0);

            } else {
                System.out.println("Maaf, stok barang tidak mencukupi untuk " +
                        pembeli.getNama());
            }
        } else {
            System.out.println("Tidak ada pembeli dalam antrian.");
        }
    }

    public void cekIsiAntrian() {
        System.out.println();
        System.out.println("   LIST ANTRIAN:");
        for (int i = 0; i < antrian.size(); i++) {
            Pembeli pembeli = antrian.get(i);
            System.out.println("antrian ke " + (i+1) +
                    ", nama: " + pembeli.getNama() +
                    ", barang di beli: " + pembeli.getBarangDiBeli() +
                    ", jumlah barang di beli: " + pembeli.getJumlahBarang());
        }
        System.out.println();
    }

    private boolean antrianPenuh() {
        return antrian.size() >= 10;
    }

    private boolean barangDiBeliTersedia(Pembeli pembeli) {
        TipeBarang tipeBarang = pembeli.getBarangDiBeli();
        return gudangBarang.bahanPembuatanMencukupi(tipeBarang);
    }
}