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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Énumération des types de Files
 * @author <a href="mailto:jean-jacques.etune-ngi@ratp.fr">Jean-Jacques ETUNE NGI (Java EE Technical Lead / Enterprise Architect)</a>
 * @since 19 avr. 2019
 */
@AllArgsConstructor
@Getter
public enum FileType {
	
	/**
	 * Fichier
	 */
	FILE,
	
	/**
	 * Répertoire
	 */
	DIRECTORY,
	
	/**
	 * Fichier ou répertoire
	 */
	ANY;
}
