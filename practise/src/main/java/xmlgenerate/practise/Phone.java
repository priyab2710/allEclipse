package xmlgenerate.practise;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Phone {

	 @JacksonXmlProperty(isAttribute = true)
     private int name1;
		
}
