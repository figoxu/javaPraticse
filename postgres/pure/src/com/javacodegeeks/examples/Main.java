package com.javacodegeeks.examples;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.javacodegeeks.examples.db.DbContract;
import com.javacodegeeks.examples.db.PostgresHelper;

public class Main {

	public static void main(String[] args) {
		
		PostgresHelper client = new PostgresHelper(
				DbContract.HOST, 
				DbContract.DB_NAME,
				DbContract.USERNAME,
				DbContract.PASSWORD);
		
		try {
			if (client.connect()) {
				System.out.println("DB connected");
				
				Map<String,Object> vals = new HashMap<>();
				
				vals.put("id", 4);
				vals.put("name", "Aldo");
				vals.put("surname", "Ziflaj");
				vals.put("age", 19);
				if (client.insert("people", vals) == 1) {
					System.out.println("Record added");
				}
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}