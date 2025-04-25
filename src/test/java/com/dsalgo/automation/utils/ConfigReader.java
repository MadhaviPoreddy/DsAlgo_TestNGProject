package com.dsalgo.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	 private static Properties prop;

	    static {
	        try {
	            FileInputStream file = new FileInputStream("src/test/resources/testdata/config.properties");
	            prop = new Properties();
	            prop.load(file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String getProperty(String key) {
	        return prop.getProperty(key);
	    }
}
