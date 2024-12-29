package com.example.Kapok;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.graphql.data.method.annotation.Argument;

public record Donar(Integer Id, String fName, String lName, String Email, String Pwd) {
	public static List<Donar> donars = new ArrayList<>(List.of(
	        new Donar(1, "Prasad", "Adhiyaman", "prasad.adhi08@gmail.com", "sjfkshfjsd"),
	        new Donar(2, "hsajadhasjksd", "dshjahdjkasd", "dhjasdhasjkd", "fhejnsndj"),
	        new Donar(3, "adsajkdsad", "fnjedfnejn", "prasad.com", "ashdhuedn"),
	        new Donar(4, "sarasa", "eiinwind", "asdjasnj.com", "asdjemkxnv")
	    ));
	
	public static Optional<Donar> getdonarById(Integer id) {
        return donars.stream()
                .filter(b -> b.Id.equals(id))
                .findFirst();
    }
	
	public static boolean addDonar(Integer id, String fName, String lName, String Email, String Pwd)
	{
		try {
			donars.add(new Donar(id, fName, lName, Email, Pwd));
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
