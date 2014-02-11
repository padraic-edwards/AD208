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
package xsp.example.test.version;

import java.util.List;

import com.example.library.ExampleLibrary;
import com.ibm.xsp.library.StandardRegistryMaintainer;
import com.ibm.xsp.registry.FacesSharableRegistry;
import com.ibm.xsp.test.framework.version.PrintTagNamesAndProps;
import com.ibm.xsp.test.framework.version.SinceVersionList;

public class ExamplePrintTagNamesAndProps extends PrintTagNamesAndProps {
	/**
     * @param args
     */
    public static void main(String[] args) {
        FacesSharableRegistry registry = StandardRegistryMaintainer.getStandardRegistry();

        System.out.println("PrintTagNamesAndProps.main()");

        List<Object[]> tagsAndProps = getTagsAndProps(registry);

        tagsAndProps = filterToDependsLibrary(registry, (new ExampleLibrary()).getLibraryId(), tagsAndProps);

        List<SinceVersionList> versionInfos = ExampleSinceVersionLists.getSinceVersionLists();
        // checking for most recent, so don't skip it.
        versionInfos.remove(versionInfos.size() - 1);
        for (SinceVersionList versionInfo : versionInfos) {
            removeAll(tagsAndProps, versionInfo.tagsAndProps(), true);

        }
//        removeAll(tagsAndProps, SinceVersion851List.tagsAndProps, true);
//        removeAll(tagsAndProps, SinceVersion852List.tagsAndProps, true);
//        removeAll(tagsAndProps, SinceVersion853List.tagsAndProps, true);

        print(tagsAndProps);
    }

}
