package UserProfileExtraction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Process {
	
	List<UserProfile> userprofiles = new ArrayList<UserProfile>();
	
	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {
			List<RecordInfo> records = objectMapper.readValue(new File("C:\\Users\\Mon Ordi\\Downloads\\tp3 (1)\\tp3\\app_logs.log"), 
					new TypeReference<List<RecordInfo>>() {});
			
		for(RecordInfo record : records) {
			//iterer sur chaque enregistrement et creer les user profiles
		}
		
		//Ensuite faire des comparaison 
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * public static String getJsonFromFile(String filename) {
	 * 
	 * String jsonText = ""; try { BufferedReader bufferedReader = new
	 * BufferedReader(new FileReader(filename)); String line; while((line =
	 * buffered)) }
	 * 
	 * }
	 */

}
