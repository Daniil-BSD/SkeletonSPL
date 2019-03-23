package main;

import java.io.*;
import java.security.InvalidParameterException;

/**
 * 
 */

/**
 * @author Daniil Besedin
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	public static volatile boolean run = true;
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
