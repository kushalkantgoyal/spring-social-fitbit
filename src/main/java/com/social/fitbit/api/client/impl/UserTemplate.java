/*
 * Copyright 2015 the original author or authors.
 *
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
 */
package com.social.fitbit.api.client.impl;

import org.springframework.web.client.RestTemplate;

import com.social.fitbit.api.UserOperations;
import com.social.fitbit.api.common.model.user.User;
import com.social.fitbit.api.common.model.user.UserInfo;

class UserTemplate extends AbstractFitbitApiOperations implements UserOperations {

	private static final String USER_PROFILE = "profile.json";
	
	public UserTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	public User getUserProfile() {
		
		User user = null;
		UserInfo info = getEntity(USER_PROFILE, UserInfo.class);
		if(info != null) {
			user = info.getUser();
		}
		
		return user;
	}

	public User getUserProfile(String userId) {
		return getEntity(USER_PROFILE, User.class);
	}
	
	

}
