package fileReaderManager;
	import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import testDataTypes.TestData;
	
public class JsonDataReader {

	private final String JsonTestDataFilePath = System.getProperty("user.dir")+"/Lib/JsonTestData/TestData.json";
	private List<TestData> TestDataList;
	
	public JsonDataReader(){
		TestDataList = getTestData();
	}
	

	private List<TestData> getTestData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(JsonTestDataFilePath));
			TestData[] TestCaseData = gson.fromJson(bufferReader, TestData[].class);
			return Arrays.asList(TestCaseData);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + JsonTestDataFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	public final TestData getTestDataByName(String TestCaseName){
		 return TestDataList.stream().filter(x -> x.testCaseName.equalsIgnoreCase(TestCaseName)).findAny().get();
	}
	
}
