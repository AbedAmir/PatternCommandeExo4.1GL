package TestMvnArtifactExo42;

import exception.ExceptionNombreOperandesEgaleZero;

public class CommandeUndo implements Commande{

	@Override
	public void execute(MoteurRPN moteurRPN) throws ExceptionNombreOperandesEgaleZero {
		System.out.println("Je suis une commande Undo");
		moteurRPN.getCommande().remove(moteurRPN.getCommande().size()-1);
	}

}
