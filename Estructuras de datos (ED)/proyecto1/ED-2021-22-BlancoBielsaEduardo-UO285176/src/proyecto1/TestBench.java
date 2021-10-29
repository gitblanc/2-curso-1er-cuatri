/**
 * 
 */
package proyecto1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author blanc Esta clase contiene los métodos que evalúan el rendimiento de
 *         cualquier método
 */
public class TestBench {

	public static Object testAlgorithm(String className, String methodName, int n) { // n = carga a la que voy a
																						// someter
																						// al método
		Object obj;
		try {
			obj = Class.forName(className).getDeclaredConstructor().newInstance();
			Method method = obj.getClass().getMethod(methodName, int.class);
			return method.invoke(obj, n);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void test(String output, int startN, int endN, int times, String className, String methodName)
			throws IOException {
		FileWriter file = null;
		PrintWriter pw;

		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int workLoad = startN; workLoad < endN; workLoad++) {
				long startTime = System.currentTimeMillis();
				for (int time = 0; time < times; time++)
					testAlgorithm(className, methodName, workLoad);
				long finalTime = System.currentTimeMillis();

				pw.println(workLoad + ";" + ((finalTime - startTime) / times));
				System.out.println(workLoad + ";" + ((finalTime - startTime) / times));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				file.close();
			}
		}

	}

}
