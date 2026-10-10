import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilai {

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

        int diatasRataRata = 0;
        for (int nilai : daftar) {
            if (nilai > rataRata) {
                diatasRataRata++;
            }
        }
        System.out.println("Di atas rata2   : " + diatasRataRata + " orang");

        int[] jumlahGrade = new int[5];
        for (int nilai : daftar) {
            if (nilai >= 85) {
                jumlahGrade[0]++;
            } else if (nilai >= 70) {
                jumlahGrade[1]++;
            } else if (nilai >= 55) {
                jumlahGrade[2]++;
            } else if (nilai >= 40) {
                jumlahGrade[3]++;
            } else {
                jumlahGrade[4]++;
            }
        }

        char[] namaGrade = {'A', 'B', 'C', 'D', 'E'};
        System.out.print("Distribusi      : ");
        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(namaGrade[i] + "=" + jumlahGrade[i] + (i < jumlahGrade.length - 1 ? " " : ""));
        }
        System.out.println();

        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);

        System.out.println("Terurut         : " + terurut);
        System.out.println("Urutan asli     : " + daftar);

        scanner.close();
    }
}