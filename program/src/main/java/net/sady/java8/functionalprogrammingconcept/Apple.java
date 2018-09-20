package net.sady.java8.functionalprogrammingconcept;

class Apple{
	private int id;
	private String color;
	private int weight;
	
	Apple(int id, String color, int weight){
		this.id= id;
		this.color = color;
		this.weight = weight;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [id=" + id + "]";
	}
	
}