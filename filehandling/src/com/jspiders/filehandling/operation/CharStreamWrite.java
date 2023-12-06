package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWrite {
	public static void main(String[] args) throws IOException {
		File file = new File("Demo.txt");
		if (file.exists()) {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("Data from the java program...");
			System.out.println("Data Written to the file..");
			fileWriter.close();
		}else {
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("Data from the java program...");
			System.out.println("Data Written to the file..");
			fileWriter.close();
			
		}
	}

}
