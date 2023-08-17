package firstAIprj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	private LinkedList<Road> roads;
	private LinkedList<Node> nodes; 


	public Main() {
		this.roads=new LinkedList<Road>();
		this.nodes=new LinkedList<Node>();
	}




	public static void main(String[] args) {

		Main main=new Main();
		System.out.println(args.length);
		if(args.length!=1) {
			System.out.println("file not found");
			System.exit(0);
		}

		File file=new File(args[0]);
		main.createRoads(file);

		main.printSourse();
		main.printDest();
		System.out.println("\n\n");
		main.nextDay(file,0);
		System.out.println("\n\n");
		main.nextDay(file,1);
		System.out.println("end");
		
	}

	public void createRoads(File file) {

		Scanner scanner=null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String first=scanner.nextLine();
		String source=retDestination(first);
		first=scanner.nextLine();
		String dest=retDestination(first);
		String line=scanner.nextLine();

		while(scanner.hasNextLine()) {
			line=scanner.nextLine();
			if(line.equals("</Roads>"))
				break;
			createRoad(line);
		}
		this.setDest(source, dest);
		return;
	}

	public String retDestination(String first) {
		int i=first.indexOf(">");
		first=first.substring(i+1);
		int j=first.indexOf("<");
		first=first.substring(0, j);
		return first;

	}

	public void createRoad(String line) {
		//gtting name
		int i=line.indexOf(";");
		String name=line.substring(0, i);
		line=line.substring(i+1);
		//getting node a
		i=line.indexOf(";");
		String nodeAName=line.substring(1, i);
		line=line.substring(i+1);
		Node a=new Node(nodeAName);
		//getting node b
		i=line.indexOf(";");
		String nodeBName=line.substring(1, i);
		line=line.substring(i+1);
		Node b= new Node(nodeBName);		
		//getting weight
		String number=line.substring(1);
		int weight=Integer.parseInt(number);
		Road road=new Road(name, a,b,weight);
		this.roads.add(road);
		this.addNode(a);
		this.addNode(b);
		return ;
	}

	public void addNode(Node a) {
		for (Node node: this.nodes) {
			if(a.getName().equals(node.getName())) {
				return;
			}	
		}
		this.nodes.add(a);
		return;
	}


	public void setDest(String nameSourse, String nameDestination) {
		for(Node node:this.nodes) {
			if(node.getName().equals(nameSourse))
				node.setIsSource(true);
			if(node.getName().equals(nameDestination))
				node.setIsDestination(true);
		}
	}

	public void printSourse() {
		for(Node node:this.nodes) {
			if(node.getIsSource())
				System.out.println("sourse is "+ node.getName());
		}
	}

	public void printDest() {
		for(Node node:this.nodes) {
			if(node.getIsDestination())
				System.out.println("destination is "+ node.getName());
		}
	}

	public Road searchRoad(String name) {
		for (Road road: this.roads) {
			if(road.getName().equals(name))
				return road;
		}
		return null;
	}

	public void nextDay(File file, int whichDay) {
		String line=" ";
		int counter=0;
		Scanner scanner=null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			line=scanner.nextLine();
			if(line.equals("<Day>") &&counter==whichDay ) {
				line=scanner.nextLine();
				break;
			} else if(line.equals("<Day>")) {
				counter++;
			}
				
		}
		while(scanner.hasNextLine()&& (!line.equals("</Day>"))) {
			int i=line.indexOf(";");
			String roadName=line.substring(0,i);
			String traffic=line.substring(i+2);
			Road road=this.searchRoad(roadName);
			road.setTraffic(traffic);
			line=scanner.nextLine();
		}
	}

}