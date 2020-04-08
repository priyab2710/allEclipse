package XML;

	import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
	import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
	
		
		public class Listeners {

		   	    
			
		    @JsonProperty(localName = "listener")    
		    @JacksonXmlElementWrapper(useWrapping = false)
		    private Listener listener;
		    
		    private String listenname="teiij";
		    
		  	 public Listeners()
		  	 
		  	 {
		  		//this.listenname=name; 
		  		this.listener=new Listener(listenname);
		  	 }
			  
		 }
		
		class Listener
		{

			@JsonProperty(isAttribute = true)
			private String name;
			
			public Listener(String name)
			{
				this.name=name;
			}
		}
