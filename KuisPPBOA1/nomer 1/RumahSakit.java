import java.util.*;

public class RumahSakit {
    protected String nama;
    protected String alamat;
    protected String noTelepon;
    protected List<Dokter> listDokter;
    protected Queue<Pasien> listAntrian;

    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.listDokter = new ArrayList<>();
        this.listAntrian = new LinkedList<>();
    }


    public void tambahDokter(Dokter dokter) {
        if (!listDokter.contains(dokter)) {
            listDokter.add(dokter);
            System.out.println("SUKSES");
        } else {
            System.out.println("DOKTER SUDAH TERDAFTAR");
        }
    }

    public void cekListDokter() {
        if (listDokter.isEmpty()) {
            System.out.println("BELUM ADA DOKTER YANG TERSEDIA SAAT INI");
        } else {
            System.out.println("BERIKUT LIST DOKTER YANG TERSEDIA SAAT INI");
            System.out.println("===========================================");
            for (Dokter dokter : listDokter) {
                System.out.println("NAMA DOKTER: " + dokter.nama + ", " + "DOKTER SPESIALIS: " + dokter.spesialis);
            }
        }
    }

    public void tambahAntrian(Pasien pasien, String keluhan, Antrian.tipePasiens tipePasien) {
        listAntrian.add(pasien); // Menambahkan pasien ke dalam list pasien
        System.out.println("Pasien " + pasien.nama + " berhasil didaftarkan.");
    }


    public void cekAntrianPasien() {
        System.out.println("Antrian rumah sakit saat ini");
        System.out.println("==============================");
        for (Dokter dokter : listDokter) {
            System.out.println("DR. " + dokter.nama);
            List<Antrian> antrianDokter = dokter.getAntrianPasien();
            if (antrianDokter.isEmpty()) {
                System.out.println("antrian kosong");
            } else {
                for (Antrian antrian : antrianDokter) {
                    System.out.println("atas nama: " + antrian.namaPendaftar);
                }
            }
            System.out.println("======================= ");
        }
    }

    public void periksaPasien() {
        if (listAntrian.isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian untuk diperiksa.");
        } else {
            boolean found = false;
            Queue<Pasien> tempQueue = new LinkedList<>(listAntrian);
            int nomorPasien = 1;
            while (!tempQueue.isEmpty()) {
                Pasien nextPasien = tempQueue.poll();
                System.out.println("Sedang memeriksa pasien ke-" + nomorPasien + ": " + nextPasien.nama);
                found = true;
                break;
            }
            if (!found) {
                System.out.println("Pasien tidak ditemukan dalam antrian untuk diperiksa.");
            }
        }
    }

}
