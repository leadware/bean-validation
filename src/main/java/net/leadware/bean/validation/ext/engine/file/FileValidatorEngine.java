/**
 * RATP :: SIT :: I2V :: SGA
 */
package net.leadware.bean.validation.ext.engine.file;

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

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.leadware.bean.validation.ext.annotations.file.FileValidator;
import net.leadware.bean.validation.ext.tools.FileUtils;

/**
 * Classe d'implémentation de la validation defichier définie par {@link FileValidator}
 * @author <a href="mailto:jean-jacques.etune-ngi@ratp.fr">Jean-Jacques ETUNE NGI (Java EE Technical Lead / Enterprise Architect)</a>
 * @since 19 avr. 2019
 */
public class FileValidatorEngine implements ConstraintValidator<FileValidator, String> {
	
	/**
	 * Annotation de validation
	 */
	private FileValidator fileValidator;
	
	/*
	 * (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(FileValidator fileValidator) {
		
		// Appel Parent
		ConstraintValidator.super.initialize(fileValidator);
		
		// Positionnement du type de fichier
		this.fileValidator = fileValidator;
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		// Si le champ est vide
		if(value == null || value.trim().isEmpty()) 
			
			// On retourne la valeur de l'état de validation en cas de champs vide
			return fileValidator.acceptOnEmptyField();
		
		// Enumération des cas de validation
		switch (fileValidator.visibility()) {
		
		// En cas de validation de l'existence
		case EXISTS:
			
			// Énumération des type de fichier
			switch (fileValidator.fileType()) {
			
			// Fichier regulier
			case FILE:
				
				// Validation de l'existence du fichier regulier
				return FileUtils.isFile(value.trim());
				
			case DIRECTORY:
				
				// Validation de l'existence du repertoire
				return FileUtils.isDirectory(value.trim());
				
			case ANY:
				
				// Validation de l'existence du fichier ou repertoire
				return FileUtils.fileExists(value.trim());
				
			default:
				
				// Validation de l'existence du fichier ou repertoire
				return FileUtils.fileExists(value.trim());
				
			}
			
		// En cas de validation de la non existence
		case NOTEXISTS:

			// Énumération des type de fichier
			switch (fileValidator.fileType()) {
			
			// Fichier regulier
			case FILE:
				
				// Validation de la non existence du fichier regulier
				return !FileUtils.isFile(value.trim());
				
			case DIRECTORY:
				
				// Validation de la non existence du repertoire
				return !FileUtils.isDirectory(value.trim());
				
			case ANY:
				
				// Validation de la non existence du fichier ou repertoire
				return !FileUtils.fileExists(value.trim());
				
			default:
				
				// Validation de la non existence du fichier ou repertoire
				return !FileUtils.fileExists(value.trim());
			}	
		
		// Validation de l'existence du repertoire parent
		case PARENT_DIR_EXISTS:
			
			// On retourne l'état de lecture
			return FileUtils.isParentDirExists(value.trim());
			
		// Validation de la visibilité cachée
		case HIDDEN:
		
			// Validation
			return FileUtils.isHidden(value.trim());
			
		// Validation de la visibilité lecture	
		case READEABLE:
			
			// On retourne l'état de lecture
			return FileUtils.isReadeable(value.trim());
			
		// Validation de la visibilité lecture	
		case WRITEABLE:
			
			// On retourne l'état de lecture/ecriture
			return FileUtils.isWriteable(value.trim());
		}
		
		// On retourne false
		return false;
	}
}
