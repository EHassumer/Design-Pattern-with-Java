package File;


import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Model.User;


public class MyHandler extends DefaultHandler {

	// List to hold Employees object
	private List<User> userList = null;
	private List<User> finalList = null;
	private User user = null;
	private User userFollowers = null;
	private User userFollowing = null;
	private StringBuilder data = null;

	// getter method for user final list
	public List<User> getUserList() {
		return userList;
	}


	private String name;
	private String password;
	
	
	boolean bName = false;
	boolean bPassword = false;
	boolean bFollowers = false;
	boolean bFollowing = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("User")) {
			// create a new User and put it in Map
			//String id = attributes.getValue("id");
			
			
			//emp.setId(Integer.parseInt(id));
			// initialize list
			if (userList == null)
				userList = new ArrayList<>();
		} else if (qName.equalsIgnoreCase("Name")) {
			// set boolean values for fields, will be used in setting User variables
			bName = true;
		} else if (qName.equalsIgnoreCase("Password")) {
			bPassword = true;
		} else if (qName.equalsIgnoreCase("Followers")) {
			///startElement(uri,localName,qName,attributes);
			bFollowers = true;
		} else if (qName.equalsIgnoreCase("Following")) {
			
			//startElement(uri,localName,qName,attributes);
			bFollowing = true;
		} 
		// create the data container
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bName) {
			// age element, set Employee age
			name = data.toString();
			bName = false;
		} else if (bPassword) {
			password = data.toString();
			// initialize User object and set name and password attribute
			user = new User(name,password);
			bPassword = false;
		} else if (bFollowers) {
			String followersName ;
			followersName=data.toString();
			userFollowers = new User(followersName);
			user.getFollowers().add(userFollowers);
			bFollowers = false;
		} else if (bFollowing) {
			String followingName ;
			followingName=data.toString();
			userFollowing = new User(followingName);
			user.getFollowing().add(userFollowing);
			bFollowing = false;
		} 
		
		if (qName.equalsIgnoreCase("User")) {
			// initialize User object and set list attribute
			User userFinal = new User(user);
			// add User object to list
			userList.add(userFinal);
		}
		if (qName.equalsIgnoreCase("Users")) {
			for(User k : userList) {
				setList(k);
			}
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
	
	private void setList(User user) {
		if (finalList == null)
			finalList = new ArrayList<>();
		for(User i : user.getFollowers()) {
			for(User k : userList) {
				if(i.getName().equals(k.getName())) {
					i = new User(k);
					
				}
			}	
		}
		for(User i : user.getFollowing()) {
			for(User k : userList) {
				if(i.getName().equals(k.getName())) {
					i = new User(k);
					
				}
			}	
		}
	}
}