package com.iplleagueanalyser;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class IPLLeagueAnalyserTest {

	public String BOWLERS_CSV_FILE = "./FactsheetMostWkts.csv";
	public String BATSMEN_CSV_FILE = "./FactsheetMostRuns.csv";
	public List<IPLLeagueBatsmen> batsmen = null;
	public List<IPLLeagueBowlers> bowlers = null;
	public IPLLeagueAnalyserExecuter obj;
	public List<IPLLeagueBatsmen> l1 = null;
	public List<IPLLeagueBowlers> l2 = null;

	public IPLLeagueAnalyserTest() {
		obj = new IPLLeagueAnalyserExecuter();
	}

	@Test
	public void givenNumberOfEntriesInACSVFile_ShouldReturnExactlytheSameWhileReading()
			throws IPLLeagueAnalyserException {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
			Assert.assertEquals(99, bowlers.size());
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
			Assert.assertEquals(101, batsmen.size());
		} catch (IPLLeagueAnalyserException e) {
		}

	}

}