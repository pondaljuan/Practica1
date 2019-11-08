/* Copyright 2019 Juan Andres Pondal Toledo
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.*/

package aplicacion;

import interfaces.*;

/**
 * Esta clase es la responsable de invocar a la interfaz de texto de la aplicacion.
 **/
public class Principal
{
	/**
	 * Invoca el método estático <i>iniciar</i> de la clase <i>InterfazTexto</i> con
	 * los parametros de entrada del propio <i>main</i>.
	 **/
	public static void main(String args [])
	{
		Interfaz.iniciar(args);
	}


}

