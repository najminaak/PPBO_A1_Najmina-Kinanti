public class Manager extends Pegawai{

    public Manager(String nama, String departement, char jenisKelamin) {
        super(nama, departement, jenisKelamin);
    }

    @Override
    public void setNip(int nipNih) {
        if (nipNih < 10) {
            this.setNip("M000" + nipNih);
        } else if (nipNih <100) {
            this.setNip("M00" + nipNih);
        } else if (nipNih <1000) {
            this.setNip("M0" + nipNih);
        }else {
            this.setNip("M" + nipNih);
        }
    }

    @Override
    public int hitungThr() {
        return super.hitungThr() * 2;
    }

    @Override
    public void displayInfo() {
        System.out.println("Jabatan : Manager");
        System.out.println("Nama : " + getNama());
        System.out.println("Departemen : " + getDepartemen());
        System.out.println("NIP : " + getNip());
        System.out.println("Gaji : " + getGaji());
        System.out.println("THR : " + hitungThr());
        System.out.println("Cuti : " + getCuti());
        System.out.println("======================================");
    }
}
