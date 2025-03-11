import java.util.*;
import java.util.concurrent.*; // Untuk koleksi thread-safe
// Akses Multi-Threading
public class ConcurrentService {
    private final List<Penduduk> daftarPenduduk = new CopyOnWriteArrayList<>();
    private final Set<String> nikUnik = ConcurrentHashMap.newKeySet();
    private final Map<String, Penduduk> dataPenduduk = new ConcurrentHashMap<>();

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
