package test;

import org.junit.Assert;
import org.junit.Test;

public class Module1DaoTest {

	@Test
	public void testReadLine() throws Exception {
		Module1Dao module1Dao = new Module1Dao();
		String result = module1Dao.readLine(2);
		Assert.assertEquals("Module1Dao_2", result);
	}

}
