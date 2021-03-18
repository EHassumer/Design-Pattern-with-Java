package File;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import Model.User;

public class XMLReader {

	public List<User> XMLRead() {
		List<User> userList = new ArrayList<User>();
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			MyHandler handler = new MyHandler();
			saxParser.parse(new File("XML.xml"), handler);
			// Get Users list
			userList = handler.getUserList();
			// print user information
			/*for (User user : userList) {
				System.out.println(user);
				if (!user.getFollowers().isEmpty())
					System.out.println("follow " + user.getFollowers().get(0).toString());
			}*/

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return userList;
	}

}