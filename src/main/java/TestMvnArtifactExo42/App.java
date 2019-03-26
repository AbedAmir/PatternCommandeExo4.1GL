package TestMvnArtifactExo42;

import exception.ExceptionEntreeIncorrect;
import exception.ExceptionIntervalInferieur;
import exception.ExceptionIntervalSuperieur;
import exception.ExceptionNombreOperandesEgaleUn;
import exception.ExceptionNombreOperandesEgaleZero;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ExceptionNombreOperandesEgaleZero, ExceptionEntreeIncorrect, ExceptionIntervalInferieur, ExceptionIntervalSuperieur, ExceptionNombreOperandesEgaleUn
    {
        System.out.println( "Hello World! Yoyoyo" );
        Interpreteur interpreteur = new Interpreteur();
        interpreteur.init();
        //MoteurRPN moteurRPN = new MoteurRPN();
        SaisieRPN saisieRPN = new SaisieRPN();
        //interpreteur.executeCommande(moteurRPN,"undo");
        //interpreteur.executeCommande(moteurRPN,"quit");
        
    }
}
