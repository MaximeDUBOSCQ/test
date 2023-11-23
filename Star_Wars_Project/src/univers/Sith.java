package univers;

public class Sith extends Personnage {

	private float puissanceEclair;
	
	public Sith() {
		super();
		this.puissanceEclair = 0f;
	}
	
	public Sith(String unPseudo, int uneVie, int uneAttaque, float uneForce, Sabre unSabre, float unePuissanceEclair) {
		super(unPseudo, uneVie, uneAttaque, uneForce, unSabre);
		this.puissanceEclair = unePuissanceEclair;
	}

	public float getPuissanceEclair() {
		return puissanceEclair;
	}

	public void setPuissanceEclair(float unePuissanceEclair) {
		this.puissanceEclair = unePuissanceEclair;
	}

	@Override
    public boolean equals(Object unSith) {
        boolean retour = false;
        if (unSith instanceof Sith) {
        	Sith leSith = (Sith) unSith;
            if (super.equals(leSith) && (this.puissanceEclair == leSith.getPuissanceEclair())) {
                retour = true;
            }
        }
        return retour;
    }

	@Override
	public String toString() {
		return "Sith [getPseudo()=" + getPseudo() + ", getVie()=" + getVie()
				+ ", getAttaque()=" + getAttaque() + ", getForce()=" + getForce() + ", getSabre()=" + getSabre() + ", puissanceEclair=" + puissanceEclair + "]";
	}
	
	
	
}
