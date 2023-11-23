package representation;

import java.util.Arrays;
import java.util.Random;

public class ChanceNode extends InnerNode {
	
	Random nbAleatoire = new Random();

	public ChanceNode() {
		super();
	}
	
	public ChanceNode(String uneDescription, String unePetiteDescription, int[] lesIDProchaines, Node[] lesProchainsNoeuds) {
        super(uneDescription, unePetiteDescription, lesIDProchaines, lesProchainsNoeuds);
    }

	public ChanceNode(String uneDescription, String unePetiteDescription, int[] lesIDProchaines) {
        super(uneDescription, unePetiteDescription, lesIDProchaines);
    }
	
	@Override
	public Node chooseNext(int unIDNode) {
		Node[] lesNodes = super.getProchainesNodes();
		return lesNodes[nbAleatoire.nextInt(lesNodes.length)];
	}
    
	@Override
    public boolean equals(Object unNode) {
        boolean retour = false;
        if (unNode instanceof ChanceNode) {
        	ChanceNode leNode = (ChanceNode) unNode;
            if (super.equals(leNode)) {
                retour = true;
            }
        }
        return retour;
    }

	@Override
	public String toString() {
		return "ChanceNode [getId()=" + super.getId() + ", getDescription()="
				+ super.getDescription() + ", getPetiteDescription()=" + super.getPetiteDescription() + ", getIDProchaines()="
				+ Arrays.toString(this.getIDProchaines()) + ", getProchainesNodes()=" + Arrays.toString(this.getProchainesNodes()) + "]";
	}
    
    
    
}
