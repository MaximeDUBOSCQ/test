package representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public  class InnerNode extends Node {

	private int[] IDProchaines;
	private Node[] prochainesNodes;
	
	public InnerNode() {
		super();
		this.IDProchaines = null;
		this.prochainesNodes = null;
	}
	
	public InnerNode(String uneDescription, String unePetiteDescription, int[] lesIDProchaines, Node[] lesProchainsNoeuds) {
		super(uneDescription, unePetiteDescription);
		this.IDProchaines = lesIDProchaines;
		this.prochainesNodes = lesProchainsNoeuds;
		
	}
	
	public InnerNode(String uneDescription, String unePetiteDescription, int[] lesIDProchaines) {
		super(uneDescription, unePetiteDescription);
		this.IDProchaines = lesIDProchaines;
		this.prochainesNodes = null;
		
	}
	

	@Override
	public Node chooseNext(int unIDNode) {
		for (int i = 0 ; i < prochainesNodes.length ; i++) {
			if (prochainesNodes[i].getId() == unIDNode) {
				return prochainesNodes[i];
			}
		}
		return null;
	}
	
	
	/**
	 * @param uneListeID     Un tableau d'entiers composés des ID des nodes à récupérer
	 * @param uneListeNodes  Une ArrayList de node où l'on cherche les nodes correspondant aux ID
	 * @return Retourne un tableau de nodes en fonction des ID passé en paramètre
	 */
	public Node[] getNodeByID(int[] uneListeID, ArrayList<Node> uneListeNodes) {
		Node[] lesNodes = new Node[uneListeID.length];
		for (int j=0 ; j < uneListeNodes.size() ; j++){
			for (int i=0 ; i < uneListeID.length ; i++) {
				if (uneListeNodes.get(j).getId() == uneListeID[i]) {
					lesNodes[i] = uneListeNodes.get(j);
				}
			}
		}
	    return lesNodes;
	}
	
	
	
	public int[] getIDProchaines() {
		return this.IDProchaines;
	}
	
	public void setIDProchaines(int[] uneIDProchaines) {
		IDProchaines = uneIDProchaines;
	}
	
	public void setProchainesNodes(int[] lesID, ArrayList<Node> uneListeNodes) {
		this.prochainesNodes = getNodeByID(lesID, uneListeNodes);
	}
	
	public void setProchainesNodes(Node[] uneProchainesNodes) {
		this.prochainesNodes = uneProchainesNodes;
	}

	public Node[] getProchainesNodes() {
		return this.prochainesNodes;
		
	}

	@Override
    public boolean equals(Object unNode) {
        boolean retour = false;
        if (unNode instanceof InnerNode) {
        	InnerNode leNode = (InnerNode) unNode;
            if (super.equals(leNode) && Arrays.equals(this.IDProchaines, leNode.getIDProchaines())) {
                retour = true;
            }
        }
        return retour;
    }

	@Override
	public String toString() {
		return "InnerNode [getId()=" + super.getId() + ", getDescription()=" + super.getDescription()
				+ ", getPetiteDescription()=" + super.getPetiteDescription() + ", prochainesNodes=" + Arrays.toString(this.prochainesNodes) + ", IDProchaines="
						+ Arrays.toString(this.IDProchaines) + "]";
	}


	
	
}
