package rw.itcg.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 8:54:41 AM
 */
public class EmployeeIDgenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		String prefix = "EMP";
		Connection connection = session.connection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(employeeId) from Employee");
			if (rs.next()) {
				
				int id = rs.getInt(1) + 101;
				String generatedId = prefix + new Integer(id).toString();
				return generatedId;
			}

		} catch (Exception e) {
			System.out.println("error:>>>>>>>>>>>>>>> " + e.getMessage());
		}
		return null;
	}

}
