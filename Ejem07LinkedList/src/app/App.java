package app;

import linkedList.linkedList;
import node.node;

public class App {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedList<String> names    = new linkedList<String>();
		linkedList<String>lastnames = new linkedList<String>();
		linkedList<Integer>ages     = new linkedList<Integer>(19);
		
		names.addStart("Ana");
		names.addStart("Ricardo");
		names.addEnd("Jose Arturo");
		names.addStart("Manuel");
		names.addStart("Esteban");
		names.addStart("Eduardo");
		names.addStart("Fernando");
		names.addEnd("Alejandro");
		names.addEnd("Ramon");
		names.addBefore("Jose Arturo","Esteban");
		names.pronter();
		
		System.out.println("--------- Remove Before (Ricardo) ---------");
		names.removeBefore("Ricardo");
		names.pronter();
		
		System.out.println("--------- Remove After(Jose Arturo) ---------");
		names.removeAfter("Jose Arturo");
		names.pronter();
		
		System.out.println("--------- Get Last ---------");
		names.getLast();
		
		System.out.println("--------- Index Of ---------");
		node<String> persona = names.indexof("Esteban");
		if (persona!=null)
			System.out.println("La posicion de "+persona.getValue()+" es: "+persona.getIndex());
		
		System.out.println("--------- ¿Is Empy? ---------");
		System.out.println(names.isEmpy());
		
		System.out.println("--------- ReIndex ---------");
		names.pronter();
		names.pronterIndex();
		
		System.out.println("--------- Size ---------");
		System.out.println("Size: "+names.size());
		
		System.out.println("--------- Replace ---------");
		System.out.println("Remplazar Ana");
		names.replace("Ana", "Tiburcio");
		names.pronter();
		
		System.out.println("--------- Remove First ---------");
		names.removeFirst();
		names.pronter();
		
		System.out.println("--------- Remove Last ---------");
		names.removela();
		names.pronter();
		
		System.out.println("--------- Get First ---------");
		names.getFirst();
		
		System.out.println("--------- Iterator ---------");
		names.list();
		
		System.out.println("--------- Clear ---------");
		names.clear();
		names.pronter();
		System.out.println(names.isEmpy());
		
		
	}
}