package package1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Contacts {
	@Test
	public void debug() throws IOException
	{
		FileOutputStream fos=new FileOutputStream("./commondata.properties");
		Properties prop=new Properties();
		prop.setProperty("browser", "chrome");
		prop.setProperty("url", "https://testing-env:8888");
		prop.setProperty("userName", "admin");
		prop.setProperty("password", "manager");
		prop.store(fos, "writing");
	}
}
  