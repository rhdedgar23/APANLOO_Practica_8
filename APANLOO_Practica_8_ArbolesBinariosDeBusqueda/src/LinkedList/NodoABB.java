package LinkedList;

public class NodoABB {

	int dato;
	NodoABB izq;
	NodoABB der;
	
	public NodoABB(int dato, NodoABB izq, NodoABB der) {
		this.dato= dato;
		this.izq= izq;
		this.der= der;
	}
	
	public NodoABB(int dato) {
		this.dato= dato;
	}
}
