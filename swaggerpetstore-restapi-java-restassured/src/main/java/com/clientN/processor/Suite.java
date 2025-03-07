package com.clientN.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.clientN.processor.Suite.Listener;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;





	@JacksonXmlRootElement(localName = "suite")
	public class Suite {

	    @JacksonXmlProperty(isAttribute = true)
	    private String name;	    
	        
	        
	    @JacksonXmlProperty(localName = "listeners")    
	    @JacksonXmlElementWrapper(useWrapping = false)
	    private Listeners listener;
	    
	  
			
		@JacksonXmlProperty(localName = "test")
	    @JacksonXmlElementWrapper(useWrapping = false)
	    private List < Test > tests;

	    public Suite(String name, String Listener_Name) {
	        this.name = name;
	        this.listener =  new Listeners(Listener_Name);
	         this.tests = new ArrayList < Suite.Test > ();	      
	        
	    }    
	          
	 	  
		public void addTest(String testname, String paramName, String paramValue, String className) {
	        Test test = new Test(testname);
	        test.addParam(paramName, paramValue);
	       Pattern.compile(",").splitAsStream(className).forEach(test::addClass);
	        this.tests.add(test);
	       
	        
	    }
	    
	 
	    class Test {

	        @JacksonXmlProperty(isAttribute = true)
	        private String name;

	        @JacksonXmlProperty(localName = "parameter")
	        private Parameter param;

	        @JacksonXmlProperty(localName = "classes")
	        private Classes klasses;

	        public Test(String name) {
	            this.name = name;
	            klasses = new Classes();
	        }

	        public void addParam(String name, String value) {
	            param = new Parameter(name, value);
	        }

	        public void addClass(String name) {
	            klasses.addClasses(name);
	        }

	    }

	    class Parameter {
	        @JacksonXmlProperty(isAttribute = true)
	        private String name;

	        @JacksonXmlProperty(isAttribute = true)
	        private String value;

	        public Parameter(String name, String value) {
	            this.name = name;
	            this.value = value;
	        }

	    }

	    class Classes {

	        @JacksonXmlProperty(localName = "class")
	        @JacksonXmlElementWrapper(useWrapping = false)
	        private List < Class > classes;

	        public Classes() {
	            this.classes = new ArrayList < Suite.Class > ();
	        }

	        public void addClasses(String name) {
	            this.classes.add(new Class(name));
	        }
	    }

	    class Class {

	        @JacksonXmlProperty(isAttribute = true)
	        private String name;
	        
	        

	        Class(String name) {
	            this.name = name;
	        }

	    }
	    
	   class Listeners
	   {
		   @JacksonXmlProperty(localName = "listener")    
		    @JacksonXmlElementWrapper(useWrapping = false)
		    private Listener listener;
		    
		    private String listenname;
		    
		  	 public Listeners(String name)
		  	 
		  	 {
		  		this.listenname=name; 
		  		this.listener=new Listener(listenname);
		  	 }
			  
	   }
	   class Listener
		{

			@JacksonXmlProperty(isAttribute = true, localName="class-name")
			private String name;
			
			public Listener(String name)
			{
				this.name=name;
			}
		}
	
	   

	}

