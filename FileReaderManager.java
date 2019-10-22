package fileReaderManager;

import fileReaderManager.ConfigFileReader;

public class FileReaderManager extends JsonDataReader{
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static JsonDataReader jsonDataReader;
	private static ConfigFileReader configFileReader;
	
	private FileReaderManager() {
	}
	
	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }
	 
	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
	 }
	 
	 public JsonDataReader getJsonReader(){
		 return (jsonDataReader == null) ? jsonDataReader = new JsonDataReader() : jsonDataReader;
	}
}
