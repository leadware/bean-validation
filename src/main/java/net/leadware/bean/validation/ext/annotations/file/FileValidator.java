/**
 * RATP :: SIT :: I2V :: SGA
 */
package net.leadware.bean.validation.ext.annotations.file;

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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import net.leadware.bean.validation.ext.engine.file.FileValidatorEngine;

/**
 * Annotation de validation d'existence d'un fichier/repertoire
 * @author <a href="mailto:jean-jacques.etune-ngi@ratp.fr">Jean-Jacques ETUNE NGI (Java EE Technical Lead / Enterprise Architect)</a>
 * @since 19 avr. 2019
 */
@Constraint(validatedBy = FileValidatorEngine.class)
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface FileValidator {
	
	/**
	 * Méthode permettant de retourner le message en cas de violation de la contrainte
	 * @return Code du message d'erreur
	 */
	String message() default "{fr.grouperatp.sga.serveur.affichage.FileValidator.message}";
	
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
	
	/**
	 * Méthode permettant de retourner la valeur de l'attribut de type de fichier
	 * @return	Type de fichier
	 */
	FileType fileType() default FileType.ANY;
	
	/**
	 * 
	 * Méthode permettant de retourner la valeur du type de validation
	 * @return	Type de validation
	 */
	VisibilityType visibility() default VisibilityType.READEABLE;
	
	/**
	 * Méthode permettant d'obtenir l'État de validation du champ valide si il n'est pas renseigné
	 * @return	État de validation du champ valide si il n'est pas renseigné
	 */
	boolean acceptOnEmptyField() default true;
}
