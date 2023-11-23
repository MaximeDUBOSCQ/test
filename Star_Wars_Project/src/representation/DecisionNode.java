package representation;

import java.util.Arrays;

public class DecisionNode extends InnerNode {

	public DecisionNode() {
		super();
	}
	
	public DecisionNode(String uneDescription, String unePetiteDescription, int[] lesIDProchaines, Node[] lesProchainsNoeuds) {
        super(uneDescription, unePetiteDescription, lesIDProchaines, lesProchainsNoeuds);
    }
	

	public DecisionNode(String uneDescription, String unePetiteDescription, int[] lesIDProchaines) {
        super(uneDescription, unePetiteDescription, lesIDProchaines);
    }
	
	@Override
    public boolean equals(Object unNode) {
        boolean retour = false;
        if (unNode instanceof DecisionNode) {
        	DecisionNode leNode = (DecisionNode) unNode;
            if (super.equals(leNode)) {
                retour = true;
            }
        }
        return retour;
    }

	@Override
	public String toString() {
		return "DecisionNode [getId()=" + super.getId() + ", getDescription()="
				+ super.getDescription() + ", getPetiteDescription()=" + super.getPetiteDescription() + ", getIDProchaines()=" + 
				Arrays.toString(super.getIDProchaines()) + ", getProchainesNodes()=" + Arrays.toString(super.getProchainesNodes()) + "]";
	}

	
	
}
