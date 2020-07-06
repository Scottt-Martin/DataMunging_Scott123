package com.test.weather;

import java.io.IOException;
import java.util.List;

public class WeatherData {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		String weatherDataFile = "src/data/weather.dat";
		FileReader fileReader = new FileReader();
		List<String> weatherDataStrings = null;
		try {
			weatherDataStrings = fileReader.readFile(weatherDataFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int smallestShift = weatherData.findSmallestTempShift(weatherDataStrings);
		System.out.println("The day with the smallest difference : " + smallestShift);
	}
	
	/**
	 * @param List<String>
	 * @return int
	 * This method takes an array of strings and returns the index 
	 * of the day with the smallest temperature shift.
	 **/
	public int findSmallestTempShift(List<String> fileData) {
		int index = 0;
		int day = 0;
		int min = 0;
		int max = 0;
		int diff = 100000;
		for(String str : fileData) {
			if(str.startsWith("Dy", 2) || str.startsWith("mo", 2) || str.isEmpty()) {
				continue;
			}
			str.trim();
			String[] dayTemps = str.split("\\W+");
			day = Integer.parseInt(dayTemps[1]);
			max = Integer.parseInt(dayTemps[2]);
			min = Integer.parseInt(dayTemps[3]);
			if(max - min < diff) {
				diff = (max - min);
				index = day;
			}
			
		}
		return index;
	}

}
