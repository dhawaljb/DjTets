package fileReaderManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {	
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir")+"/Configuration.properties";

	public ConfigFileReader(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try { properties.load(reader); }
			catch (IOException e) { e.printStackTrace(); }
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
		}finally {
			try { if(reader != null) reader.close(); }
			catch (IOException ignore) {}
		}
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;		
	}
	
	public String getApplicationUrl() {
		String appURL = properties.getProperty("appURL");
		if(appURL != null) return appURL;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:appURL");
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("edge")) return DriverType.edge;
		else if(browserName.equalsIgnoreCase("ie")) return DriverType.ie;
		else if(browserName.equals("chrome")) return DriverType.chrome;
		else if(browserName.equals("firefox")) return DriverType.firefox;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	public String getDBUrl(){
		String DBUrl = properties.getProperty("dbURL");
		if(DBUrl!= null) return DBUrl;
		else throw new RuntimeException("Database URL Path not specified in the Configuration.properties file for the Key:dbURL");		
	}
	
	public String getDBUsername(){
		String DBUsername = properties.getProperty("dbUsername");
		if(DBUsername!= null) return DBUsername;
		else throw new RuntimeException("dbUserName not specified in the Configuration.properties file for the Key:dbUsername");		
	}

	public String getDBPassword(){
		String DBPassword = properties.getProperty("dbPassword");
		if(DBPassword!= null) return DBPassword;
		else throw new RuntimeException("Database Password not specified in the Configuration.properties file for the Key:dbPassword");		
	}
}
