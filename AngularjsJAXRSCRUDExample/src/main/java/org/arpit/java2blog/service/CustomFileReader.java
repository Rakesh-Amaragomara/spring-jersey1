package com.rakesh.home.test;

import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
		List<User> list=(List<User>) jsonArray.stream().filter(userObj->isCritiriaMatched((JSONObject) userObj,user)).collect(Collectors.toList());
		return list;
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
	User user = new User();
	user.setUsername("");
	user.setMail("rakesh.goud.amaragomara@intl.verizon.com");
	user.setVerificationPin("123456");
	List<User> users=cust.getFullListUser(user, "user.json");
	if(users.size()==1){
		System.out.println("username feature is adopted");
		cust.ssotempcache.put(users.get(0).getUsername(), "usernameFeature is adopted");
		System.out.println("success only one user found now check for authentication type if it is a mobile then lock the user and send a mail username already specified on the mobile device");
	}else if(users.size()>1){
		System.out.println("unlock all the users");
	}else {
		System.out.println("something hacking here");
		if(cust.ssotempcache.get(user.getMail())!= null){
			int x =(Integer)cust.ssotempcache.get(user.getMail())+1;
			cust.ssotempcache.put(user.getMail(),x);
			if(x > 3){
				System.out.println("lock the user");
			}
		}else{
			cust.ssotempcache.put(user.getMail(), 1);
		}
		
	}
}


}
