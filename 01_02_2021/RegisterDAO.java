import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	public int RegisterInsert(RegisterBean sb) throws ClassNotFoundException, SQLException {
		Connection con=DBUtil.DBConnection();
		String sql="insert into register values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, sb.getRegno());
		ps.setString(2,sb.getName());
		ps.setString(3,sb. getEmail());
		ps.setString(4, sb.getPassword());
		int i=ps.executeUpdate();
		return i;
	}

}
