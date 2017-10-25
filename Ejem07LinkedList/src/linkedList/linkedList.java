package linkedList;
import java.awt.print.PrinterAbortException;
import java.util.ArrayList;

import node.node;
public class linkedList<T> {
	private node<T> sentinel=null;
	
	public linkedList(){
		sentinel = new node<T>();
		sentinel.setIndex(-1);	
	}
	public linkedList(T value) {
		this();
		node<T> tmp = new node<T>(value);
		tmp.setIndex(0);
		sentinel.setNext(tmp);
	}
	//agregar un nuevo nodo al inicio 
	public void addStart(T value) {
		node<T> tmp  = sentinel.getNext();
		node<T> _new = new node<T>(value);
		_new.setNext(tmp);
		sentinel.setNext(_new);	
	}
	// agregar un nuevo nodo al final <void>
	public void addEnd(T value) {
		node<T>tmp =sentinel;
		while (tmp.getNext()!=null) 
			tmp = tmp.getNext();
		tmp.setNext(new node<T>(value));
		
	}
	//remover un nodo obteniendo un valor iterativo return boolean
	public boolean remove (T value) {
		node<T> tmp= sentinel;
		while (tmp.getNext()!=null)
		{
			if (tmp.getNext().getValue().equals(value))
			{
				tmp.setNext(tmp.getNext().getNext());
				return true;
			}else
			{
				tmp=tmp.getNext();
			}
		}
	return false;
	}
	public String isEmpy()
	{
		if (sentinel.getNext()==null)return "Lista vacia";
		else return "la lista no esta vacia";
		
	}
	//remover un nodo obteniendo un valor <recursivo>
	public boolean remover(T value)
	{
		return remover(value,sentinel);
	}
   private boolean remover (T value, node<T> lista){
		if (lista.getNext()==null)
		return false;
		if(lista.getNext().getValue().equals(value)) {
			lista.setNext(lista.getNext().getNext());
			return true;}
		return remover(value, lista.getNext());
	}
   //eliminar un nodo iterativo, que returne el nodo eliminado
	public node <T> remmove (T value) {
		node<T> tmp= sentinel;
		while (tmp.getNext()!=null)
		{
			if (tmp.getNext().getValue().equals(value))
			{
				tmp.setNext(tmp.getNext().getNext());
				return tmp;
			}else
			{
				tmp=tmp.getNext();
			}
		}
	return null;
	}
	//buscar indexof de un nodo
	public node<T> indexof(T value)
	{
		reindex();
		return indexof(value,sentinel);
	}
	public node<T> indexof(T value, node<T> lista)
	{
		reindex();
		if (lista.getNext()==null)return null;
		if(lista.getNext().getValue().equals(value))return lista.getNext(); 
		return indexof(value, lista.getNext());
	}
	//buscar un nodo en la lista con un valor
	public node<T> search(T value)
	{
		return search(value,sentinel);
	}
	public node<T> search(T value, node<T> lista)
	{
		if (lista.getNext()==null)return null;
		if(lista.getNext().getValue().equals(value))return lista.getNext(); 
		return search(value, lista.getNext());
	}
	public boolean buuscar(T value, node<T> lista)
	{
		if (lista.getNext()==null)return false;
		if(lista.getNext().getValue().equals(value))return true; 
		return buuscar(value, lista.getNext());
	}
	private void reindex() {
		int aux=1;
		node<T> tmp = sentinel;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			tmp.setIndex(aux);
			aux++;
		}
		System.gc();
	}
	public void printer() {
		printer(sentinel);
	}
	public void pronter() {
		node<T> tmp = sentinel;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			System.out.println(tmp.getValue());
		}
		System.gc();
	}
	public void pronterIndex() {
		reindex();
		node<T> tmp = sentinel;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			System.out.println(tmp.getIndex());
		}
		System.gc();
	}
	private void printer(node<T> tmp) {
		if (tmp.getNext()== null)
			return;
		else{
			System.out.println(tmp.getNext().getValue());
		    printer(tmp.getNext());
		}
		System.gc();
	}
	public boolean addLast(T value, T newvalue)
	{
		node<T> finder =search(value);
		if(finder!=null)
			return addLast (new node<T>(newvalue),finder);
		else
			return false;
	}
	public boolean addLast(T value, node<T> nodo) {
		node<T> finder =search(value);
		if(finder!=null)
			return addLast (nodo,finder);
		else
			return false;
	}
	public boolean addLast(node<T> nodo, node<T> lista)
	{
		nodo.setNext(lista.getNext());
		lista.setNext(nodo);
		return true;		
	}
	public boolean addBefore(T value, T newvalue)
	{
		node<T>tmp =sentinel;
		while (tmp.getNext()!=null  && !tmp.getNext().getValue().equals(value)) 
		{
			tmp = tmp.getNext();
		}
		return (tmp!=null)?addLast(new node<T>(newvalue),tmp):false;
	}
	public boolean removeAfter(T value)
	{
		node<T>tmp =sentinel;
		while (tmp.getNext()!=null) 
		{
			if (tmp.getNext().getValue().equals(value))
			{
				tmp=tmp.getNext();
				if(tmp.getNext()!=null && tmp.getNext().getNext()!=null) 
					{
					tmp.setNext(tmp.getNext().getNext());
					return true;
					}
				else 
				{
					tmp.setNext(null);
					return true;
				}
			}else tmp=tmp.getNext();
		}
	return false;
	}
	public node<T> getLast() {
		node<T> tmp = sentinel;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
		}
		System.gc();
		System.out.println("El ultimo valor de la lista es: "+tmp.getValue());
		return tmp;
	}
	public boolean removeBefore(T value)
	{
		node<T>tmp =sentinel;
		while (tmp.getNext()!=null) 
		{
			if(tmp.getNext()==sentinel.getNext() && tmp.getNext().getNext().getValue().equals(value))
			{
				System.out.println("Entro al else if ");
				sentinel.setNext(tmp.getNext().getNext());
				return true;
			}
			else if(tmp.getNext().getNext().getValue().equals(value) && tmp.getNext()!=sentinel.getNext()) {
				System.out.println("Entro al if");
				tmp.setNext(tmp.getNext().getNext());
				return true;
			}
			tmp=tmp.getNext();
		}
		return false;
	}
	public void removeLast()
	{
		node<T> tmp = sentinel;
		while (tmp.getNext()!=null) {
			
			if(tmp.getNext().getNext()==null)
				{
				tmp = tmp.getNext();
				tmp.setNext(null);
				}
			tmp = tmp.getNext();
		}
	}
	public int size()
	{
		int size = 0;
		node<T> tmp = sentinel;
		while(tmp.getNext() != null){
		     tmp = tmp.getNext();
		     size++;     
		   }
		return size;
	}
public void replace(T viejo, T nuevo) {
		
		if (search(viejo)==(null))
		{
			System.out.println("Error No Encontro Numero");
		}
		else
		{
			search(viejo).setValue(nuevo);
		}
	}
	public void removeFirst()
	{
		node<T> tmp = sentinel;
		if(tmp != null)
		{
			tmp.setNext(tmp.getNext().getNext());
		}
	}

	public void removela()
	{
		node<T> tmp = sentinel;
		while(tmp.getNext() != null)
		{
			tmp = tmp.getNext();
			if(tmp.getNext().getNext() == null) 
			{
				tmp.setNext(tmp.getNext().getNext());
			}
			
		}
	}
	public void getFirst()
	{
		node<T> tmp = sentinel;
		if(sentinel.getNext()!=null)
			System.out.println(tmp.getNext().getValue());
	}
	public void clear()
	{
		node<T> tmp = sentinel;
		if(tmp.getNext() != null) tmp.setNext(null);
		System.gc();
	}
	public void list()
	{
		node<T> tmp=sentinel;
		ArrayList<String> iterador = new ArrayList<>();
		while(tmp.getNext()!=null)
		{
			tmp=tmp.getNext();
			iterador.add((String) tmp.getValue());
		}
		for(String x: iterador)
		{
			System.out.println(x);
		}
		
	}
}