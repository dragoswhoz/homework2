package tema_02_03_2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOoperations {
	private static Path file = Paths.get(".\\History_of_Java.txt");
	private static Path file1 = Paths.get(".\\test.txt");
	private static Path file2 = Paths.get(".\\filewritten.txt");
	

	public static void main(String[] args) throws IOException {
		listAllFilesAndDirectories(file);
		listOnlyFilesWithExtension(file,".txt");
		checkIfPathExists(file);
		checkReadWriteAtributes(file);
		checkIfDirectoryOrFile(file);
		comparePathsLexivographivaly(file, file1);
		getLastModifiedTime(file);
		getSize(file);
		
	//	Files.createFile(file1);
	//	Files.write(file2, Files.readAllBytes(file),StandardOpenOption.APPEND);
		readFileToByteArray(file);
		readAFileLineByLine(file);
		readPlainTextFile(file);
		storeLinesOfTesxtInAnArray(file);
		writeAndReadAPlainTextFile(file, file2);
		appendTextToExistingFile(file2, "This text was appended");
		readThreeLines(file);
		findMostUsedWord(file);
		findLongestWord(file);
	}

	private static void listAllFilesAndDirectories(Path path) {
		try (Stream<Path> list = Files.list(path.getParent())) {
			System.out.println("Method 1 - Write a program to get a list of all file/directory names from the given.\n");
			list.forEach(p -> System.out.println(p));
			printDelimiterLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void listOnlyFilesWithExtension(Path path, String ext) {
		try (Stream<Path> list = Files.list(path.getParent()).filter(p -> !Files.isDirectory(p)).filter(p -> p.toString().endsWith(ext))) {
			System.out.println("Method 2 - Write a program to get specific files by extensions from a specified folder.\n");
			list.forEach(p -> System.out.println(p));
			printDelimiterLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static boolean checkIfPathExists(Path path) {
		System.out.println("Method 3 - Write a program to check if a file or directory specified by pathname exists or not.\n");
		if(Files.exists(path)) {
			System.out.println(path.toString() + " -> exists");
			printDelimiterLine();
			return true;
		}else {
			System.out.println(path.toString() + " -> does not exists");
			printDelimiterLine();
			return false;
		}
	}
	
	public static void checkReadWriteAtributes(Path path) {
		System.out.println("Method 4 - Write a program to check if a file or directory has read and write permission.\n");
		System.out.print(path.toString() + "\t\tread -> " + Files.isReadable(path) + "\t\twrite -> " +
	Files.isWritable(path)+"\n");
		printDelimiterLine();

		
	}
	
	public static void checkIfDirectoryOrFile(Path path) {
		Predicate<Path> isDirectory = p -> Files.isDirectory(path);
		System.out.println("Method 5 - Write a program to check if given pathname is a directory or a file.\n");
		if(isDirectory.test(path)) {
			System.out.println(path.toString() + "\t-> is directory");
		}else {
			System.out.println(path.toString() + "\t-> is file");
		}
		printDelimiterLine();

	}
	
	public static void comparePathsLexivographivaly(Path path1, Path path2) {
		System.out.println("Method 6 - Write a program to compare two files lexicographically.\n");

		String messageGreater = path1.toString() + " is lexicographicaly greater than " + path2.toString();
		String messageSmaller = path1.toString() + " is lexicographicaly smaller than " + path2.toString();
		String messageEqual = path1.toString() + " is lexicographicaly equal with " + path2.toString();
		
		String result = path1.compareTo(path2) == 0 ? messageEqual : (path1.compareTo(path2) > 0) ? messageGreater : messageSmaller;
			
		System.out.println(result);
		printDelimiterLine();
	}
	
	public static void getLastModifiedTime(Path path) {
		System.out.println("Method 7 - Write a program to get last modified time of a file.\n");

		try{
			System.out.println(Files.getLastModifiedTime(path));
		}catch(IOException e) {
			System.out.println("The file does not exist");
		}
		printDelimiterLine();
	}
	
	public static void getSize(Path path) {
		System.out.println("Method 9 -  Write a program to get file size in bytes, kb, mb.\n");
		try {
			long b = Files.size(path) % 1024;
			long mb = Files.size(path) / (1024*1024);
			long kb = Files.size(path) / 1024;
			System.out.println(" size is: " + mb + " Mb " + kb + " Kb " + b + " bytes .");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File does not exist");
		}
		printDelimiterLine();
		
		
		
	}
	
	public static void readFileToByteArray(Path path) {
		System.out.println("Method 10 -  Write a program to read contents from a file into byte array.\n");
		try {
		byte[] byteArray = Files.readAllBytes(path);
		System.out.println("The length of byte array is:" + byteArray.length);
		
		}catch(IOException e) {
			System.out.println("File does not exist");
		}
		printDelimiterLine();
	}
	
	public static void readAFileLineByLine(Path path) {
		System.out.println("Method 11 -  Write a program to read a file content line by line. \n");
		try {
		List<String> list = Files.readAllLines(path);
		System.out.println("the file has " + list.size() + " number of lines");
		
		}catch(IOException e) {
			System.out.println("The file does not exist");
		}
		printDelimiterLine();
		
	}
	
	public static void readPlainTextFile(Path path) {
		System.out.println("Method 12 -  Write a program to read a plain text file.  \n");
		try(BufferedReader br = Files.newBufferedReader(path)){
			int character;
			int countCharacters = 0;
			while((character = br.read()) != -1) {
				countCharacters++;
			}
			System.out.println("the text file has " + countCharacters + " number of characters");
			
		}catch(IOException e) {
			System.out.println("The file could not be oppened");
		}
		printDelimiterLine();
	}
	
	public static void storeLinesOfTesxtInAnArray(Path path) {
		System.out.println("Method 14 -  Write a program to store text file content line by line into an array.\n");
		try {
			List<String> list = Files.readAllLines(path);
			String[] arrayOfLines = list.toArray(new String[0]);
			System.out.println("the file has " + arrayOfLines.length + " number of lines");
		}catch(IOException e) {
			System.out.println("the file can not be oppened");
		}
		printDelimiterLine();
	}
	
	public static void writeAndReadAPlainTextFile(Path readFrom, Path writeTo) {
		System.out.println("Method 15 -  Write a program to store text file content line by line into an array.\n");

		try (FileReader fr = new FileReader(readFrom.toFile()); FileWriter fw = new FileWriter (writeTo.toFile(),false)){
			int charRead;
			while((charRead = fr.read()) != -1) {
				fw.write(charRead);
				
			}
			System.out.println("Read from \"History_of_Java.txt\" and write to\"filewritten.txt\"");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		printDelimiterLine();
			
		
	}

	
	public static void appendTextToExistingFile(Path path, String text) {
		System.out.println("Method 16 -  Write a program to append text to an existing file.\n");

		try (BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.APPEND)){
			bw.write(text);
			System.out.println("\"" + text + "\" was appended to " + path.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printDelimiterLine();
		
	}
	
	public static void readThreeLines(Path path) {
		System.out.println("Method 17 -  Write a program to read first 3 lines from a file.\n");
		
		try(BufferedReader br = Files.newBufferedReader(path)){
			String line;
			ArrayList<String> textRead= new ArrayList<>();
			for (int i = 0; i <3; i++) {
				line = br.readLine();
				textRead.add(line);
			}
			System.out.println(textRead.size() + " lines read from file " + path.toString());
			
		} catch (IOException e){
			e.printStackTrace();
		}
		printDelimiterLine();
		
	}
	
	
	public static void findMostUsedWord(Path path) {
		System.out.println("Method 19 -  Write a program to extract all the words (only) from a text file and sort them by number of occurrences in the file.\n");
		
		try(Scanner sc = new Scanner(path)){
			int count = 0;
			String word;
			Map<String, Integer> map = new HashMap<>();
			
			while(sc.hasNext()) {
				word = sc.next().toLowerCase().replaceAll("[^A-Za-z]+", "");
				if(word.length() > 0) {
				map.computeIfPresent(word, (k,v) -> map.get(k) + 1);
				map.computeIfAbsent(word, k -> 1);
				}
			}
			
			List<Entry<String,Integer>> list1 = new ArrayList<>();
			list1.addAll(map.entrySet());
			list1.sort((a,b) -> b.getValue().compareTo(a.getValue()));
			list1.stream().limit(5)
						.forEach(System.out::println);
			
			/*Stream<Map.Entry<String,Integer>> stream = map.entrySet().stream()
					.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
			
			List<Entry<String,Integer>> list = stream.collect(Collectors.toList());
			list.forEach(System.out::println);*/
			
		//	Map.Entry<String, Integer> mostUsedWord = stream.max(Map.Entry.comparingByValue()).get();
		//	System.out.println("The most frequent word in the document is: " + mostUsedWord.getKey() + " which appears " + mostUsedWord.getValue() + " times" );
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		printDelimiterLine();
	}
	
	public static String findLongestWord(Path path) {
		System.out.println("Method 18 -  Write a program to find the longest word in a text file. \n");
		String currentWord;
		String longestWord = "";
		int maxLength = 0;
		
		try(Scanner sc = new Scanner(path)){
			while(sc.hasNext()) {
				currentWord = sc.next().replaceAll("[^A-Za-z]+", "");
				if(currentWord.length() > maxLength) {
					maxLength = currentWord.length();
					longestWord = currentWord;
				}
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(longestWord);
		printDelimiterLine();
		return longestWord;
		
		
	}
	private static void printDelimiterLine() {
		String linebreaker = new String(new char[100]).replace('\0', '-');
		System.out.println(linebreaker);
	}
	

}
