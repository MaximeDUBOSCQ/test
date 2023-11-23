package representation;

public abstract class EventDecorator implements Event {

	private Event element;
	
	public EventDecorator(Event uneElement) {
		this.element = uneElement;
	}
	
	@Override
    public String display() {
        return this.element.display();
    }

    @Override
    public Node chooseNext(int unIDNode) {
        return this.element.chooseNext(unIDNode);
    }

	public Event getElement() {
		return element;
	}

	public void setElement(Event element) {
		this.element = element;
	}
    
	@Override
    public boolean equals(Object unEvent) {
        boolean retour = false;
        if (unEvent instanceof EventDecorator) {
        	EventDecorator leEvent = (EventDecorator) unEvent;
            if (super.equals(leEvent) && (this.element == leEvent
            		.getElement())) {
                retour = true;
            }
        }
        return retour;
    }
    
}
