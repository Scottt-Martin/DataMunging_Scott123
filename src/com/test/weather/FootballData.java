package com.test.weather;

import java.io.IOException;
import java.util.List;

public class FootballData {

	public static void main(String[] args) {
		String footballDataFile = "src/data/football.dat";
		FootballData footballData = new FootballData();
		FileReader fileReader = new FileReader();
		List<String> footballDataStrings = null;
		try {
			footballDataStrings = fileReader.readFile(footballDataFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String team = footballData.findTheSmallestDifferenceInGoals(footballDataStrings);
		System.out.println("The team with the smallest difference : " + team);
	}

	/**
	 * @param List<String>
	 * @return String
	 * This method takes an Array of Strings and returns the name of the team with 
	 * the smallest difference in goals scored by them and goals scored against them.
	 **/
	public String findTheSmallestDifferenceInGoals(List<String> footballData) {
		String teamName = "";
		String result = "";
		int goalsFor = 0;
		int goalsAgainst = 0;
		int diff = 100;
		for(String str : footballData) {
			if(str.startsWith("Team", 7) || str.startsWith("--", 3) || str.isEmpty()) {
				continue;
			}
			str.trim();
			String[] footballDataStr = str.split("\\W+");
			teamName = footballDataStr[2];
			goalsFor = Integer.parseInt(footballDataStr[7]);
			goalsAgainst = Integer.parseInt(footballDataStr[8]);
			if(Math.abs(goalsFor - goalsAgainst) < diff) {
				diff = (Math.abs(goalsFor - goalsAgainst));
				result = teamName;
			}
			
		}
		
		return result;
	} 
}
