package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.Bean.CusBean;

public class CusDAO extends LogDAO {

	public CusBean search(String id, String password)
			throws Exception {

				Connection con = getConnection();

				PreparedStatement st;

				st = con.prepareStatement(
						"SELECT * FROM Login WHERE id=? and password=?" );


				st.setString(1, id);
				st.setString(2, password);

				ResultSet rs = st.executeQuery();

				CusBean cb = new CusBean();

				while (rs.next()) {

					cb.setId(rs.getString("id"));
					cb.setName(rs.getString("name"));
					cb.setPassword(rs.getString("password"));
				}
				st.close();
				con.close();

				return cb;
			}

}
