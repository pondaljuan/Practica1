/* Copyright 2019 Juan Andres Pondal Toledo 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.*/

package interfaces;

import dominio.*;

/**
 * Implementa una intefaz de tipo texto para el catálgo de coches. 
 **/
public class Interfaz
{
	/**
	 * Inicia la interfaz con parámetros.
	 * @param args puede ser <i>add</i> para añdair un coche, o <i>show</i> para 
	 * mostrar todos los coches que se encuentren en el catálogo, o <i>help</i> 
	 * para mostrar las ayudas al usuario para usar la interfaz.
	 **/
	public static void iniciar(String args[])
	{
		Catalogo catalogo = new Catalogo();
		if (args[0].equals("add"))
		{
			catalogo.annadirCoche(args[1], Integer.parseInt(args[2]), args[3], args[4], args[5]);
		}
		else if (args[0].equals("delete"))
		{
			catalogo.borrarCoche(args[1]);
		}
		else if (args[0].equals("show")) System.out.println(catalogo);
		else if (args[0].equals("hoja"))
		{
			catalogo.generarHojaDeCalculo();
			System.out.println("Hoja de cálculo generada en output/coches.ods");
		}
		else if (args[0].equals("modify"))
		{
			catalogo.borrarCoche(args[1]);
			catalogo.annadirCoche(args[2], Integer.parseInt(args[3]), args[4], args[5], args[6]);
		}
		else if (args[0].equals("help")){
			System.out.println("\n \n" + "Para añadir un nuevo coche  --> java -jar coches.jar add <Nombre del Coche> <Año de Matriculación> <Velocidad Maxima> <Color del Coche> <Precio del Coche> \nPara observar los coches existentes --> java -jar coches.jar show \nPara eliminar un coche --> java -jar coches.jar delete <Nombre del Coche> \nPara modificar un coche exsitente --> java -jar coches.jar modify <Nombre del Coche a modificar> <Nombre del Coche modificado> <Año de Matriculación> <Velocidad Maxima> <Color del Coche> <Precio del Coche>" + "\n \n"); 
		}
		else System.out.println("Opción incorrecta \n introducir java -jar coches.jar help para abrir la ayuda al usuario");
	}
}


