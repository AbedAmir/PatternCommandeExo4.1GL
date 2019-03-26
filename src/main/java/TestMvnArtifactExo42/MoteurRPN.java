package TestMvnArtifactExo42;

import java.util.ArrayList;

import exception.ExceptionNombreOperandesEgaleUn;
import exception.ExceptionNombreOperandesEgaleZero;

public class MoteurRPN extends Interpreteur{
private final ArrayList<Float> commande = new ArrayList<>();
	
	
	public void quit()
	{
		System.exit(0);
	}

	public ArrayList<Float> getCommande() {
		return this.commande;
	}
	
	public void affichageAllOperande()
	{
		System.out.print("Ma pile = {");
		for (Float float1 : commande) {
			System.out.print(this.commande.get(this.commande.size()-1) + ",");
		}
		System.out.println("}");
	}
	
	public void ajouterOperande(Float f)
	{
		this.commande.add(f);
	}
	
	public void calculerOperation(Operation op) throws ExceptionNombreOperandesEgaleUn, ExceptionNombreOperandesEgaleZero
	{
		int size;
		float x,y,z;
		if(commande.size()>=2)
		{
			size=commande.size();
			x = this.commande.remove(size-1);
			y = this.commande.remove(size-2);
			z = op.eval(x, y);
			ajouterOperande(z);
			//this.addOperande(op.eval(x, y));
			System.out.println(x+" "+op+" "+y+" = "+z);
			//return op.eval(x, y);
		}
		else if(commande.size()==1)
		{
			throw new ExceptionNombreOperandesEgaleUn();
			//throw new Exception("Vous devez entrez au moins 1 operande supp --> La pile contient une seule operande");
		}
		else 
		{
			throw new ExceptionNombreOperandesEgaleZero();
			//throw new Exception("Vous devez entrez au moins 2 operandes sup --> La pile contient ne contient pas d'operande");
		}
	}
}
