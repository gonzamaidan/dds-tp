package dominio;

public enum Categoria {
	R1(0, 150, 18.76, 0.644),
	R2(150, 325, 35.32, 0.644),
	R3(325, 400, 60.71, 0.681),
	R4(400, 450, 71.74, 0.738),
	R5(450, 500, 110.38, 0.794),
	R6(500, 600, 220.75, 0.032),
	R7(600, 700, 443.59, 0.851),
	R8(700, 1400, 545.96, 0.851),
	R9(1400, 999999, 887.19, 0.851);

	public final int limInferior;
	public final int limSuperior;
	public final double cargoFijo; // $/mes
	public final double cargoVariable; // $/kWh

	Categoria(int limInferior, int limSuperior, double cargoFijo, double cargoVariable) {
		this.limInferior = limInferior;
		this.limSuperior = limSuperior;
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
	}

	public int getLimInferior() {
		return limInferior;
	}

	public int getLimSuperior() {
		return limSuperior;
	}

	public double getCargoFijo() {
		return cargoFijo;
	}

	public double getCargoVariable() {
		return cargoVariable;
	}

	private double cargoFijo() {
		return cargoFijo;
	}

	private double cargoVariable() {
		return cargoVariable;
	}

	private int limInferior() {
		return limInferior;
	}

	private int limSuperior() {
		return limSuperior;
	}

	public double calcularMontoMensual(double consumo) {
		return cargoFijo() + consumo * cargoVariable();
	}

	public boolean dentroDeCategoria(Double monto) {
		// TODO Auto-generated method stub
		return monto > limInferior() && monto < limSuperior();
	}
	
}
