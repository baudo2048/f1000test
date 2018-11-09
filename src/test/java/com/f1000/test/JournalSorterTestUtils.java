package com.f1000.test;

import static com.f1000.test.JournalSorter.toOrderedList;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JournalSorterTestUtils {
	
	public static Set<Journal> withDefaultDataset(){
		Set<Journal> set = new HashSet<Journal>();
		set.add(new Journal("Journal A", 3.4f,false));
		return set;
	}
	
	public static Set<Journal> withDataset(String datasetFileName) {
		
		Set<Journal> journals = new HashSet<Journal>();
	
		DocumentBuilderFactory factory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		Document document=null;
		try {
			document = builder.parse(new File(JournalSorterTests.class.getClassLoader().getResource(datasetFileName).getFile()));
		} catch (IOException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		NodeList dataset = document.getElementsByTagName("journal");
		
		for(int i=0;i<dataset.getLength();i++) {
			journals.add(new Journal(
								((Element)dataset.item(i)).getAttribute("name"),
								Float.parseFloat(((Element)dataset.item(i)).getAttribute("score")),
								Boolean.parseBoolean( ((Element)dataset.item(i)).getAttribute("review") )
				));
		}	
	
		
		return journals;
	}
	
	public static void main(String[] args ) throws Exception {
		toOrderedList(withDataset("dataset03.xml"),(j)->!j.isReview()).forEach((j)->System.out.println(j.getRank() + " " + j.getName() + " " + j.getScore() + " " + j.isReview()));
	}
}
