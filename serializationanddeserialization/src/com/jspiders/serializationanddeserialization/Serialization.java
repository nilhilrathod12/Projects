package com.jspiders.serializationanddeserialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
	public static void main(String[] args) throws IOException {
		File file = new File("student.txt");
		if (file.exists()) {
			FileOutputStream fileOutputStream = new FileOutputStream(file);

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(new Student(1, "ram", "ram@gmail.com", 25));

			System.out.println("Object is writen to the file");
			objectOutputStream.close();
			fileOutputStream.close();

		} else {
			file.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file);

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(new Student(1, "ram", "ram@gmail.com", 25));
			
			System.out.println("Object is written the file");
			fileOutputStream.close();
			objectOutputStream.close();
		}

	}

}
