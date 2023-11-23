package univers;

import representation.Node;

public abstract class Personnage {

	private String pseudo;
    private int vie;
    private int attaque;
    private float force;
    private Sabre sabre;
    
    public Personnage() {
    	this.pseudo = "";
    	this.vie = 0;
    	this.attaque = 0;
    	this.force = 0f;
    	sabre = null;
    }
    
    public Personnage(String unPseudo, int uneVie, int uneAttaque, float uneForce, Sabre unSabre) {
        this.pseudo = unPseudo;
        this.vie = uneVie;
        this.attaque = uneAttaque;
        this.force = uneForce;
        this.sabre = unSabre;
    }
    
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String unPseudo) {
		this.pseudo = unPseudo;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int uneVie) {
		this.vie = uneVie;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int uneAttaque) {
		this.attaque = uneAttaque;
	}

	public float getForce() {
		return force;
	}

	public void setForce(float uneForce) {
		this.force = uneForce;
	}

	public Sabre getSabre() {
		return sabre;
	}

	public void setSabre(Sabre unSabre) {
		this.sabre = unSabre;
	}

	@Override
    public boolean equals(Object unPersonnage) {
        boolean retour = false;
        if (unPersonnage instanceof Personnage) {
        	Personnage lePersonnage = (Personnage) unPersonnage;
            if (this.pseudo.equals(lePersonnage.getPseudo()) && (this.vie == lePersonnage.getVie()) && (this.attaque == lePersonnage.getAttaque()) && (this.force == lePersonnage.getForce()) && (this.sabre == lePersonnage.getSabre())) {
                retour = true;
            }
        }
        return retour;
    }
	
	@Override
	public String toString() {
		return "Personnage [pseudo=" + pseudo + ", vie=" + vie + ", attaque=" + attaque + ", force=" + force
				+ ", sabre=" + sabre + "]";
	}
    
    
	
	
	
}
