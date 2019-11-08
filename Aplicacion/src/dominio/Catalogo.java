/* Copyright 2019 Juan Andres Pondal Toledo
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.*/


package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 * Esta clase se encarga de llevar el catalogo de coches.
 **/
public class Catalogo
{
	private String nombreFichero = "Coches.txt";
	private ArrayList<Coche> coches = new ArrayList<>();

	/**
	 * Es el responsable de hacer la cadena de caracteres que obtiene del catalago.
	 * @return los valores de la cadena.
	 **/
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Coche coche : coches)
		{
			sb.append(coche + "\n");
		}
		return sb.toString();
	}

	/**
	 * Se encarga de leer el catalogo que obtiene del fichero  <i>Coches.txt</i>.
	 **/
	public Catalogo() {
		try
		{
			File fichero = new File(nombreFichero);
			fichero.createNewFile();
			Scanner sc = new Scanner(fichero);
			while(sc.hasNext())
			{
				Coche coche = new Coche();
				coche.setNombreCoche(sc.nextLine());
				coche.setAnnoMatriculacion(Integer.parseInt(sc.nextLine()));
				coche.setVelocidadMaxima(sc.nextLine());
				coche.setColorCoche(sc.nextLine());
				coche.setPrecio(sc.nextLine());
				coches.add(coche);
			}
		}catch(IOException ex)
		{
			System.err.println(ex);
		}
	}

	private void volcarCoches()
	{
		System.out.println(coches);
		try
		{
			FileWriter fw = new FileWriter(nombreFichero);
			for(Coche coche : coches)
			{
				fw.write(coche.getNombreCoche()+"\n");
				fw.write(coche.getAnnoMatriculacion()+"\n");
				fw.write(coche.getVelocidadMaxima()+"\n");
				fw.write(coche.getColorCoche()+"\n");
				fw.write(coche.getPrecio()+"\n");
			}
			fw.close();
		}catch(IOException ex)
		{
			System.err.println(ex);
		}
	}

	/**
	 * Añade el coche al catálogo.
	 **/
	public void annadirCoche(String nombreCoche, int annoMatriculacion, String velocidadMaxima, String colorCoche, String precio)
	{
		Coche coche = new Coche(nombreCoche, annoMatriculacion, velocidadMaxima, colorCoche, precio);
		coches.add(coche);
		this.volcarCoches();
	}

	/**
	 * Borra el coche seleccionado del catálogo.
	 **/
	public void borrarCoche(String nombreCoche)
	{
		Coche coche = new Coche();
		coche.setNombreCoche(nombreCoche);
		coches.remove(coche);
		this.volcarCoches();
	}

	/**
	* Genera una hoja de cálculo donde se vuelcan los datos.
	*/
	public void generarHojaDeCalculo()
	{
		final Object[][] datos = new Object[coches.size()][5];
		int i = 0;
		for (Coche coche : coches)
		{
			datos[i][0] = coche.getNombreCoche();
			datos[i][1] = coche.getAnnoMatriculacion();
			datos[i][2] = coche.getVelocidadMaxima();
			datos[i][3] = coche.getColorCoche();
			datos[i++][4] = coche.getPrecio();
		}
				
		String[] columnas = new String[] { "Nombre", "Año de matriculación", "Velocidad Maxima", "Color del coche", "Precio" };
		
		TableModel modelo = new DefaultTableModel(datos, columnas);

		final File file = new File("output/coches.ods");
		try
		{
			SpreadSheet.createEmpty(modelo).saveAs(file);
		}catch(IOException ex)
		{
			System.out.println(ex);
		}

	}
}
