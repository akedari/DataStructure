package edu.kedari.exception;

import java.util.function.BiConsumer;

public class ExceptionhandlingExample {

	public static void main(String[] arg){
		int[] numbers = {1,2,3,4,5};
		int key =0;
		
//		process(numbers, key, (v,k)->System.out.println(v+k));
		
		
		process(numbers,key, wrapper((v,k)->System.out.println(v/k)));
		
	}

	private static BiConsumer<Integer, Integer> wrapper(BiConsumer<Integer, Integer> object) {
		return (v,k)->{
			try{
				object.accept(v, k);
			}
			catch(ArithmeticException ex){
				System.out.println("\n Arithmetic Exception !!!");
			}
		};
	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> object) {
		for(int n:numbers){
			object.accept(n, key);
		}
		
	}
	
}
