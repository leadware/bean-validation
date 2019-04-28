/**
 * RATP :: SIT :: I2V :: SGA
 */
package net.leadware.bean.validation.ext.tools;

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
