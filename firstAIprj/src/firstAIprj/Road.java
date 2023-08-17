package firstAIprj;

public class Road {
	private String name;
	private Node start, end;
	private int weight;
	private Traffic traffic;
	
	
	
	public Road(String name, Node start, Node end, int weight) {
		this.name = name;
		this.start = start;
		this.end = end;
		this.weight = weight;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getStart() {
		return start;
	}
	public void setStart(Node start) {
		this.start = start;
	}
	public Node getEnd() {
		return end;
	}
	public void setEnd(Node end) {
		this.end = end;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Traffic getTraffic() {
		return traffic;
	}
	public void setTraffic(Traffic traffic) {
		this.traffic = traffic;
	}
	
	public void setTraffic(String traffic) {
		switch(traffic) {
		case "low": 
			this.setTraffic(Traffic.LOW);
			break;
		case "normal":
			this.setTraffic(Traffic.NORMAL);
			break;
		case "heavy" :
			this.setTraffic(Traffic.HEAVY);
			break;
		default:
			break;
		}
	}
	
	public void printRoad() {
		System.out.println(this.name+" "+this.start.getName()+" "+this.end.getName()+" "+this.getWeight());
	}
	
	
	
}
