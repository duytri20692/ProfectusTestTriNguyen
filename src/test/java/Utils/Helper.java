package Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import LikedIn.User;

public class Helper {
	public static User readData() {
		// Read test data from properties file
		FileReader reader = null;
		try {
			reader = new FileReader("src\\test\\resources\\testData.properties");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		Properties p = new Properties();
		try {
			p.load(reader);
		} catch (IOException e) {
			System.out.println("Cannot load file!");
		}
		User user = new User();
		user.setEmail(p.getProperty("loginUser"));
		user.setPassword(p.getProperty("loginPass"));
		return user;
	}
}
