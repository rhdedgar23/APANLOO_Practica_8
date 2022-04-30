package ArbolBinarioDeBusqueda;

import java.util.LinkedList;

public class Queue <Tipo> {

	LinkedList<Tipo> fila;
	
	public Queue() {
		this.fila= new LinkedList<Tipo>();
	}
	
	public void enQueue(Tipo dato) {
		this.fila.add(dato);
	}
	
	public void deQueue() {
		this.fila.remove();
	}
	
	public Tipo valorFrente() {
		return this.fila.getFirst();
	}
	
	public boolean esVacia() {
		
		if(this.fila.isEmpty()==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void hazNula() {
		this.fila.clear();
	}
	
	public String despliega() {
		
		String pilaString="";
		
		for(int i=0; i<fila.size(); i++) {
			pilaString= pilaString + fila.get(i) + ", ";
		}
		
		return pilaString;
	}
	
	public int size() {
		return this.fila.size();
	}
}
