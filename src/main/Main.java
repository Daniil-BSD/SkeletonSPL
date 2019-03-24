package main;

import java.io.*;
import java.security.InvalidParameterException;

import gameLogic.ConsoleInterpreter;
import gameLogic.Station;

/**
 * 
 */

/**
 * @author Daniil Besedin
 * The main class that executes the game.
 */
public class Main {

	/**
	 * Attribute that tells us if the game is running.
	 */
	
	public static volatile boolean run = true;
	
	 /**
     * This method is where the game runs.
     */

	public static void main(String[] args) {
		run = true;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Input thecommands:");
		while (run) {
			try {
				ConsoleInterpreter.ConsoleLine( br.readLine());
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("Application Terminated.");
	}

}
