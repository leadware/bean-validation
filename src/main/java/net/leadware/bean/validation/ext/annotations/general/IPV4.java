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
package net.leadware.bean.validation.ext.annotations.general;

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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import net.leadware.bean.validation.ext.engine.file.IPV4Rule;


/**
 * Annotation de la rgle de validation permettant de controler que la valeur d'une propritee represente une adresse IPV4 
 * @author <a href="mailto:jetune@leadware.net">Jean-Jacques ETUNE NGI (Leadware Enterprise Architect)</a>
 * @since 31 janv. 2018 - 14:31:37
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IPV4Rule.class)
@Documented
public @interface IPV4 {

	/**
	 * Méthode d'obtention du message  en cas de violation de la règle
	 * @return	Message en cas de violation de la règle
	 */
	String message() default "javax.validation.ext.ipv4.fail";
	
	/**
	 * Méthode d'obtention des Groupes de validation du validateur
	 * @return Groupes de validation du validateur
	 */
	Class<?>[] groups() default {};
	
	/**
	 * Méthode d'obtention du payload de validation
	 * @return	Payload de validation
	 */
	Class<? extends Payload>[] payload() default {};	
}
