package iocContainer;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import iocContainer.api.IocContainer;

public class HomemadeContextFromFile {
	
	private IocContainer homemadeContainer;

	public HomemadeContextFromFile(String fileName) {
		this.homemadeContainer = new HomemadeContainer();
		try {
			readFromXml(fileName);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	private void readFromXml(String fileName) throws ParserConfigurationException, SAXException, IOException {	
		File inputFile = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("property");
        
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               Class clazz;
				try {
					clazz = Class.forName(eElement.getAttribute("class"));
					this.homemadeContainer.register(eElement.getAttribute("name"), clazz);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
	               
	        }
        }
	}
	
	public IocContainer getIocContainer() {
		return this.homemadeContainer;
	}
}
