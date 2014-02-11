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
package com.example.renderkit.html_basic;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import com.example.component.ExampleControl;
import com.ibm.xsp.util.HtmlUtil;

public class ExampleRenderer extends Renderer {

	@Override
    public void encodeBegin(FacesContext context, UIComponent component)
            throws IOException {
		if(context == null || component == null) 
	         throw new NullPointerException();
		ResponseWriter writer = context.getResponseWriter();
        if (writer == null) {
            throw new NullPointerException(); 
        }
        if (!(component instanceof ExampleControl)) {
            throw new IllegalStateException();
        }
        ExampleControl exampleControl = (ExampleControl) component;
        String title=exampleControl.getTitle();
        String mainHeader=exampleControl.getMainHeader();
       
   
        writer.startElement("div", component);
        HtmlUtil.writeIdAttribute(context, exampleControl);
        
        if (title != null){
            writer.writeAttribute("title", title, null); // $NON-NLS-1$
        }
        writer.writeAttribute("style", "border:black solid dashed", null);
        if(mainHeader != null)
        	writer.writeText(" New Document Form for IBM Connect 2014 " + mainHeader, null);       
        else
        	writer.writeText("New Document Form for IBM Connect 2014", null);        
        writer.startElement("hr", null);
        writer.endElement("hr");
    }
    @Override
    public void encodeEnd(FacesContext context, UIComponent component)
            throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("div");
    }
}
