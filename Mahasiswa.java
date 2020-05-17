import java.util.Objects;
public class Mahasiswa{
    private String nim;
    private String nama;
    private String alamat;
    public Mahasiswa() {
    }
    public Mahasiswa(String nim, String nama, String alamat) {
        this.nim= nim;
        this.nama= nama;
        this.alamat= alamat;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat= alamat;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama= nama;
    }
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim= nim;
    }
    @Override
    public String toString() {
        return "Mahasiswa{" + "nim=" + nim+ ", nama=" + nama+ ", alamat=" + alamat+ '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nim);
        hash = 89 * hash + Objects.hashCode(this.nama);
        hash = 89 * hash + Objects.hashCode(this.alamat);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj== null) {
            return false;
        }   
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mahasiswa other = (Mahasiswa) obj;
        if (!Objects.equals(this.nim, other.nim)) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        return true;
    }   
}