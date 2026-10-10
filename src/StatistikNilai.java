import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilaiKelas {

    private static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");


        int input;
        do {

            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            input = scanner.nextInt();

            if (input == SELESAI) {
                break;
            }

            if (input < 0 || input > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }

            daftar.add(input);
        } while (true);

        System.out.println();

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada data nilai sah yang dimasukkan.");
            scanner.close();
            return;
        }

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        double total = 0;
        for (int nilai : daftar) {
            total += nilai;
        }
        double rataRata = total / daftar.size();
        System.out.printf("Rata-rata       : %.2f\n", rataRata);

        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int i = 1; i < daftar.size(); i++) {
            int val = daftar.get(i);
            if (val > tertinggi) {
                tertinggi = val;
            }
            if (val < terendah) {
                terendah = val;
            }
        }
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);