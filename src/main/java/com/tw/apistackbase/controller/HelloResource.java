package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 18/08/2017.
 * @return 
 */
@RestController
@RequestMapping("/hello")
public class HelloResource {

	@GetMapping(path = "/market")
	public  ResponseEntity<List<String>> market(){
		//准备数据
		List<String> productStrings = new ArrayList<String>();
		productStrings.add("boli");
		productStrings.add("qwe");
		return ResponseEntity.ok(productStrings);
	}
	
	
	
    @GetMapping(path = "/{userName}")
    public ResponseEntity<String> getAll(@PathVariable String userName) {

        return ResponseEntity.ok("Hello:" + userName);
    }


}
