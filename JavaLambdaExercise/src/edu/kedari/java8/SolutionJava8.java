package edu.kedari.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.kedari.java7.Condition;
import edu.kedari.model.Person;

public class SolutionJava8 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("abhijeet","Kedari", 28),
				new Person("abhishek","Kedari", 29),
				new Person("Ranjana","Raskar", 50),
				new Person("dattatray","Kedari", 53),
				new Person("Sagar","Dhanave", 28)
				);
		
		//Step 1: sort list by last name
		Collections.sort(people, ( p1, p2) -> p1.getLastName().compareTo(p2.getLastName()) );
		
		//Step 2: print all people
		printAll(people);
		
		//Step 3: print all people whose first name start with "a"
		System.out.println("\nPrint all people whose first name start with  \"a\"  ");
		printAllWithCondition(people, p -> p.getFirstName().startsWith("a"));

		//Step 4: print all people whose last name start with "R"
		System.out.println("\nPrint all people whose first name start with  \"R\"  ");
		printAllWithCondition(people, p -> p.getLastName().startsWith("R"));
		
		//Step 5: print all printAllWithCondition where condition will be always true
		System.out.println("\nPrint all people ");
		printAllWithCondition(people, p->true);
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
