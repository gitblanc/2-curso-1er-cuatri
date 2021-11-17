/**
 * 
 */
package player;

import java.io.File;

/**
 * @author blanc
 *
 */
public class MyFile {
	private File f;
	
	public MyFile (File f){
		this.f = f;
	}
	
	public File getF() {
		return f;
	}

	public String toString() {
		return f.getName();
	}
}
