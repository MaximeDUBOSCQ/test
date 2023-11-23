package representation;

public class TerminalNode extends Node {

	
	public TerminalNode() {
		super();
	}
	
	public TerminalNode(String uneDescription, String unePetiteDescription) {
		super(uneDescription, unePetiteDescription);
	}
	
	@Override
	public Node chooseNext(int unIDNode) {
		return this;
	}

	@Override
    public boolean equals(Object unNode) {
        boolean retour = false;
        if (unNode instanceof TerminalNode) {
        	TerminalNode leNode = (TerminalNode) unNode;
            if (super.equals(leNode)) {
                retour = true;
            }
        }
        return retour;
    }
	
	@Override
	public String toString() {
		return "TerminalNode [getId()=" + super.getId() + ", getDescription()=" + super.getDescription()
				+ ", getPetiteDescription()=" + super.getPetiteDescription() + "]";
	}
	
	
		
}
