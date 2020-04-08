package com.clientN.processor;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class Listeners {

	
	  public Listeners(String name) {
		
		  this.listenername=name;
	}

	   @JacksonXmlProperty(isAttribute = true)
	    private String listenername;
	  
      class Listener
      {
    	  @JacksonXmlProperty(isAttribute = true)
  	       private String name;
      }
	   
	   }
