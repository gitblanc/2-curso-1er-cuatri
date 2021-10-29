package logica;

import java.io.PrintStream;
import java.util.Scanner;

public class Console {
	
	private static PrintStream out = System.out;
	private static Scanner keyboard = new Scanner(System.in);
	
	public static int readInteger(String msg) {
		out.println(msg + ": ");
		return keyboard.nextInt();
	}
	
	public static String readString(String msg) {
		out.println( msg + ": ");
		keyboard.useDelimiter( System.lineSeparator() );
		String res = keyboard.next();
		keyboard.reset();
		return res;
	}
	
	public static void printf(String fmt, Object... params) {
		out.printf( fmt, params );
	}

	public static float readFloat(String msg) {
		out.println(msg + ": ");
		return keyboard.nextFloat();
	}
}
