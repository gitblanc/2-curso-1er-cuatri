package logica;

public class Dado {
	
	public static int lanzar()
	{ 
		return ((int) (Math.random() * Juego.maxDisparos) + 1);//devuelve un aleatorio entre 1 y 4
	}
}
