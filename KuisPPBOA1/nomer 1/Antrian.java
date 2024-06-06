public class Antrian {
    public boolean isEmpty() {
        return false;
    }

    public enum tipePasiens {
        BPJS,
        MANDIRI
    }

    protected String noAntrian;
    protected String namaPendaftar;
    protected String keluhan;
    protected String namaDokter;
    protected tipePasiens tipePasien;

    public Antrian(String noAntrian, String namaPendaftar, String keluhan,
                   String namaDokter, tipePasiens tipePasien) {
        this.noAntrian = noAntrian;
        this.namaPendaftar = namaPendaftar;
        this.keluhan = keluhan;
        this.namaDokter = namaDokter;
        this.tipePasien = tipePasien;
    }
}
