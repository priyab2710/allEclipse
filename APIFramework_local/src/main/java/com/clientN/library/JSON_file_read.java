package com.clientN.library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSON_file_read {

	
	public static String GenerateStringFromJsonFile(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
}
