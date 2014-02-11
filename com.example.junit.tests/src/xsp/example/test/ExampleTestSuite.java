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
package xsp.example.test;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;
import xsp.example.test.registry.ExampleGroupReuseTest;
import xsp.example.test.registry.ExampleNamingConventionErrorTest;
import xsp.example.test.registry.ExampleNamingConventionTest;
import xsp.example.test.registry.annotate.ExampleControlCategoryKnownTest;
import xsp.example.test.registry.annotate.ExampleRoleAccessibilityTest;
import xsp.example.test.serialize.ExampleViewSerializeTest;
import xsp.example.test.setup.ExampleSuiteSetupTest;
import xsp.example.test.version.ExampleSinceVersionsSetTest;
import xsp.example.test.registry.ExampleLabelsLocalizableTest;

import com.ibm.xsp.test.framework.TestClassList;
import com.ibm.xsp.test.framework.lifecycle.RegisteredDecodeTest;
import com.ibm.xsp.test.framework.registry.BaseBooleanPropertyDefaultTest;
import com.ibm.xsp.test.framework.registry.BaseComplexCheckTest;
import com.ibm.xsp.test.framework.registry.BaseComplexNotRunTimeBindingTest;
import com.ibm.xsp.test.framework.registry.BaseComponentRendererTest;
import com.ibm.xsp.test.framework.registry.BaseComponentTypeTest;
import com.ibm.xsp.test.framework.registry.BaseInheritRendererTypeGetterTest;
import com.ibm.xsp.test.framework.registry.BaseKnownPropertyRedefinitionTest;
import com.ibm.xsp.test.framework.registry.BaseMultiValuePropsUseListTest;
import com.ibm.xsp.test.framework.registry.BaseNoRunTimeBindingsTest;
import com.ibm.xsp.test.framework.registry.BasePropertiesHaveSettersTest;
import com.ibm.xsp.test.framework.registry.BasePropertyAllowsValueTest;
import com.ibm.xsp.test.framework.registry.BasePropertyDefaultValueTest;
import com.ibm.xsp.test.framework.registry.BasePropertyNameCamelCaseTest;
import com.ibm.xsp.test.framework.registry.CollectionNotRunTimeBindingsTest;
import com.ibm.xsp.test.framework.registry.LabelsLocalizableTest;
import com.ibm.xsp.test.framework.registry.NoTransientPropertyTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseDefinitionsHaveDisplayNamesTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseDisplayNameDuplicateTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseEventPropsHaveSubCategoryTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseForEditorTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseImageEditorTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseInputAccessibilityTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseInputDefaultValueDisabledTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseInputReadOnlyPropertyTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseInputReadOnlyRendererTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseLoadedPropertyTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseMergeWarningsTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseNoDesignerDefaultValueTest;
import com.ibm.xsp.test.framework.registry.annotate.BasePageEditorTest;
import com.ibm.xsp.test.framework.registry.annotate.BasePropertiesHaveCategoriesTest;
import com.ibm.xsp.test.framework.registry.annotate.BasePropertyCategoryKnownTest;
import com.ibm.xsp.test.framework.registry.annotate.BasePropertyStyleTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseSimpleActionCategoryTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseSpellCheckTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseTableAccessibilityTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseTitleAccessibilityTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseTodoTaggedTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseTranslatableStringsTest;
import com.ibm.xsp.test.framework.registry.annotate.BaseVarEditorTest;
import com.ibm.xsp.test.framework.registry.parse.StrictParserTest;
import com.ibm.xsp.test.framework.render.BaseDojoTypeTest;
import com.ibm.xsp.test.framework.render.BaseInputSaveValueTest;
import com.ibm.xsp.test.framework.render.BaseRenderBooleanPropertyTest;
import com.ibm.xsp.test.framework.render.BaseRenderControlTest;
import com.ibm.xsp.test.framework.render.BaseRenderDojoPropertyTest;
import com.ibm.xsp.test.framework.render.BaseRenderIdTest;
import com.ibm.xsp.test.framework.render.BaseRenderThemeControlTest;
import com.ibm.xsp.test.framework.render.BaseRenderTitleTest;
import com.ibm.xsp.test.framework.serialize.BaseReflectionSerializeTest;
import com.ibm.xsp.test.framework.serialize.BaseRegisteredSerializationTest;
import com.ibm.xsp.test.framework.serialize.BaseSerializeValueBindingTest;
import com.ibm.xsp.test.framework.serialize.BaseViewSerializeTest;
import com.ibm.xsp.test.framework.setup.TestSetupTest;
import com.ibm.xsp.test.framework.translator.BaseGeneratePagesTest;

public class ExampleTestSuite extends TestSuite{

 public static final long SUITE_VERSION = 40;
 
    public static List<Class<?>> getTestClassList() { 
        TestClassList suite = new TestClassList();

        // Put the test that generates .java files from .xsp files
        // at the start, as other tests depend on it to pass.
        // - BaseGeneratePagesTest
        suite.addTestSuite(BaseGeneratePagesTest.class);
        
        // .setup
        // - TestSetupTest
        suite.addTestSuite(TestSetupTest.class);
        // - BaseSuiteSetupTest
        suite.addTestSuite(ExampleSuiteSetupTest.class);
        
        // - BaseLabelsLocalizableTest
        suite.addTestSuite(ExampleLabelsLocalizableTest.class);
        //suite.addTestSuite(LabelsLocalizableTest.class);
        
        // .control
        // Should have a test verifying control rendered output is as expected         
        // .lifecycle tests
        // - RegisteredDecodeTest
        suite.addTestSuite(RegisteredDecodeTest.class);
        
        // .registry
        // - BaseBooleanPropertyDefaultTest
        suite.addTestSuite(BaseBooleanPropertyDefaultTest.class);
        // - BaseComplexCheckTest
        suite.addTestSuite(BaseComplexCheckTest.class);
        // - BaseComponentRendererTest
        suite.addTestSuite(BaseComponentRendererTest.class);
        // - BaseComponentTypeTest
        suite.addTestSuite(BaseComponentTypeTest.class);
        // - BaseGroupReuseTest
        suite.addTestSuite(ExampleGroupReuseTest.class);
        // - BaseInheritRendererTypeGetterTest
        suite.addTestSuite(BaseInheritRendererTypeGetterTest.class);
        // - BaseKnownPropertyRedefinitionTest
        suite.addTestSuite(BaseKnownPropertyRedefinitionTest.class);
        // - BaseMultiValuePropsUseListTest
        suite.addTestSuite(BaseMultiValuePropsUseListTest.class);
        // - BaseNamingConventionErrorTest
        suite.addTestSuite(ExampleNamingConventionErrorTest.class);
        // - BaseNamingConventionTest
        suite.addTestSuite(ExampleNamingConventionTest.class);
        // - BaseNoRunTimeBindingsTest
        suite.addTestSuite(BaseNoRunTimeBindingsTest.class);
        // - BasePropertiesHaveSettersTest
        suite.addTestSuite(BasePropertiesHaveSettersTest.class);
        // - BasePropertyAllowsValueTest
        suite.addTestSuite(BasePropertyAllowsValueTest.class);
        // - BasePropertyDefaultValueTest
        suite.addTestSuite(BasePropertyDefaultValueTest.class);
        // - BasePropertyNameCamelCaseTest
        suite.addTestSuite(BasePropertyNameCamelCaseTest.class);
        // - CollectionNotRunTimeBindingsTest
        suite.addTestSuite(CollectionNotRunTimeBindingsTest.class);
        // - BaseComplexNotRunTimeBindingTest
        suite.addTestSuite(BaseComplexNotRunTimeBindingTest.class);
        // - NoTransientPropertyTest
        suite.addTestSuite(NoTransientPropertyTest.class);
        
        // .registry.annotate
        // - BaseControlCategoryKnownTest
        suite.addTestSuite(ExampleControlCategoryKnownTest.class);
        // - BaseDefinitionsHaveDisplayNamesTest
        suite.addTestSuite(BaseDefinitionsHaveDisplayNamesTest.class);
        // - BaseDisplayNameDuplicateTest
        suite.addTestSuite(BaseDisplayNameDuplicateTest.class);
        // - BaseEventPropsHaveSubCategoryTest
        suite.addTestSuite(BaseEventPropsHaveSubCategoryTest.class);
        // - BaseForEditorTest
        suite.addTestSuite(BaseForEditorTest.class);
        // - BaseImageEditorTest
        suite.addTestSuite(BaseImageEditorTest.class);
        // - BaseLoadedPropertyTest
        suite.addTestSuite(BaseLoadedPropertyTest.class);
        // - BaseMergeWarningsTest
        suite.addTestSuite(BaseMergeWarningsTest.class);
        // - BaseNoDesignerDefaultValueTest
        suite.addTestSuite(BaseNoDesignerDefaultValueTest.class);
        // - BasePageEditorTest
        suite.addTestSuite(BasePageEditorTest.class);
        // - BasePropertiesHaveCategoriesTest
        suite.addTestSuite(BasePropertiesHaveCategoriesTest.class);
        // - BasePropertyCategoryKnownTest
        suite.addTestSuite(BasePropertyCategoryKnownTest.class);
        // - BasePropertyStyleTest
        suite.addTestSuite(BasePropertyStyleTest.class);
        // - BaseSimpleActionCategoryTest
        suite.addTestSuite(BaseSimpleActionCategoryTest.class);
        // - BaseSpellCheckTest
        suite.addTestSuite(BaseSpellCheckTest.class);
        // - BaseTitleAccessibilityCategoryTest
        suite.addTestSuite(BaseTitleAccessibilityTest.class);
        // - BaseTableAccessibilityCategoryTest
        suite.addTestSuite(BaseTableAccessibilityTest.class);
        // - BaseInputAccessibilityCategoryTest
        suite.addTestSuite(BaseInputAccessibilityTest.class);
        // - BaseInputDefaultValueDisabledTest
        suite.addTestSuite(BaseInputDefaultValueDisabledTest.class);
        // - BaseInputReadOnlyPropertyTest
        suite.addTestSuite(BaseInputReadOnlyPropertyTest.class);
        // - BaseInputReadOnlyRendererTest
        suite.addTestSuite(BaseInputReadOnlyRendererTest.class);
        // - BaseRoleAccessibilityCategoryTest
        suite.addTestSuite(ExampleRoleAccessibilityTest.class);
        // - BaseTodoTaggedTest
        suite.addTestSuite(BaseTodoTaggedTest.class);
        // - BaseTranslatableStringsTest
        suite.addTestSuite(BaseTranslatableStringsTest.class);
        // - BaseVarEditorTest
        suite.addTestSuite(BaseVarEditorTest.class);
        
        // .registry.parse tests
        // - StrictParserTest
        suite.addTestSuite(StrictParserTest.class);
        
        // .render
        // - BaseDojoTypeTest
        suite.addTestSuite(BaseDojoTypeTest.class);
        // - BaseInputSaveValueTest
        suite.addTestSuite(BaseInputSaveValueTest.class);
        // - BaseRenderBooleanPropertyTest
        suite.addTestSuite(BaseRenderBooleanPropertyTest.class);
        // - BaseRenderControlTest
        suite.addTestSuite(BaseRenderControlTest.class);
        // - BaseRenderDojoPropertyTest
        suite.addTestSuite(BaseRenderDojoPropertyTest.class);
        // - BaseRenderIdTest
        suite.addTestSuite(BaseRenderIdTest.class);
        // - BaseRenderThemeControlTest
        suite.addTestSuite(BaseRenderThemeControlTest.class);
        // - BaseRenderTitleTest
        suite.addTestSuite(BaseRenderTitleTest.class);
        
        // .serialize
        // - BaseReflectionSerializeTest
        suite.addTestSuite(BaseReflectionSerializeTest.class);
        // - BaseRegisteredSerializationTest
        suite.addTestSuite(BaseRegisteredSerializationTest.class);
        // - BaseSerializeValueBindingTest
        suite.addTestSuite(BaseSerializeValueBindingTest.class);
        // - BaseViewSerializeTest
        suite.addTestSuite(ExampleViewSerializeTest.class);
        
        // .version
        // - BaseSinceVersionsSetTest
        suite.addTestSuite(ExampleSinceVersionsSetTest.class);
        
        return suite.getTests();
    }
    public static Test suite() { 
        TestSuite suite = new ExampleTestSuite();
        TestClassList.addAll(suite, getTestClassList());
        return suite;
    }
    public static void main(String args[]) { 
        junit.textui.TestRunner.run(suite());
    }

}
