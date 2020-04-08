package xmlgenerate.practise;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Listener {

	
	@JacksonXmlProperty(isAttribute = true)
    private String name;

	public Listener(String name2) {
		this.name=name2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	    
        
	
}
