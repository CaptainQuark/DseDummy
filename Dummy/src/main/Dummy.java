package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Dummy {

	public static void main(String[] args) {

		ArrayList<Data> d = new ArrayList<>();

		for(int i = 0; i < 20; i++){
			d.add(new Data(i+1, "Datei " + (i+1)));
		}

		writeData(d, args);
		readData(args);
	}

	private static void writeData(ArrayList<Data> data, String[] args){
		try {
			File f = new File(args[0]);
			FileOutputStream fileOut = null;

			if( f.isDirectory() ){
				fileOut = new FileOutputStream(args[0] + "\\data.ser");
			}
			else{
				fileOut = new FileOutputStream(args[0]);
			}
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(data);

			out.close();
			fileOut.close();

			System.out.println("Serialized data is saved in " + args[0] + "\\data.ser");

		}catch(IOException i) {
			i.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void readData(String[] args){
		ArrayList<Data> dataList = new ArrayList<>();

		try {
			int i = 0;
			File file = new File(args[0]);

			if( file.isDirectory() ){
				System.out.println("Input is a directory.");
				File[] fileArray = file.listFiles();

				FileInputStream fIn = null;
				ObjectInputStream streamIn = null;

				for( File f : fileArray){

					if( f.isFile()){	        			  
						System.out.println(++i + ".: Path @ readData: " + f.getAbsolutePath());

						fIn = new FileInputStream(f.getAbsolutePath());
						streamIn = new ObjectInputStream(fIn);
						dataList = (ArrayList) streamIn.readObject();
					}
				}

				streamIn.close();
				fIn.close();
			}
			else{
				FileInputStream fileIn = new FileInputStream(args[0]);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				dataList = (ArrayList<Data>) in.readObject();
				in.close();
				fileIn.close();
			}

		}catch(IOException i) {
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("Data class not found");
			c.printStackTrace();
			return;
		}

		for( Data data : dataList ){
			System.out.println("Read id: " + data.id);
			System.out.println("Read name: " + data.name); 	  
		}
	}
}
