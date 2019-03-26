package TestMvnArtifactExo42;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.QualifiedNameable;

import exception.ExceptionNombreOperandesEgaleUn;
import exception.ExceptionNombreOperandesEgaleZero;

public class Interpreteur {
	private final Map<String, Commande> commande ;
	
	public Interpreteur()
	{
		this.commande = new HashMap<>();
	}
	
	public void addCommande(String t, Commande cmd)
	{
		this.commande.put(t, cmd);
	}
	
	public void init()
	{
		Commande quit = new CommandeQuit();
		Commande undo = new CommandeUndo();
		this.addCommande("quit", quit);
		this.addCommande("undo", undo);
	}
	/*public void executeCommande(MoteurRPN moteurRPN, String t) throws ExceptionNombreOperandesEgaleZero
	{
		if(this.commande.containsKey(t))
		{
			this.commande.get(t).execute(moteurRPN);
		}
		else 
		{
			System.out.println("La commande n'existe pas");
		}
	}*/
}
