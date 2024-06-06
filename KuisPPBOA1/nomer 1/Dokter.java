import java.util.ArrayList;
import java.util.List;

public class Dokter extends Orang{
    protected String nomorSTR;
    protected int idDokter;
    protected String spesialis;
    protected List<Antrian> antrianPasien;
    private static int count = 0;

    public Dokter (String nama, String tanggal_lahir, JENIS_KELAMIN jenisKelamin,
                   String nomorSTR, String spesialis) {
        super(nama, tanggal_lahir, jenisKelamin);
        this.nomorSTR = nomorSTR;
        this.spesialis = spesialis;
        this.antrianPasien = new ArrayList<>();
    }

    public void tambahAntrian(Antrian antrian) {
        antrianPasien.add(antrian);
    }
    public void hapusAntrian() {
        if (!antrianPasien.isEmpty()) {
            antrianPasien.remove(0);
        }
    }
    public List<Antrian> getAntrianPasien() {
        return antrianPasien;
    }
    public void daftar(RumahSakit rumahSakit) {
        rumahSakit.tambahDokter(this);
    }
}
