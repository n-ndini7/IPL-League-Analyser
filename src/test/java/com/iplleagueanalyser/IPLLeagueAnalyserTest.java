package com.iplleagueanalyser;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.iplleagueanalyser.SortByChoice.Choice;

public class IPLLeagueAnalyserTest {

	public String BOWLERS_CSV_FILE = "./FactsheetMostWkts.csv";
	public String BATSMEN_CSV_FILE = "./FactsheetMostRuns.csv";
	public List<IPLLeagueBatsmen> batsmen = null;
	public List<IPLLeagueBowlers> bowlers = null;
	public IPLLeagueAnalyserExecuter obj;
	public SortByChoice c1;
	public List<IPLLeagueBatsmen> l1 = null;
	public List<IPLLeagueBowlers> l2 = null;

	public IPLLeagueAnalyserTest() {
		obj = new IPLLeagueAnalyserExecuter();
		c1 = new SortByChoice();
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
	// this test case checks for no. of entires in a csv file

	@Test
	public void givenBattingCSVfileReturnTopAverageBatsmen() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		l1 = c1.sortBychoice(Choice.BAT_AVG, batsmen);
		Assert.assertEquals("83.2", l1.get(0).avg);
	}
	// this test case checks for top batting average batsman

	@Test
	public void givenBattingCSVfileReturnTopStrikingRateBatsman() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		l1 = c1.sortBychoice(Choice.STRIKE_RATE, batsmen);
		Assert.assertEquals("333.33", l1.get(0).strikeRate);
	}
	// this test case checks for top Striking rate batsman

	@Test
	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumFours() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		l1 = c1.sortBychoice(Choice.MAX_FOURS, batsmen);
		Assert.assertEquals("Shikhar Dhawan", l1.get(0).player);
	}
	// this test case checks for Player with maximum fours

	@Test
	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumSixes() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		l1 = c1.sortBychoice(Choice.MAX_SIXES, batsmen);
		Assert.assertEquals("Andre Russell", l1.get(0).player);
	}
	// this test case checks for Player with maximum sixes
}