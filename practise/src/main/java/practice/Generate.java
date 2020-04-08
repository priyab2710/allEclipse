package practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import xmlgenerate.practise.PhoneDetails;

public class Generate {

	public static void serializeToXML () throws JsonProcessingException
	{
	XmlMapper xmlmap=new XmlMapper();
	
//	Suite s= new Suite();
	
	 String xmlString = xmlmap.writeValueAsString(new Suite("priya"));
	 
	 System.out.println(xmlString);
	}
		public static void main(String[] args) throws JsonProcessingException {
		    System.out.println("Serializing to XML...");
		    serializeToXML();
		}
}
