import java.util.*;
// Mengelola Antrian Perubahan Data
public class QueueService {
    private final Queue<String> antrianPerubahan = new LinkedList<>();
    private final Deque<String> historyPerubahan = new ArrayDeque<>();

    public void tambahPerubahan(String perubahan) {
        antrianPerubahan.offer(perubahan);
    }

    public String prosesPerubahan() {
        String perubahan = antrianPerubahan.poll();
        if (perubahan != null) {
            historyPerubahan.push(perubahan);
        }
        return perubahan;
    }

    public String undoPerubahan() {
        return historyPerubahan.isEmpty() ? "Tidak ada perubahan untuk di-undo" : historyPerubahan.pop();
    }
}
