package com.rakesh.home.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.rakesh.home.model.User;

public class CustomFileReader {
	CustomSSOTempCacheManager ssotempcache=CustomSSOTempCacheManager.getInstance();
public  File readJsonFile(String file){
	return getFileObjFromJson.apply(file);
}
@SuppressWarnings("unchecked")
private List<User> getFullListUser(User user,String file){
	File fileObj=readJsonFile(file);
	JSONParser parser = new JSONParser();
	try (Reader is = new FileReader(fileObj)) {
		JSONArray jsonArray = (JSONArray) parser.parse(is);
		for(int i=0;i<jsonArray.size();i++){
			JSONObject json=(JSONObject) jsonArray.get(i);
			System.out.println((String)json.get("username"));
		}
		List<User> list=(List<User>) jsonArray.stream().filter(userObj->isCritiriaMatched((JSONObject) userObj,user)).collect(Collectors.toList());
		return list;
		/*Iterator<JSONObject> itr=jsonArray.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next().get("username"));
		}*/
		} catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}
	
private boolean isCritiriaMatched(JSONObject userObj, User user) {
	// TODO Auto-generated method stub
	User actual=getUserFromJson.apply((JSONObject) userObj);
	if((user.getMail().equals(actual.getMail())) &&(user.getVerificationPin().equals(actual.getVerificationPin())) ){
		return true;
	}
	return false;
}
@SuppressWarnings("unchecked")
private Function<JSONObject, User> getUserFromJson = json -> {
	User user = new User();
	user.setUsername((String) json.get("username"));
	JSONArray mailArray=(JSONArray) json.get("mail");
	Iterator<String> itr=mailArray.iterator();
	if(itr.hasNext()){
		user.setMail(itr.next());
	}
	JSONArray pinArray=(JSONArray) json.get("verificationPin");
	Iterator<String> itr2=pinArray.iterator();
	if(itr2.hasNext()){
		user.setVerificationPin(itr2.next());
	}
	return user;
};
private Function<String,File> getFileObjFromJson=filename->{
	ClassLoader cl=getClass().getClassLoader();
	File user=new File(cl.getResource(filename).getFile());
	return user;
};

public static void main(String args[]){
	CustomFileReader cust=new CustomFileReader();
	System.out.println(cust.wrieFileWithEntries());
	System.out.println(cust.readFileWithEntries());
	
}

private Function<String,File> getFileObject=filename->{
	ClassLoader loader=getClass().getClassLoader();
	File file= new File(loader.getResource(filename).getFile());
	return file;
};
private boolean wrieFileWithEntries(){
	File file=getFileObject.apply("mytest.properties");
	OutputStream  obj = null;
	try {
		Properties prop=new Properties();
		prop.setProperty("rakesh", "genius");
		prop.setProperty("rishik", "brilliant");
		obj=new FileOutputStream(file);
		prop.store(obj, "this is true");
			return true;
	
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}finally{
		if (obj != null) {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}}
private boolean readFileWithEntries(){
	File file=getFileObject.apply("mytest.properties");
	FileReader obj = null;
	try {
		Properties prop=new Properties();
		//prop.setProperty("rakesh", "genius");
		obj=new FileReader(file);
		prop.load(obj);
		System.out.println(prop.getProperty("rakesh"));
		System.out.println(prop.getProperty("rishik"));
		//prop.store(obj, "this is true");
		
			return true;
	
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}finally{
		if (obj != null) {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}}
}
