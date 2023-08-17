package firstAIprj;

public class Node {
	private String name;
	private Boolean isSource;
	private Boolean isDestination;
	
	public Node(String name) {
		this.name=name;
		this.isDestination=false;
		this.isSource=false;
		
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsSource() {
		return isSource;
	}
	public void setIsSource(Boolean isSource) {
		this.isSource = isSource;
	}
	public Boolean getIsDestination() {
		return isDestination;
	}
	public void setIsDestination(Boolean isDestination) {
		this.isDestination = isDestination;
	}
	
	
	
	
}
