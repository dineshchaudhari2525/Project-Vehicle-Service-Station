package test;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.project.dao.PartsDao;
import com.project.entity.Parts;

public class PartsDaoTest {
	@Test
	public void testAddParts() {
		PartsDao partsDao;
		try {
			partsDao=new PartsDao();
			System.out.println(partsDao.addParts(new Parts(9, "Tyres","Use_CEAT_Tyre",5860 )));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
