public class Main {
    public static void main(String[] args) {

        Pegawai pegawai1 = new Pegawai("Diza", "HRD", 'P');
        pegawai1.setGaji(1000000);
        pegawai1.setCuti(10);
        pegawai1.setNip("P0001");
        pegawai1.displayInfo();

        Pegawai pegawai2 = new Pegawai("Raihan", "Product", 'L');
        pegawai2.setGaji(1500000);
        pegawai2.setCuti("pernikahan");
        pegawai2.setNip(2);
        pegawai2.displayInfo();

        Manager manager = new Manager("Nayla", "Operational", 'P');
        manager.setGaji(2000000);
        manager.setCuti("persalinan");
        manager.setNip(3);
        manager.displayInfo();

        Salesman salesman1 = new Salesman("Fauzan", "Marketing", 'L');
        salesman1.setGaji(2500000);
        salesman1.setTarget(100);
        salesman1.setPenjualan(120);
        salesman1.setCuti("persalinan");
        salesman1.setNip("S0004");
        salesman1.displayInfo();
    }
}