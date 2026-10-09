import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilaiKelas {

    // Ketentuan 2: Sentinel static final int SELESAI = -1
    private static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ketentuan 1: Nilai disimpan di ArrayList<Integer>
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        // Ketentuan 2 & 3: Pembacaan memakai do-while dengan sentinel SELESAI
        int input;
        do {
            // Ketentuan 1: Nomor diambil dari size() + 1, bukan dari variabel pencacah terpisah
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            input = scanner.nextInt();

            if (input == SELESAI) {
                break;
            }

            // Ketentuan 3: Nilai di luar 0–100 ditolak dengan continue dan tidak di-add
            if (input < 0 || input > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }

            daftar.add(input);
        } while (true);

        System.out.println();