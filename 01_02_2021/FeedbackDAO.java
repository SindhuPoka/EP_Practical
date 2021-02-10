import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackDAO {

	public int FeedbackInsert(FeedbackBean fb)  throws ClassNotFoundException, SQLException{
		Connection con=DBUtil.DBConnection();
		String sql="insert into feedback values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, fb.getQ1());
		ps.setString(2, fb.getQ2());
		ps.setString(3, fb.getQ3());
		ps.setString(4, fb.getQ4());
		ps.setString(5, fb.getQ5());
		int i=ps.executeUpdate();
		return i;
		
	}

}
