package net.leadware.bean.validation.ext.annotations.json;

/*-
 * #%L
 * Apache Kafka Embedded Server
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2013 - 2019 Leadware
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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Payload;

/**
 *  Annotation de validation du format d'une chaine de caractere
 * @author <a href="mailto:jetune@leadware.net">Jean-Jacques ETUNE NGI (Java EE Technical Lead / Enterprise Architect)</a>
 * @since 3 avr. 2019
 */
@StringFormatValidator(format = FormatType.JSON)
@Documented
@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
public @interface JsonValidator {
	
	/**
	 * Méthode permettant de retourner le message en cas de violation de la contrainte
	 * @return Code du message d'erreur
	 */
	String message() default "{fr.grouperatp.sga.kafka.simulator.constraints.JsonValidator.message}";
	
	/**
	 * Méthode permettant d'obtenir le groupe auquel appartient l'annotation
	 * @return	Groupe
	 */
	Class<?>[] groups() default { };
	
	/**
	 * Methode permettant d'obtenir le payload (faccultatif)
	 * @return	Payload
	 */
	Class<? extends Payload>[] payload() default { };
}
