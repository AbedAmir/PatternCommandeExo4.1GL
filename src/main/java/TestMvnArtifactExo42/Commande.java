package TestMvnArtifactExo42;

import exception.ExceptionNombreOperandesEgaleZero;

public interface Commande {
	void execute(MoteurRPN moteurRPN) throws ExceptionNombreOperandesEgaleZero;
}
