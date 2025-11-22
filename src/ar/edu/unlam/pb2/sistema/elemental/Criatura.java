package ar.edu.unlam.pb2.sistema.elemental;

public abstract class Criatura {

	protected String nombre;
	protected Integer energia;
	protected Tipo tipo;

	public Criatura(String nombre, Integer energia, Tipo tipo) {
		this.nombre = nombre;
		this.energia = energia;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Integer getEnergia() {
		return energia;
	}
}