import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ImplementMahasiswa implements InterfaceMahasiswa{
    public Mahasiswa insert(Mahasiswa o) throws SQLException{
        PreparedStatement st=DatabaseUtilities.getConnection().prepareStatement("insert into mahasiswavalues(?,?,?)");
        st.setString(1, o.getNim());
        st.setString(2, o.getNama());
        st.setString(3, o.getAlamat());
        st.executeUpdate();
    return o;
    }

    public void update(Mahasiswa o) throws SQLException{//untukupdate kedatabase
        PreparedStatement st=DatabaseUtilities.getConnection().prepareStatement("update mahasiswaset nama=?,alamat=? where nim=?");
        st.setString(1, o.getNama());
        st.setString(2, o.getAlamat());
        st.setString(3, o.getNim());
        st.executeUpdate();
    }
    public void delete(String nim) throws SQLException{// untukdelete berdasarkannim
        PreparedStatement st=DatabaseUtilities.getConnection().prepareStatement("delete from mahasiswawhere nim=?");
        st.setString(1, nim);
        st.executeUpdate();
    }

    public List getAll() throws SQLException{ // untukread all, jadisemuadata diambildanditampilkan
        Statement st=DatabaseUtilities.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from mahasiswa");
        List list=new ArrayList();
        while(rs.next()){
            Mahasiswa mhs=new Mahasiswa();
            mhs.setNim(rs.getString("nim"));
            mhs.setNama(rs.getString("nama"));
            mhs.setAlamat(rs.getString("alamat"));
            list.add(mhs);
        }
        return list;
    }
}