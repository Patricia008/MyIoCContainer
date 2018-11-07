package iocContainer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
        NodeList beanList = doc.getElementsByTagName("bean");
        
        for (int i = 0; i < beanList.getLength(); i++) {
            Node bean = beanList.item(i);
            
            if (bean.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) bean;
               Class clazz;
				try {
					clazz = Class.forName(eElement.getAttribute("class"));
					
					NodeList propertyList = eElement.getElementsByTagName("property");

					Element property = (Element) propertyList.item(0);
					Class argClass = Class.forName(property.getAttribute("value"));
					Object instance;
					try {
						instance = clazz.getConstructor(Object.class).newInstance(argClass.newInstance());
						this.homemadeContainer.register(clazz, instance);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
					
					
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
