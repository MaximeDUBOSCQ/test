package representation;

import java.util.Arrays;

public class ImageNode extends EventDecorator {

	private String chemin;
	
	public ImageNode(Node uneNode, String unChemin) {
		super(uneNode);
		this.chemin = unChemin;
	}
	
	public String getCgemin() {
		return this.chemin;
	}
	
	@Override
    public String display() {
        return super.getElement().display() + " et c'est un ImageNode";
    }
	
	@Override
    public boolean equals(Object unNode) {
        boolean retour = false;
        if (unNode instanceof ImageNode) {
        	ImageNode leNode = (ImageNode) unNode;
            if (super.equals(leNode) && (this.chemin == leNode.getCgemin())) {
                retour = true;
            }
        }
        return retour;
    }
	
}
