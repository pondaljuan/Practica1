/* Copyright 2019 Juan Andres Pondal Toledo
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.*/


package dominio;

/**
 *En esta clase se definen los atributos del coche informacion que es necesaria para crear el coche.
 */
public class Coche
{
	private String nombreCoche;
	private int annoMatriculacion;
	private String velocidadMaxima;
	private String colorCoche;
	private String precio;

	/** 
	 * Establece el nombre del coche.
	 **/
	public void setNombreCoche(String nombreCoche) {
		this.nombreCoche = nombreCoche;
	}

	/**
	 * Establece el color del coche.
	 **/
		public void setColorCoche(String colorCoche) {
		this.colorCoche = colorCoche;
	}

	/**
	 * Establece el año de matriculación del coche.
	 **/
	public void setAnnoMatriculacion(int annoMatriculacion) {
		this.annoMatriculacion = annoMatriculacion;
	}

	/**
	 * Establece la Velocida Maxima  del coche.
	 **/
	public void setVelocidadMaxima(String velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * Establece el precio del coche.
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene el nombre del coche. 
	 **/
	public String getNombreCoche() {
		return nombreCoche;
	}

	/**
	 * Obtiene el color del coche.
	 **/
	public String getColorCoche() {
		return colorCoche;
	}

	/**
	 * Obtiene el año de matriculación del coche.
	 **/
	public int getAnnoMatriculacion() {
		return annoMatriculacion;
	}

	/**
	 * Obtiene la Velocida Maxima del coche.
	 **/
	public String getVelocidadMaxima() {
		return velocidadMaxima;
	}

	/**
	 * Obtiene el precio del coche.
	 **/
	public String getPrecio() {
		return precio;
	}

	/**
	 * Genera una cadena de carateres a partir del objeto que recibe el mensaje.
	 * @return devuelve la cadena de carateres.
	 **/
	@Override
	public String toString() {
		return  "Nombre: " + getNombreCoche() + ", " + 
			"Año de matriculación: " + getAnnoMatriculacion() + ", " +
			"Velocidad Maxima: " + getVelocidadMaxima() + ", " +
			"Color del coche: " + getColorCoche() + ", " +
			"Precio: " + getPrecio();
	}

	/**
	 * Construye un coche con el nombre, el año de matriculación, la velocidad maxima, el color y el precio como parametros.
	 * @param nombreCoche el nombre del coche.
	 * @param annoMatriculacion el año de matriculación del coche.
	 * @param velocidadMaxima la velocidad maxima del coche en (km/h)
	 * @param colorCoche el color del coche.
	 * @param precio el precio del coche.
	 **/
	public Coche(String nombreCoche, int annoMatriculacion, String velocidadMaxima, String colorCoche, String precio) {
		this.nombreCoche = nombreCoche;
		this.annoMatriculacion = annoMatriculacion;
		this.velocidadMaxima = velocidadMaxima;
		this.colorCoche = colorCoche;
		this.precio = precio;
	}

	/**
	 * Constructor que inicializa el nombre, el año de matriculación, la velocidad maxima, el color y el precio como cadenas vacías.
	 **/
	public Coche() {

	}

	/**
	 * Dos coches son iguales si sus nombres son iguales.
	 * @param objeto coche con el que hay que comparar.
	 * @return <i>true</i> si los dos nombres son iguales y <i>false</i> en otro caso.
	 **/
	public boolean equals(Object objeto) {
		Coche coche = (Coche) objeto;
		return this.nombreCoche.equals(coche.getNombreCoche());
	}
}


