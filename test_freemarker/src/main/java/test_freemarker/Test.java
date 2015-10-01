package test_freemarker;

public class Test {
	
	private String titre;
	private String texte1;
	private String texte2;
	private String pied;
	
	
	
	public Test(String titre, String texte1, String texte2, String pied) {
		this.titre = titre;
		this.texte1 = texte1;
		this.texte2 = texte2;
		this.pied = pied;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTexte1() {
		return texte1;
	}
	public void setTexte1(String texte1) {
		this.texte1 = texte1;
	}
	public String getTexte2() {
		return texte2;
	}
	public void setTexte2(String texte2) {
		this.texte2 = texte2;
	}
	public String getPied() {
		return pied;
	}
	public void setPied(String pied) {
		this.pied = pied;
	}
	
	
	

}
