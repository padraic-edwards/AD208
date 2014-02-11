/*
 * © Copyright IBM Corp. 2014
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */ 
package com.example.component;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

public class ExampleControl extends UIComponentBase {
	
	public static final String COMPONENT_FAMILY="com.example.ExampleControl";

	public static final String COMPONENT_TYPE = "com.example.ExampleControl";

	public static final String RENDERER_TYPE = "com.example.ExampleControl";
	
	private String mainHeader,title;
	
	
	public ExampleControl() {
		super();
		setRendererType(RENDERER_TYPE);
	}
	

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public String getTitle() {
		if (title != null) {
			return title;
		}
		ValueBinding vb = getValueBinding("title");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}
		return null;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	public String getMainHeader() {
		if (mainHeader != null) {
			return mainHeader;
		}
		ValueBinding vb = getValueBinding("mainHeader");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}
		return null;
	}
	
	public void setMainHeader(String mainHeader){
		this.mainHeader=mainHeader;
	}
	
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		mainHeader = (String) values[1];
		title = (String) values[2];
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[3];
		values[0] = super.saveState(context);
		values[1] = mainHeader;
		values[2] = title;
		return values;
	}
}
