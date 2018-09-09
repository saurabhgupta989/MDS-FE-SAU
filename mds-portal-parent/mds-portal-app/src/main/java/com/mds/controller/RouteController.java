package com.mds.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mds.service.RouteService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController(value = "api")
public class RouteController {

	@Autowired
	private RouteService routeService;

	@GetMapping(value = "/fe/test", produces = "application/json")
	public ResponseEntity<Object> index() {
		Map<String, List<Integer>> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		map.put("feName", list);
		ResponseEntity<Object> response = null;
		response = new ResponseEntity<Object>(map, HttpStatus.OK);
		return response;
	}

	@GetMapping(value = "/get/*", produces = "application/json")
	public ResponseEntity<Object> handleGetRequests() {

		routeService.handleGetRequests();
		ResponseEntity<Object> response = null;
		response = new ResponseEntity<Object>(null, HttpStatus.OK);
		return response;
	}

	@GetMapping(value = "/post/*", produces = "application/json")
	public ResponseEntity<Object> handlePostRequests() {
		Map<String, List<Integer>> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		map.put("feName", list);
		ResponseEntity<Object> response = null;
		response = new ResponseEntity<Object>(map, HttpStatus.OK);
		return response;
	}

	public String demo(List<Integer> andrea, List<Integer> maria, String s) {
		List<Integer> andreaScore = new ArrayList<>();
		List<Integer> mariaScore = new ArrayList<>();
		if (s.equals("EVEN")) {
			for (int i = 0; i < andrea.size(); i++) {
				if (i % 2 == 0) {
					andreaScore.add(andrea.get(i));
					mariaScore.add(andrea.get(i));
				}
			}

			Integer scoreOfAndrea = 0, scoreOfMaria = 0;
			for (int i = 0; i < andreaScore.size(); i++) {
				scoreOfAndrea = scoreOfAndrea + andreaScore.get(i);
				scoreOfMaria = scoreOfMaria + mariaScore.get(i);
			}
			if ((scoreOfAndrea - scoreOfMaria) > (scoreOfMaria - scoreOfAndrea)) {
				return "Andrea";
			} else {
				return "Maris";
			}

		} else if (s.equals("ODD")) {

		}

		return null;
	}

	public Integer max(int[] rating) {
		int posNumner = 0;
		int[] myArray = new int[rating.length];
		int j = 0;
		for (int i = 0; i < rating.length; i++) {
			if (rating[i] > 0) {
				posNumner = posNumner + rating[i];
			} else {
				myArray[j] = rating[i];
			}
		}
		int[] index = new int[rating.length];
		Arrays.sort(myArray);
		for (int i = 0; i < myArray.length; i++) {
			index[i] = this.getArrayIndex(rating, myArray[i]);
		}

		int max = Arrays.stream(index).max().getAsInt();
		int[] sum = new int[index.length];
		int temp = 0;
		for (int i = 0; i < index.length; i++) {
			for (int k = index[i]; k <= max; k++) {

				temp = temp + myArray[k];

			}
		}

		return null;
	}

	public int getArrayIndex(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == value)
				return i;
		return -1;
	}

}
