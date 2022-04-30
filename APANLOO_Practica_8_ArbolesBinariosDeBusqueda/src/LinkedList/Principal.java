package LinkedList;

public class Principal {

	static Queue<Integer> numeros;
	static Queue<NodoABB> arboles;
	
	public static void main(String[] args) {
		
		numeros= new Queue<>();
			
		//se inicializa la fila de numeros con los datos: limites inferior, superior y los intervalos entre numeros (i.e. de 2 en 2)
		inicializaNumeros(0, 100, 10);
		//desplegamos la pila de numeros
		System.out.println("La fila de numeros en orden de ingreso es: \n" + numeros.despliega());
		//se sacan con patron FIFO 
		System.out.println("\nLa fila de numeros en orden de egreso es: \n" + numeros.despliega());
			
		//tenemos a nuestro arbol ejemplo
		//---Arbol---
		NodoABB raiz= new NodoABB(1);
			
		raiz.izq= new NodoABB(2);
			
		raiz.izq.izq= new NodoABB(3);
		raiz.izq.der= new NodoABB(4);
			
		raiz.izq.der.izq= new NodoABB(5);
		raiz.izq.der.der= new NodoABB(6);
		
		//recorremos este arbol mediante los 4 tipos de recorrido
		System.out.println("\nEl arbol ejemplo recorrido en: ");
		System.out.print("Preorden: ");
		Recorridos.preorden(raiz);
		System.out.print("\nOrden: ");
		Recorridos.orden(raiz);
		System.out.print("\nPostorden: ");
		Recorridos.postorden(raiz);
		System.out.print("\nNivel (Anchura): ");
		Recorridos.nivel(raiz);
	}
		
	public static void inicializaNumeros(int valorInf, int valorSup, int intervalo) {
			
		for(int i=valorInf; i<=valorSup; i=i+intervalo) {
			numeros.enQueue(i);
		}
	}
}
