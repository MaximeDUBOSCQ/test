package univers;

import representation.Node;

public class Padawan extends Personnage {

	private Maitre maitre;
	
	public Padawan() {
		super();
		this.maitre = null;
	}
	
	public Padawan(String unPseudo, int uneVie, int uneAttaque, float uneForce, Sabre unSabre, Maitre unMaitre) {
		super(unPseudo, uneVie, uneAttaque, uneForce, unSabre);
		this.maitre = unMaitre;
	}

	public Maitre getMaitre() {
		return maitre;
	}

	public void setMaitre(Maitre unMaitre) {
		this.maitre = unMaitre;
	}
	
	@Override
    public boolean equals(Object unPadawan) {
        boolean retour = false;
        if (unPadawan instanceof Padawan) {
        	Padawan lePadawan = (Padawan) unPadawan;
            if (super.equals(lePadawan) && (this.maitre == lePadawan.getMaitre())) {
                retour = true;
            }
        }
        return retour;
    }

	@Override
	public String toString() {
		return "Padawan [getPseudo()=" + getPseudo() + ", getVie()=" + getVie()
				+ ", getAttaque()=" + getAttaque() + ", getForce()=" + getForce() + ", getSabre()=" + getSabre() + ", maitre=" + this.maitre + "]";
	}
	
	
	
}
