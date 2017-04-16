package edu.kedari.java7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.kedari.model.Person;

public class SolutionInJava7 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("abhijeet","Kedari", 28),
				new Person("abhishek","Kedari", 29),
				new Person("Ranjana","Raskar", 50),
				new Person("dattatray","Kedari", 53),
				new Person("Sagar","Dhanave", 28)
				);
		
		//Step 1: sort list by last name
		Collections.sort(people, new Comparator<Person>(){

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
			});
		
		
		//Step 2: print all people
		printAll(people);
		
		
		
		//Step 3: print all people whose first name start with "a"
		System.out.println("\nPrint all people whose first name start with  \"a\"  ");
		printAllWithCondition(people, new Condition(){

			@Override
			public boolean test(Person p) {
				return p.getFirstName().startsWith("a"); 
			}
			
		});
		
	} 

	private static void printAllWithCondition(List<Person> people, Condition condition) {
		for(Person p:people){
			if(condition.test(p))
				System.out.println(p);
		}
		
	}

	private static void printAll(List<Person> people) {
		
		for(Person p:people){
			System.out.println(p);
		}
		
		
	}

}
