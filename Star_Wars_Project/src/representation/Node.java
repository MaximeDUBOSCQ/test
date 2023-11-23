package representation;

public abstract class Node implements Event {
	
	private int id;
	private String description;
	private String petiteDescription;
	private static int compteur = 0;
	
	public Node() {
		this.description = "";
		this.petiteDescription = "";
	}
	
	public Node(String uneDescription, String unePetiteDescrption) {
		compteur++;
		this.id = compteur;
		this.description = "<html>" + uneDescription + "</html>";
		this.petiteDescription = unePetiteDescrption;
	}
	
	public String display() {
		return this.description;
	}

	public int getId() {
		return id;
	}

	public void setId(int unId) {
		this.id = unId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String uneDescription) {
		this.description = uneDescription;
	}

	public String getPetiteDescription() {
		return petiteDescription;
	}

	public void setPetiteDescription(String unePetiteDescription) {
		this.petiteDescription = unePetiteDescription;
	}

	public static int getCompteur() {
		return compteur;
	}

	public static void setCompteur(int unCompteur) {
		Node.compteur = unCompteur;
	}

	@Override
    public boolean equals(Object unNode) {
        boolean retour = false;
        if (unNode instanceof Node) {
        	Node leNode = (Node) unNode;
            if (this.description.equals(leNode.getDescription()) && this.petiteDescription.equals(leNode.getPetiteDescription())) {
                retour = true;
            }
        }
        return retour;
    }
	
	@Override
	public String toString() {
		return "Node [id=" + this.id + ", description=" + this.description + ", petiteDescription=" + this.petiteDescription + "]";
	}
	
}
