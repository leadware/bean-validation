/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.leadware.bean.validation.ext.annotations.general.Future;


/**
 * Classe implementant la regle de validation controlant que la valeur d'une date se trouve dans le futur 
 * @author <a href="mailto:jetune@leadware.net">Jean-Jacques ETUNE NGI (Leadware Enterprise Architect)</a>
 * @since 31 janv. 2018 - 14:29:19
 */
public class FutureRule implements ConstraintValidator<Future, Object> {
		
	/*
	 * (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(Future annotation) {}

	/*
	 * (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext constraintContext) {
		
		// Si l'objet est null
		if(value == null) return false;
		
		// Si on a un Calendar
		if(value instanceof Calendar) {
			
			// On caste
			Calendar calendar = (Calendar) value;
			
			// On évalue
			return calendar.getTime().after(new Date());
		}

		// Si on a un Date
		if(value instanceof Date) {
			
			// On caste
			Date date = (Date) value;
			
			// On évalue
			return date.after(new Date());
		}
		
		// Si l'objet n'est pas de type date (On l'ignore en retournant true - Comme s'il n'ya eu aucun test)
		return true;
	}
}
