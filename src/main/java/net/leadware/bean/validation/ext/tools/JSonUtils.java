/**
 * RATP :: SIT :: I2V :: SGA
 */
package net.leadware.bean.validation.ext.tools;

/*-
 * #%L
 * JSR 303 Extentions Tools
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2019 Leadware
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Classe 
 * @author <a href="mailto:jean-jacques.etune-ngi@ratp.fr">Jean-Jacques ETUNE NGI (Java EE Technical Lead / Enterprise Architect)</a>
 * @since 28 avr. 2019 - 15:25:05
 */
public class JSonUtils {

	/**
	 * Methode permettant de tester si une chaine est au format JSON
	 * @param json	Chaine a tester
	 * @return	résultat du test
	 */
	public static boolean isValidJson(String json) {
		
		try {
			
			// Mapper JSon
			ObjectMapper mapper = new ObjectMapper();
			
			// Tentative de transformation JSon Objet
			mapper.readTree(json);
			
			// On retourne Trus si OK
			return true;
			
		} catch (IOException e) {
			
			// En cas d'exception
			return false;
		}
	}
	
}
