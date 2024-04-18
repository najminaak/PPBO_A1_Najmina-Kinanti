public class Main {
    public static void main(String[] args) {

        Toko mebel1 = new Toko();
        mebel1.getGudangBarang().tambahBahan(Gudang.bahan.KAYU, 20);
        mebel1.getGudangBarang().tambahBahan(Gudang.bahan.BAUT, 100);
        mebel1.getGudangBarang().tambahBahan(Gudang.bahan.CAT, 15);

        mebel1.getGudangBarang().buatBarang(Toko.TipeBarang.KURSI, 3);
        mebel1.getGudangBarang().cekStokBahan();

        mebel1.getGudangBarang().buatBarang(Toko.TipeBarang.KURSI, 5);
        mebel1.getGudangBarang().buatBarang(Toko.TipeBarang.MEJA, 5);

        mebel1.getGudangBarang().tambahBahan(Gudang.bahan.KAYU, 20);
        mebel1.getGudangBarang().tambahBahan(Gudang.bahan.BAUT, 100);
        mebel1.getGudangBarang().tambahBahan(Gudang.bahan.CAT, 15);
        mebel1.getGudangBarang().cekStokBahan();

        mebel1.getGudangBarang().buatBarang(Toko.TipeBarang.KURSI, 5);
        mebel1.getGudangBarang().cekIsiGudang();

        Pembeli pembeli1 = new Pembeli("hanif", Toko.TipeBarang.KURSI, 10);
        Pembeli pembeli2 = new Pembeli("muflih", Toko.TipeBarang.MEJA, 5);
        Pembeli pembeli3 = new Pembeli("fabih", Toko.TipeBarang.LEMARI, 3);

        mebel1.tambahAntrian(pembeli1);
        mebel1.tambahAntrian(pembeli2);
        mebel1.tambahAntrian(pembeli3);
        mebel1.cekIsiAntrian();

        mebel1.selesaikanAntrian();
        mebel1.cekIsiAntrian();
        mebel1.getGudangBarang().cekIsiGudang();
    }
}

