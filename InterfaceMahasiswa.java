import java.sql.SQLException;
import java.util.List;
public interface InterfaceMahasiswa{
    Mahasiswa insert(Mahasiswa o) throws SQLException;
    void update(Mahasiswa o) throws SQLException;
    void delete(String nim) throws SQLException;
    List getAll() throws SQLException;
}
