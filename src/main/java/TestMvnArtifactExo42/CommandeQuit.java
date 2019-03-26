package TestMvnArtifactExo42;

import exception.ExceptionNombreOperandesEgaleZero;

public class CommandeQuit implements Commande{

	@Override
	public void execute(MoteurRPN moteurRPN) throws ExceptionNombreOperandesEgaleZero {
		System.out.println("Je suis une commande Quit");
		System.exit(0);
	}

}
