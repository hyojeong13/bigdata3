package kr.mem.controller;

import java.util.HashMap;
import kr.mem.pojo.Controller;
import kr.mem.pojo.MemberContent_Controller;
import kr.mem.pojo.MemberDelete_Controller;
import kr.mem.pojo.MemberInsertForm_Controller;
import kr.mem.pojo.MemberInsert_Controller;
import kr.mem.pojo.MemberList_Controller;
import kr.mem.pojo.MemberUpdate_Controller;


public class HandlerMapping {

	//		hashmap : <key, value>Á¦³×¸¯
	private HashMap<String , Controller> mappings;
	
	public HandlerMapping() {
		
		mappings = new HashMap<String, Controller>();
		initMap();
	}

	private void initMap() {
		try {
		mappings.put("/list.do", new MemberList_Controller());
		mappings.put("/insert.do", new MemberInsert_Controller());
		mappings.put("/insertForm.do", new MemberInsertForm_Controller());
		mappings.put("/delete.do", new MemberDelete_Controller());		
		mappings.put("/content.do", new MemberContent_Controller());
		mappings.put("/update.do", new MemberUpdate_Controller());
		
		}catch(Exception e){
	         e.printStackTrace();
	     }
	}
	
	public Controller getController(String key) {
		
		return mappings.get(key);
	
	}
	
	
}
