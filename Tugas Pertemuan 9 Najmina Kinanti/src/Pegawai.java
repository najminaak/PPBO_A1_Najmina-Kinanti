public class Pegawai {
    private String nama;
    private String departemen;
    private char jenisKelamin;

    private int gaji;
    private int cuti = 12;
    private String Nip;

    public Pegawai(String nama, String departemen, char jenisKelamin) {
        this.nama = nama;
        this.departemen = departemen;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public char getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(char jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public int getCuti() {
        return cuti;
    }

    public String getNip() {
        return Nip;
    }

    // Overloading cuti
    public void setCuti(int cutiNih) {
        this.cuti += cutiNih;
    }

    public void setCuti(String tipeCuti) {
        if (tipeCuti.equalsIgnoreCase("pernikahan")) {
            this.cuti += 2;
        } else if (tipeCuti.equalsIgnoreCase("persalinan")) {
            if (this.jenisKelamin == 'P' || this.jenisKelamin == 'p') {
                this.cuti += 90;
            } else if (this.jenisKelamin == 'L' || this.jenisKelamin == 'l') {
                this.cuti += 3;
            }
        }
    }

    // Overloading nip
    public void setNip(String nip) {
        this.Nip = nip;
    }

    public void setNip(int nipNih) {
        if (nipNih < 10) {
            this.Nip = "P000" + nipNih;
        } else if (nipNih <100) {
            this.Nip = "P00" + nipNih;
        } else if (nipNih <1000) {
            this.Nip = "P0" + nipNih;
        }else {
            this.Nip = "P" + nipNih;
        }
    }

    public int hitungThr() {
        return this.gaji;
    }

    public void displayInfo() {
        System.out.println("Jabatan : Pegawai");
        System.out.println("Nama : " + nama);
        System.out.println("Departemen : " + departemen);
        System.out.println("NIP : " + Nip);
        System.out.println("Gaji : " + gaji);
        System.out.println("THR : " + hitungThr());
        System.out.println("Cuti : " + cuti);
        System.out.println("======================================");
    }
}
