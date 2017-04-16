package main;
import java.util.Scanner;
import models.*;


public class Prueba_Cola {

	private static miCola<String> cola;
	public static void main(String[] args) {
		
		int opcion = 0;	
		boolean error = false;
		cola= new miCola<String>();
		
		do {
			
			try{
			opcion = mostrarMenu();
			realizarOpcion(opcion);
			error = false;
			}catch(Exception e){
			 System.out.println("Dato introducido no válido !");
			 error = true;
			 }
			} while (opcion != 9 || error);
		
		
	}
	
	public static int mostrarMenu(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("+++ SELECCIONE UNA OPCIÓN DEL MENÚ : +++");
		System.out.println("1. Ver Tamaño de la Cola");
		System.out.println("2. Añadir elemento a la Cola");
		System.out.println("3. Extraer último elemento de la Cola");
		System.out.println("4. Quitar un elemento de la Cola");
		System.out.println("5. Comprobar si existe un elemento en la Cola");
		System.out.println("6. Limpiar Cola / Borrado de todos los elementos de la Cola");
		System.out.println("7. Comprobar si la Cola esta vacía o contiene algún elemento");
		System.out.println("8. Listar elementos de la Cola");
		System.out.println("9. Salir");
		
		return sc.nextInt();
		
	}
	public static void realizarOpcion(int opcion) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		
		switch (opcion) {
		case 1:
			System.out.println("El Tamaño de la Cola es :"+cola.size());
			break;
		case 2:
			System.out.println("Introduzca un elemento a la Cola :");									
			cola.push(sc.next());
			break;
		case 3:
			if(cola.isEmpty()){
				System.out.println("No hay ningún elemento que extraer de la Cola");
			}else{
			cola.pop();
			}
			break;
		case 4:
			System.out.println("Introduzca un elemento que desea retirar de la Cola :");
			cola.remove(sc.next());
			break;
		case 5:
			System.out.println("Introduzca un elemento que desea comprobar si existe en la Cola :");
			if(cola.contains(sc.next())){
				System.out.println("El elemento introducido existe en la Cola");
			}else{
				System.out.println("El elemento introducido No existe en la Cola");
			}
			break;
		case 6:
			cola.clear();
			System.out.println("Se han borrado todos los elementos de la Cola");
			cola= new miCola<String>();															//Dejamos el Array con tamaño nulo
			break;
		case 7:
			if( cola.isEmpty()){
				System.out.println("La Cola está vacía  ");
			}else{
				System.out.println("La Cola contiene algún elemento");
			}
			break;
		case 8:
			if( cola.isEmpty()){
				System.out.println("La Cola está vacía  ");
			}else{
			cola.display();
			}
			break;
		case 9:
			System.out.println("Que tenga un Feliz Día !");
			break;
		default:
			System.out.println("[ERROR] Opción no válida.");
			break;	
		}				
	}
}
