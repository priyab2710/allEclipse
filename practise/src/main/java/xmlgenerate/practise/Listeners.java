package xmlgenerate.practise;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Listeners {

	
	@JsonProperty("listener")	
	private String Listener;

	public String getListener() {
		return Listener;
	}

	public void setListener(String listener) {
		Listener = listener;
	}
	
	Listeners(String Name)
	{
		Listener lsn = new Listener(Name);
		
	}
	
}
