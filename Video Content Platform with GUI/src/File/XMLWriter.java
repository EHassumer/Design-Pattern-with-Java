package File;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import Model.User;
import Model.Video;
import Model.WatchList;

public class XMLWriter {

	public void saveUser(List<User> userList) throws Exception {

		// create an XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream("XML.xml"));
		// create an EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		// create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);
		StartElement configStartElement = eventFactory.createStartElement("", "", "Users");
		eventWriter.add(configStartElement);
		eventWriter.add(end);
		// create config open tag
		for (User i : userList) {
			XMLEventFactory eventFactory2 = XMLEventFactory.newInstance();
			XMLEvent end2 = eventFactory2.createDTD("\n");
			XMLEvent tab = eventFactory2.createDTD("\t");
			// create Start node
			StartElement sElement = eventFactory2.createStartElement("", "", "User");
			eventWriter.add(tab);
			eventWriter.add(sElement);
			// Write the different nodes
			createNode(eventWriter, "Name", i.getName());
			createNode(eventWriter, "password", i.getPassword());
			// createNode(eventWriter, "followers",
			// Integer.toString(user.getFollowers().size()));
			createNode(eventWriter, "followers", i.getFollowers());
			// createNode(eventWriter, "following",
			// Integer.toString(user.getFollowing().size()));
			createNode(eventWriter, "following", i.getFollowing());
			createsNode(eventWriter, "Watchlist", i.getWatchList());

			EndElement eElement = eventFactory.createEndElement("", "", "User");
			eventWriter.add(eElement);
			eventWriter.add(end);
		}
		eventWriter.add(eventFactory.createEndElement("", "", "Users"));
		eventWriter.add(end);
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
		// createNode(eventWriter, "name", user.getName());

	}

	private void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {

		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);

	}

	private void createNode(XMLEventWriter eventWriter, String name, List<User> users) throws XMLStreamException {

		// create Content
		for (User i : users) {

			XMLEventFactory eventFactory = XMLEventFactory.newInstance();
			XMLEvent end = eventFactory.createDTD("\n");
			XMLEvent tab = eventFactory.createDTD("\t");
			// create Start node
			StartElement sElement = eventFactory.createStartElement("", "", name);
			eventWriter.add(tab);
			eventWriter.add(sElement);
			Characters characters = eventFactory.createCharacters(i.getName());
			eventWriter.add(characters);
			EndElement eElement = eventFactory.createEndElement("", "", name);
			eventWriter.add(eElement);
			eventWriter.add(end);
		}
		// create End node

	}

	private void createsNode(XMLEventWriter eventWriter, List<WatchList> videos)
			throws XMLStreamException {
		for (WatchList w : videos) {

			// create Content
			for (Video i : w.getList()) {
				XMLEventFactory eventFactory = XMLEventFactory.newInstance();
				XMLEvent end = eventFactory.createDTD("\n");
				XMLEvent tab = eventFactory.createDTD("\t");
				// create Start node
				StartElement sElement = eventFactory.createStartElement("", "",w.getName());
				eventWriter.add(tab);
				eventWriter.add(sElement);
				Characters characters = eventFactory.createCharacters(i.getTitle());
				eventWriter.add(characters);
				EndElement eElement = eventFactory.createEndElement("", "", w.getName());
				eventWriter.add(eElement);
				eventWriter.add(end);
			}
			// create End node
		}
	}
	private void createsNode(XMLEventWriter eventWriter, String name, List<WatchList> videos)
			throws XMLStreamException {
		
				XMLEventFactory eventFactory = XMLEventFactory.newInstance();
				XMLEvent end = eventFactory.createDTD("\n");
				XMLEvent tab = eventFactory.createDTD("\t");
				// create Start node
				StartElement sElement = eventFactory.createStartElement("", "", name);
				eventWriter.add(tab);
				eventWriter.add(sElement);
				createsNode(eventWriter, videos);
			
				EndElement eElement = eventFactory.createEndElement("", "", name);
				eventWriter.add(eElement);
				eventWriter.add(end);
			
		
	}

}