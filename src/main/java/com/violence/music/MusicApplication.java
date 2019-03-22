package com.violence.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class MusicApplication {

	private static String[] strings1 = {"1", "4", "6", "7", "10", "100", "125", "250"};
	private static String[] strings2 = {"1", "4", "8", "9", "10", "123", "125", "213"};
	private static String[] strings3 = {"7", "3", "5", "16", "10", "123", "211", "213"};
	private static String[] strings4 = {"3", "6", "9", "11", "12", "124", "125", "4"};

	//print list of 4 sorted maximum unique integer values to console.
	//Output result: [250,213,211,125]
	//Use only streams. Don't use loops.

	private static List<Integer> getMaximalUniqueIntegers(String[]...arrs){
		List<Integer> result = new LinkedList<>();
		List<List<Integer>> lists = new LinkedList<>();
		Arrays.stream(arrs).forEach(arr -> lists.add(Arrays.stream(arr).map(Integer::parseInt).sorted(Integer::compareTo).collect(Collectors.toList())));
		lists.forEach(integers ->
				integers.stream().peek(integer -> {
					if (!result.contains(integer))
						result.add(integer);
				}).findFirst());

		return result.stream().skip(result.size()-5).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
		List<Integer> list = getMaximalUniqueIntegers(strings1, strings2, strings3, strings4);
		System.out.println(list);
	}


}
