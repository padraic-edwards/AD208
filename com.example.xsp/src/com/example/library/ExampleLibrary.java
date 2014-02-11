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
package com.example.library;

import com.ibm.xsp.library.AbstractXspLibrary;

public class ExampleLibrary extends AbstractXspLibrary {

	public String getLibraryId() {
		return "com.example.library";
	}

	public String getPluginId() {
		return "com.example.xsp";
	}

	@Override
	public String[] getFacesConfigFiles() {
		return new String[]{
				"META-INF/example-faces-config.xml",
		};
	}

	@Override
	public String[] getXspConfigFiles() {
		return new String[]{
				"META-INF/exampleControl.xsp-config",
		};
	}
	
	@Override
	public String getTagVersion() {
		return "1.0.0";
	}
	
}