public class Pasien extends Orang{
    protected String pekerjaan;
    protected String domisili;

    public Pasien (String nama, String tanggal_lahir, JENIS_KELAMIN jenisKelamin,
                   String pekerjaan, String domisili) {
        super(nama, tanggal_lahir, jenisKelamin);
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
    }

    public void daftar(RumahSakit rumahSakit, String keluhan,
                       String namaDokter, Antrian.tipePasiens tipePasien) {
        Dokter dokterTujuan = null;
        for (Dokter dokter : rumahSakit.listDokter) {
            if (dokter.nama.equals(namaDokter)) {
                dokterTujuan = dokter;
                break;
            }
        }

        if (dokterTujuan != null) {
            boolean sudahMendaftar = false;
            for (Antrian antrian : dokterTujuan.getAntrianPasien()) {
                if (antrian.namaPendaftar.equals(this.nama)) {
                    sudahMendaftar = true;
                    break;
                }
            }

            if (!sudahMendaftar) {
                Antrian antrian = new Antrian("", this.nama, keluhan,
                        dokterTujuan.nama, tipePasien);
                dokterTujuan.tambahAntrian(antrian);
                System.out.println("SUKSES");
            } else {
                System.out.println("PASIEN SUDAH TERDAFTAR.");
            }
        } else {
            System.out.println("DOKTER TERSEBUT TIDAK DITEMUKAN.");
        }
    }

    public void periksa(RumahSakit rumahSakit) {
        rumahSakit.periksaPasien();
    }
}