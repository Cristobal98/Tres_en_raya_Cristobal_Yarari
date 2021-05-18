import java.util.Scanner;
import java.util.Arrays;

public class Tres_en_raya {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nombre del Jugador 1:");
		String nombre1 = sc.nextLine();
		System.out.println("Nombre del Jugador 2:");
		String nombre2 = sc.nextLine();
		//TIRAR DADOS
		int resultado1 = (int)(Math.random()*6 + 1);
		System.out.println(nombre1 + " ha sacado: " + resultado1);
		int resultado2 = (int)(Math.random()*6 + 1);
		System.out.println(nombre2 + " ha sacado: " + resultado2);
		if (resultado1 == resultado2) {
			System.out.println("EMPATE! DESEMPATA: " + nombre1);
			resultado1 = (int)(Math.random()*6 + 1);
			System.out.println(nombre1 + " ha sacado: " + resultado1);
		}
		//CREAR TABLERO
		String [][] tablero =  crearTablero();
		
		mostrar(tablero);
		
		String jugador1 = "";
		String jugador2 = "";
		
		//COMPROBAR QUIEN HA SACADO NUM MAS ALTO
		
		if (resultado1 > resultado2) {
			jugador1 = nombre1;
			jugador2 = nombre2;
			System.out.println("");
			System.out.println("EMPIEZA " + nombre1 + " JUGANDO");
			System.out.println("");
		} else {
			jugador1 = nombre2;
			jugador2 = nombre1;
			System.out.println("");
			System.out.println("EMPIEZA " + nombre2 + " JUGANDO");
			System.out.println("");
		}
		
		boolean ganar = false;
		int numero = 1;
		
		//EMPEZAR A JUGAR HASTA QUE UNO GANE 
		
		while(ganar == false) {
			
			//COMPROBANDO QUE JUGADOR JUEGA, IMPAR JUGADOR 1 Y PAR JUGADOR 2
			
			if (numero%2!=0) {
				
				//JUGADOR1
			
				tablero = juega(jugador1, "X", tablero);
				
				//MOSTRAR TABLERO
				
				mostrar(tablero);
				
				//COMPROBAR TRES EN RAYA
				
				ganar = comprobar(tablero);
				if (ganar == true) {
					System.out.println("");
					System.out.println(jugador1 + " ha ganado!!");
				}
				if (empate(tablero) == false) {
					tablero = crearTablero();
					System.out.println("");
					System.out.println("EMPATE, VOLVED A EMPEZAR");
					System.out.println("");
					mostrar(tablero);
				}
				
				numero++;
				
			} else {
				
				//JUGADOR2
				
				tablero = juega(jugador2, "O", tablero);
				
				//MOSTRAR TABLERO
				
				mostrar(tablero);
				
				//COMPROBAR TRES EN RAYA
				
				ganar = comprobar(tablero);
				if (ganar == true) {
					System.out.println("");
					System.out.println(jugador2 + " ha ganado!!");
				}
				if (empate(tablero) == false) {
					tablero = crearTablero();
					System.out.println("");
					System.out.println("EMPATE, VOLVED A EMPEZAR");
					System.out.println("");
					mostrar(tablero);
				}
				
				numero++;
				
			}
		}		
	}
	
	//SI HAY EMPATE
	
	public static boolean empate(String [][] tablero) {
		boolean comprobacion = false;
		int i = 1;
		int u = 1;
		while (i <= 3) {
			while (u <= 3) {
				if (tablero[i][u].equals("-")) {
					comprobacion = true;
				}
				u++;
			}
			i++;
			u = 1;
		}
		return comprobacion;
	}
	
	//COMPROBAR VICTORIA
	
	public static boolean comprobar(String [][] tablero) {
		boolean ganar = false;
		if (!tablero[1][1].equals("-") && tablero[1][1] == tablero [2][2] && tablero[1][1] == tablero [3][3]) {
			ganar = true;
		} else if (!tablero[3][1].equals("-") && tablero[3][1] == tablero [2][2] && tablero[3][1] == tablero [1][3]){
			ganar = true;
		} else if (!tablero[1][1].equals("-") && tablero[1][1] == tablero [2][1] && tablero[1][1] == tablero [3][1]){
			ganar = true;
		} else if (!tablero[1][2].equals("-") && tablero[1][2] == tablero [2][2] && tablero[1][2] == tablero [3][2]){
			ganar = true;
		} else if (!tablero[1][3].equals("-") && tablero[1][3] == tablero [2][3] && tablero[1][3] == tablero [3][3]){
			ganar = true;
		} else if (!tablero[1][1].equals("-") && tablero[1][1] == tablero [1][2] && tablero[1][1] == tablero [1][3]){
			ganar = true;
		} else if (!tablero[2][1].equals("-") && tablero[2][1] == tablero [2][2] && tablero[2][1] == tablero [2][3]){
			ganar = true;
		} else if (!tablero[3][1].equals("-") && tablero[3][1] == tablero [3][2] && tablero[3][1] == tablero [3][3]){
			ganar = true;
		}
		
		return ganar;
	}
	
	//MOVIMIENTO EN EL TABLERO
	
	public static String [][]  juega(String nombre, String forma, String[][] tablero) {
		Scanner scn = new Scanner(System.in);
		System.out.println("");
		System.out.println(nombre + " dime la fila (A, B o C)");
		String fila1 = scn.nextLine();
		int filA1 = 0;
		if (fila1.equals("A")) {
			filA1 = 1;
		} else if (fila1.equals("B")) {
			filA1 = 2;
		} else {
			filA1 = 3;
		}
		System.out.println(nombre + " dime la columna (1, 2 o 3)");
		int columna1 = scn.nextInt();
		for (int i = 0;i<tablero.length;i++) {
			for (int u = 0;u<tablero[0].length;u++) {
				tablero[filA1][columna1] = forma;
			}
		}
		
		return tablero;
	}
	
	//MOSTRAR TABLERO
	
	public static void  mostrar(String[][] tablero) {
		for (int i = 0;i<tablero.length;i++) {
			System.out.println("");
			System.out.println(Arrays.toString(tablero[i]));
		}
	}
	
	//CREAR TABLERO
	
	public static String [][] crearTablero(){
		String[][] tablero = new String[4][4];
			for (int i = 0;i<tablero.length;i++) {
				for (int u = 0;u<tablero[0].length;u++) {
					tablero[i][u] = "-";
					tablero[0][0] = " ";
				}
			}
			int c = 1;
			int d = 1;
			String letra = "";
			String num = "";
			for (int i = 1;i<tablero.length;i++) {
				for (int u = 1;u<tablero[1].length;u++) {
					if (c == 1) {
						letra = "A";
					} else if (c == 2) {
						letra = "B";
					} else {
						letra = "C";
					}
					tablero[c][0] = letra;
				}
				c++;
			}
			
			for (int i = 1;i<tablero.length;i++) {
				for (int u = 1;u<tablero[1].length;u++) {
					if (d == 1) {
						num = "1";
					} else if (d == 2) {
						num = "2";
					} else {
						num = "3";
					}
					tablero[0][d] = num;
				}
				d++;
			}
			
		return tablero;
	}
}
