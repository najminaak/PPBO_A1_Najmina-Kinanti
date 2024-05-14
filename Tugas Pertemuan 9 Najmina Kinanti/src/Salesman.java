public class Salesman extends Pegawai{
    private int target;
    private int penjualan;

    public Salesman(String nama, String departement, char jenisKelamin) {
        super(nama, departement, jenisKelamin);
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
    }

    @Override
    public void setNip(int nipNih) {
        if (nipNih < 10) {
            this.setNip("S000" + nipNih);
        } else if (nipNih <100) {
            this.setNip("S00" + nipNih);
        } else if (nipNih <1000) {
            this.setNip("S0" + nipNih);
        }else {
            this.setNip("S" + nipNih);
        }
    }

    @Override
    public int hitungThr() {
        if (penjualan >= target) {
            return getGaji() * 2;
        } else {
            return getGaji();
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}
