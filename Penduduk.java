//record untuk
public record Penduduk(String nik, String nama, String alamat) {
    @Override
    public String toString() {
        return nik + " - " + nama + " - " + alamat;
    }
}
