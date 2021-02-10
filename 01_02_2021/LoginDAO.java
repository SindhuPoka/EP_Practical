import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDAO {
	public int LoginInsert(LoginBean lb) throws ClassNotFoundException, SQLException {
		Connection con=DBUtil.DBConnection();
		String sql="insert into login values(?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,lb.getUsername());
		ps.setString(2, lb.getPassword());
		int i=ps.executeUpdate();
		return i;
}
}
