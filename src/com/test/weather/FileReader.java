package com.test.weather;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
	/**
	 * @param String fileName
	 * @return List<String>
	 * This method reads a file path and name and returns the file's data in an array of strings.
	 */
	public List<String> readFile(String fileName) throws IOException{
		List<String> result = new ArrayList<String>();
		Stream<String> stream = Files.lines(Paths.get(fileName));
			result = stream.collect(Collectors.toList());
	
		return result;
	}

}
