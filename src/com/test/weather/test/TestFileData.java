package com.test.weather.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.test.weather.FileReader;
import com.test.weather.FootballData;
import com.test.weather.WeatherData;

class TestFileData {
	
	static FileReader fileReader = null;
	static WeatherData weatherData = null;
	static FootballData footballData = null;
	static String emptyFile = "";
	static String noFile = "";
	static String weather = "";
	static String football = "";
	
	@BeforeAll
	static void setup() {
		fileReader = new FileReader();
		weatherData = new WeatherData();
		footballData = new FootballData();
		emptyFile = "src/data/EmptyFile.dat";
		noFile = "src/data/NoFile.dat";
		weather = "src/data/weather.dat";
		football = "src/data/football.dat";
	}

	@Test
	void testEmptyFile() throws IOException {
		List<String> testData = fileReader.readFile(emptyFile);
		assertEquals(0, testData.size());
	}
	
	@Test
	void testFileNotFound() {
		try {
		List<String> testData = fileReader.readFile(noFile);
		}catch(IOException exc){
			assertNotNull(exc);
		}
	}
	
	@Test
	void testWeatherData() {
		List<String> testData = null;
		try {
			testData = fileReader.readFile(weather);
		}catch(IOException exc){
			exc.printStackTrace();
		}
		assertEquals(33, testData.size());
		
		int smallestDiffDay = weatherData.findSmallestTempShift(testData);
		assertEquals(14, smallestDiffDay);
	}
	
	@Test
	void testFootballData() {
		List<String> testData = null;
		try {
			testData = fileReader.readFile(football);
		}catch(IOException exc){
			exc.printStackTrace();
		}
		assertEquals(22, testData.size());
		
		String team = footballData.findTheSmallestDifferenceInGoals(testData);
		assertEquals("Aston_Villa", team);
	}

}
