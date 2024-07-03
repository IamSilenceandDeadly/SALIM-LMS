public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public String getnama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getjurusan() {
        return jurusan;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + "\nNIM: " + nim + "\nJurusan: " + jurusan;
    }
}
