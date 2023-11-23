package univers;

public class Jedi extends Personnage {

	private float niveauMaitriseSabre;
	
	public Jedi() {
		super();
		niveauMaitriseSabre = 0f;
	}
	
	public Jedi(String unPseudo, int uneVie, int uneAttaque, float uneForce, Sabre unSabre, float unNiveauMaitriseSabre) {
		super(unPseudo, uneVie, uneAttaque, uneForce, unSabre);
		this.niveauMaitriseSabre = unNiveauMaitriseSabre;
	}
	

	@Override
    public boolean equals(Object unJedi) {
        boolean retour = false;
        if (unJedi instanceof Jedi) {
        	Jedi leJedi = (Jedi) unJedi;
            if (super.equals(leJedi)) {
                retour = true;
            }
        }
        return retour;
    }

	public float getNiveauMaitriseSabre() {
		return niveauMaitriseSabre;
	}

	public void setNiveauMaitriseSabre(float unNiveauMaitriseSabre) {
		this.niveauMaitriseSabre = unNiveauMaitriseSabre;
	}

	@Override
	public String toString() {
		return "Jedi [getPseudo()=" + getPseudo() + ", getVie()="
				+ getVie() + ", getAttaque()=" + getAttaque() + ", getForce()=" + getForce() + ", getSabre()="
				+ getSabre() + ", niveauMaitriseSabre=" + niveauMaitriseSabre + "]";
	}

	
}
