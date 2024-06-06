public class Orang {
    protected String nama;
    protected String tanggal_lahir;
    protected JENIS_KELAMIN jenisKelamin;

    public enum JENIS_KELAMIN {
        LAKI_LAKI,
        PEREMPUAN
    }

    public Orang(String nama, String tanggal_lahir, JENIS_KELAMIN jenisKelamin) {
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.jenisKelamin = jenisKelamin;
    }
}
