import java.util.*;
import java.util.Optional;
//Mengelola data dengan list,set,map
public class DataPenduduk {
    private final List<Penduduk> daftarPenduduk = new ArrayList<>();
    private final Set<String> nikUnik = new HashSet<>();
    private final Map<String, Penduduk> dataPenduduk = new HashMap<>();

    public boolean tambahPenduduk(Penduduk penduduk) {
        if (nikUnik.add(penduduk.nik())) {
            daftarPenduduk.add(penduduk);
            dataPenduduk.put(penduduk.nik(), penduduk);
            return true;
        }
        return false;
    }

    public Optional<Penduduk> cariPenduduk(String nik) {
        return Optional.ofNullable(dataPenduduk.get(nik));
    }
}
