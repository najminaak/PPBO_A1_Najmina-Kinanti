import java.util.HashMap;

public class Gudang {
    public HashMap<bahan, Integer> stokBahan;
    public HashMap<Toko.TipeBarang, Integer> isiGudang;
    public enum bahan {
        KAYU,
        BAUT,
        CAT
    }

    public Gudang() {
        stokBahan = new HashMap<>();
        stokBahan.put(bahan.KAYU, 0);
        stokBahan.put(bahan.BAUT, 0);
        stokBahan.put(bahan.CAT, 0);

        isiGudang = new HashMap<>();
        isiGudang.put(Toko.TipeBarang.KURSI, 0);
        isiGudang.put(Toko.TipeBarang.MEJA, 0);
        isiGudang.put(Toko.TipeBarang.LEMARI, 0);
    }

    public void cekStokBahan() {
        System.out.println("   STOK BAHAN:");
        System.out.println("jumlah BAUT saat ini adalah: " + stokBahan.get(bahan.BAUT) + " buah");
        System.out.println("jumlah KAYU saat ini adalah: " + stokBahan.get(bahan.KAYU) + " buah");
        System.out.println("jumlah CAT saat ini adalah: " + stokBahan.get(bahan.CAT) + " buah");
        System.out.println();
    }

    public void cekIsiGudang() {
        System.out.println("   ISI GUDANG:");
        System.out.println("jumlah MEJA saat ini adalah: " +
                isiGudang.get(Toko.TipeBarang.MEJA) + " buah");
        System.out.println("jumlah KURSI saat ini adalah: " +
                isiGudang.get(Toko.TipeBarang.KURSI) + " buah");
        System.out.println("jumlah LEMARI saat ini adalah: " +
                isiGudang.get(Toko.TipeBarang.LEMARI) + " buah");
        System.out.println();
    }

    public void tambahBahan(bahan bahan, int jumlah) {
        stokBahan.put(bahan, stokBahan.get(bahan) + jumlah);
    }

    public void kurangiBahan(bahan bahan, int jumlah) {
        stokBahan.put(bahan, stokBahan.get(bahan) - jumlah);
    }

    public void masukanBarangKeGudang(Toko.TipeBarang barang) {
        isiGudang.put(barang, isiGudang.get(barang) + 1);
    }

    public void keluarkanBarangDariGudang(Toko.TipeBarang barang) {
        isiGudang.put(barang, isiGudang.get(barang) - 1);
    }

    public void buatBarang(Toko.TipeBarang barang, int jumlah) {
        if (slotBarang(barang) && bahanPembuatanMencukupi(barang)) {
            int kayuNeeded, bautNeeded, catNeeded;
            switch (barang) {
                case KURSI:
                    kayuNeeded = 2 * jumlah;
                    bautNeeded = 10 * jumlah;
                    catNeeded = jumlah;
                    break;
                case MEJA:
                    kayuNeeded = 3 * jumlah;
                    bautNeeded = 20 * jumlah;
                    catNeeded = 2 * jumlah;
                    break;
                case LEMARI:
                    kayuNeeded = 5 * jumlah;
                    bautNeeded = 30 * jumlah;
                    catNeeded = 3 * jumlah;
                    break;
                default:
                    System.out.println("tipe barang tidak valid.");
                    return;
            }

            if (stokBahan.get(bahan.KAYU) >= kayuNeeded &&
                    stokBahan.get(bahan.BAUT) >= bautNeeded &&
                    stokBahan.get(bahan.CAT) >= catNeeded) {
                for (int i = 0; i < jumlah; i++) {
                    masukanBarangKeGudang(barang);
                    kurangiBahan(bahan.KAYU, 2);
                    kurangiBahan(bahan.BAUT, 10);
                    kurangiBahan(bahan.CAT, 1);
                }
                System.out.println(jumlah + " " + barang + " berhasil ditambahkan ke gudang");
            } else {
                System.out.println("bahan tidak cukup");
            }
        } else {
            System.out.println("slot tidak tersedia atau stok bahan tidak cukup");
        }
        System.out.println();
    }

    public boolean bahanPembuatanMencukupi(Toko.TipeBarang barang) {
        switch (barang) {
            case KURSI:
                return stokBahan.get(bahan.KAYU) >= 2 &&
                        stokBahan.get(bahan.BAUT) >= 10 &&
                        stokBahan.get(bahan.CAT) >= 1;
            case MEJA:
                return stokBahan.get(bahan.KAYU) >= 3 &&
                        stokBahan.get(bahan.BAUT) >= 20 &&
                        stokBahan.get(bahan.CAT) >= 2;
            case LEMARI:
                return stokBahan.get(bahan.KAYU) >= 5 &&
                        stokBahan.get(bahan.BAUT) >= 30 &&
                        stokBahan.get(bahan.CAT) >= 3;
            default:
                return false;
        }
    }

    public boolean slotBarang(Toko.TipeBarang barang) {
        int maksimalSlot;
        switch (barang) {
            case KURSI:
                maksimalSlot = 20;
                break;
            case MEJA:
                maksimalSlot = 10;
                break;
            case LEMARI:
                maksimalSlot = 5;
                break;
            default:
                return false;
        }
        return isiGudang.get(barang) < maksimalSlot;
    }
}

