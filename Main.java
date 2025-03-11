public class Main {
    public static void main(String[] args) {
        DataPenduduk dataPenduduk = new DataPenduduk();
        ConcurrentService concurrentService = new ConcurrentService();
        QueueService queueService = new QueueService();

        // Tambah data penduduk
        Penduduk p1 = new Penduduk("13080000101", "Nolan", "Bandung Timur");
        dataPenduduk.tambahPenduduk(p1);
        concurrentService.tambahPenduduk(p1);

        // Cari data penduduk
        System.out.println(dataPenduduk.cariPenduduk("13080000101").orElse(null));
        System.out.println(concurrentService.cariPenduduk("13080000101"));

        // Tambah dan proses antrian perubahan
        queueService.tambahPerubahan("Ubah alamat Nolan ke Jakarta");
        System.out.println("Diproses: " + queueService.prosesPerubahan());
        System.out.println("Undo: " + queueService.undoPerubahan());

        // Cetak data immutable
        System.out.println("Golongan darah: " + Constants.GOLONGAN_DARAH);
        System.out.println("Provinsi: " + Constants.PROVINSI);
        System.out.println("Kode negara: " + Constants.KODE_NEGARA);
    }
}