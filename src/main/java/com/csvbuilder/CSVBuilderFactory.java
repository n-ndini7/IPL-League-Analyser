package com.csvbuilder;

public class CSVBuilderFactory<T> {
	@SuppressWarnings("rawtypes")
	public static ICSVBuilder createCSVBuilder() {
		return new OpenCSVBuilder();
	}

}
