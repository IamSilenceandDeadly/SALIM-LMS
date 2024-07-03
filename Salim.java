import java.util.Random;
import java.util.Scanner;

public class Salim {
    private static Lms lms = new Lms();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Selamat datang di SALIM! Silahkan melakukan log in terlebih dahulu ");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.print("Pilih menu : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    signIn();
                    break;
                case 3:
                    System.out.println("Sampai jumpa !");
                    return;
                default:
                    System.out.println("Input tidak valid, silahkan coba lagi.");
            }
        }
    }

    private static void signUp() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        System.out.print("Masukkan nama anda : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM anda : ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan jurusan anda : ");
        String jurusan = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jurusan);
        lms.signUp(username, password, mahasiswa);
        System.out.println("Akun berhasil dibuat, silahkan log in kembali. ");
    }

    private static void signIn() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (lms.signIn(username, password)) {
            while (!verifikasiCaptcha()) {
                System.out.println("Verifikasi Captcha gagal, silahkan coba lagi.");
                System.out.println("(Mohon perhatikan penggunaan huruf biasa dengan huruf kapital kali ini!)");
            }
            System.out.println("Login berhasil, selamat datang di SALIM, " + username + " !");
            menu(username);
        } else {
            System.out.println("Username atau Password tidak valid, silahkan log in kembali. ");
        }
    }

    private static boolean verifikasiCaptcha() {
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            captcha.append(characters.charAt(random.nextInt(characters.length())));
        }

        System.out.println("Verifikasi Captcha: " + captcha);
        System.out.print("Masukkan teks captcha yang terlihat diatas : ");
        String input = scanner.nextLine();
        return input.equals(captcha.toString());
    }

    private static void menu(String username) {
        while (true) {
            System.out.println("1. Lihat data mahasiswa");
            System.out.println("2. Lihat KRS");
            System.out.println("3. Lihat riwayat akademik");
            System.out.println("4. Logout dari SALIM");
            System.out.print("Silahkan pilih menu : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    dataMahasiswa(username);
                    break;
                case 2:
                    System.out.println("Bukan masa periode KRS, silahkan kembali lain waktu.");
                    break;
                case 3:
                    System.out.println("Anda tidak memiliki riwayat akademik.");
                    break;
                case 4:
                    System.out.println("Berhasil Log Out.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silahkan pilih kembali.");
            }
        }
    }

    private static void dataMahasiswa(String username) {
        Mahasiswa mahasiswa = lms.getMahasiswa(username);
        if (mahasiswa != null) {
            System.out.println(mahasiswa);
        } else {
            System.out.println("Data Mahasiswa tidak tersedia, mohon periksa kembali.");
        }
    }
}
