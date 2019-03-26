package TestMvnArtifactExo42;
import java.util.Scanner;

import exception.ExceptionEntreeIncorrect;
import exception.ExceptionIntervalInferieur;
import exception.ExceptionIntervalSuperieur;
import exception.ExceptionNombreOperandesEgaleUn;
import exception.ExceptionNombreOperandesEgaleZero;

/**
 * @author Amir
 *
 */
public class SaisieRPN {
	int MAX_VALUE=Integer.MAX_VALUE;
	int MIN_VALUE=Integer.MIN_VALUE;
	public boolean continu;
	Scanner sc = new Scanner(System.in);
	int monNombre;
	String monOperateur,monInsert;

	/** Ce constructeur va nous servir uniquement instancier la classe et a tester les methodes de la classe
	 * @param a
	 */
	public SaisieRPN(int a)
	{

	}
	/** Interaction avec le user
	 * @throws ExceptionEntreeIncorrect
	 * @throws ExceptionNombreOperandesEgaleUn 
	 * @throws ExceptionNombreOperandesEgaleZero 
	 * @throws Exception
	 */
	public SaisieRPN() throws ExceptionEntreeIncorrect,ExceptionIntervalInferieur, ExceptionIntervalSuperieur, ExceptionNombreOperandesEgaleZero, ExceptionNombreOperandesEgaleUn
	{
		CommandeUndo cmdUndo;
		MoteurRPN moteurRPN = new MoteurRPN();
		Operation monOperation = null;
		continu=true;
		do {
			System.out.println("Que voulez vous faire ?");
			System.out.println("Veuillez saisir : Un nombre ou Une operation ou 'exit' ou bien 'undo'");
			monInsert=sc.nextLine();
			/*if(insertIsUndo(monInsert)== true)
			{
				cmdUndo = new CommandeUndo();
				cmdUndo.execute(moteurRPN);
				System.out.println("test bb ");
			}*/
			if((insertIsExit(monInsert)==true) || (insertIsUndo(monInsert)== true) || insertIsNomber(monInsert)==true)// Cas ou il tape exit
			{
				
				if(insertIsExit(monInsert) == true)
				{
					CommandeQuit commandeQuit = new CommandeQuit();
					commandeQuit.execute(moteurRPN);
				}
				else if(insertIsUndo(monInsert) == true)
				{
					cmdUndo = new CommandeUndo();
					cmdUndo.execute(moteurRPN);
				}
				else if(insertIsNomber(monInsert)==true)
				{
					if(verifIntervalValeur(monInsert)==true)
					{
						moteurRPN.ajouterOperande(Float.parseFloat(monInsert));
						moteurRPN.affichageAllOperande();
					}
				}
				
			}
			/*if(insertIsNomber(monInsert)==true) // Cas nombre
			{
				if(verifIntervalValeur(monInsert)==true)
				{
					cmdAjout = new CommandeAjouterOperande(Float.parseFloat(monInsert));
					cmdAjout.execute(moteurRPN);
					moteurRPN.affichageAllOperande();
				}
			}*/
			else // cas operation
			{
				monOperation=operationExist(monInsert);
				if(monOperation==null)// insert n'est pas un nombre ni une op�ration
				{
					throw new ExceptionEntreeIncorrect();
				}
				else // l'entr�e est une operation correcte
				{
					moteurRPN.calculerOperation(monOperation);
					moteurRPN.affichageAllOperande();
				}
			}
			moteurRPN.affichageAllOperande();
		} while (0==0);
	}

	/** Check si l'insert du user est bien un nombre
	 * @param insert
	 * @return boolean
	 */
	public boolean insertIsNomber(String insert)
	{
		try {
			Float a = Float.parseFloat(insert);
			return true;

		} catch (Exception e) {
			//System.out.println("Entr�e incorrect");
			return false;
		}
	}

	/** Check si le nombre inserer par le user appartient a notre plage de valeur
	 * @param insert du user
	 * @return boolean
	 * @throws ExceptionIntervalSuperieur 
	 */
	public boolean verifIntervalValeur(String insert) throws ExceptionIntervalInferieur, ExceptionIntervalSuperieur
	{
		if((Float.parseFloat(monInsert)<=MAX_VALUE)&&(Float.parseFloat(monInsert)>=MIN_VALUE))
		{
			return true;
		}
		else 
		{
			if((Float.parseFloat(monInsert)>MAX_VALUE))
			{
				throw new ExceptionIntervalSuperieur(MIN_VALUE, MAX_VALUE);
			}
			else 
			{
				throw new ExceptionIntervalInferieur(MIN_VALUE, MAX_VALUE);
			}

		}
	}

	/** verifie si l insert du user est exit
	 * @param insert du user
	 * @return boolean
	 */
	public boolean insertIsExit(String insert)
	{
		if(insert.equals("quit"))
		{
			return true;
		}
		return false;
	}
	public boolean insertIsUndo(String insert)
	{
		if(insert.equals("undo"))
		{
			return true;
		}
		return false;
	}

	/** Verifie si l operation que veux inserer le user appartient a notre enumeration
	 * @param l'insert de l'utilisateur
	 * @return l'operation
	 */
	public Operation operationExist(String t)
	{
		Operation operation=null;
		for(Operation op : Operation.values()) //parcourir les operateur de l enumeration
		{
			if(op.getSymbole().equals(monInsert))
			{
				operation=op;
				return operation;
			}
		}
		return operation;
	}
}

