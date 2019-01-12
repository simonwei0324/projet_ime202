package projet.ime202;

public class TestCancer {
	
	public static void main( String[] args ){
	   	
	String lesionpatient="A7A0";
	String organepatient="DC";
	String DP="C443";
	String DR=""; //y a des lignes qui sont vides
	String DAS="C539";
	AnapathToCancer an =new AnapathToCancer();

	System.out.println("fichier PMSI");
	an.Cim10toCancer(DP,DR,DAS);
	
	System.out.println("fichier Anapath");
	an.AdicaptoCancer(lesionpatient,organepatient);
	
	
	}
}
