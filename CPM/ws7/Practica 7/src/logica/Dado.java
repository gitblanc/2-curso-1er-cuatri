package logica;

public class Dado {
	
	public static int lanzar(int maxDisparos)
	{ 
		return ((int) (Math.random() * maxDisparos) + 1);//devuelve un aleatorio entre 1 y 4
	}
}
