import java.util.HashMap;

public class Lms {
    private HashMap<String, String> accounts;
    private HashMap<String, Mahasiswa> mahasiswa;

    public Lms() {
        accounts = new HashMap<>();
        mahasiswa = new HashMap<>();
    }

    public void signUp(String username, String password, Mahasiswa Mahasiswa) {
        accounts.put(username, password);
        mahasiswa.put(username, Mahasiswa);
    }

    public boolean signIn(String username, String password) {
        return accounts.containsKey(username) && accounts.get(username).equals(password);
    }

    public Mahasiswa getMahasiswa(String username) {
        return mahasiswa.get(username);
    }
}
