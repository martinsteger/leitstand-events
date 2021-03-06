/*
 * Copyright 2020 RtBrick Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.leitstand.event.webhook.service;

import static io.leitstand.commons.model.BuilderUtil.assertNotInvalidated;

import java.util.Date;

import io.leitstand.commons.model.ValueObject;

/**
 * The operational state of the webhook event loop.
 */
public class WebhookEventLoopStatus extends ValueObject{

	/**
	 * Create a new webhook eventloop status.
	 * @return a builder for an immutable webhook event loop status object.
	 */
	public static Builder newWebhookEventLoopStatus() {
		return new Builder();
	}
	
	/**
	 * Builder for immutable webhook status value object.
	 */
	public static class Builder {
		
		private WebhookEventLoopStatus status = new WebhookEventLoopStatus();
		
		/**
		 * Sets whether the webhook event loop is enable or disabled.
		 * @param enabled <code>true</code> if the loop is stared, <code>false</code> otherwise.
		 * @return a reference to this builder to continue object creation
		 */
		public Builder withEnabled(boolean enabled) {
			assertNotInvalidated(getClass(), status);
			status.enabled = enabled;
			return this;
		}
		
		/**
		 * Sets the timestamp of the last webhook operational state change.
		 * @param dateModified timestamp of last webhook operational state change.
		 * @return a reference to this builder to continue object creation
		 */
		public Builder withDateModified(Date dateModified) {
			assertNotInvalidated(getClass(), status);
			status.dateModified = new Date(dateModified.getTime());
			return this;
		}
			
		/**
		 * Returns an immutable webhook event loop state.
		 * @return an immutable webhook event loop state.
		 */
		public WebhookEventLoopStatus build() {
			try {
				assertNotInvalidated(getClass(), status);
				return status;
			} finally {
				this.status = null;
			}
		}
		
	}
	
	
	private boolean enabled;
	private Date dateModified;
	
	/**
	 * Returns whether the webhook event loop is enabled.
	 * @return <code>true</code> when the webhook event loop is enabled, <code>false</code> otherwise.
	 */
	public boolean isEnabled() {
		return enabled;
	}
	
	/**
	 * Returns the timestamp of the last event loop operational state change.
	 * @return the timestamp of the last event loop operational state change.
	 */
	public Date getDateModified() {
		if(dateModified == null) {
			return null;
		}
		return new Date(dateModified.getTime());
	}
}
