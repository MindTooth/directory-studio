/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */

package org.apache.directory.studio.valueeditors;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;


/**
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 */
public class ValueEditorUtilsTest
{

    @Test
    public void testEmptyStringIsEditable()
    {
        assertTrue( StringValueEditorUtils.isEditable( "".getBytes() ) );
    }


    @Test
    public void testAsciiIsEditable()
    {
        assertTrue( StringValueEditorUtils.isEditable( "abc\n123".getBytes( StandardCharsets.US_ASCII ) ) );
    }


    @Test
    public void testUft8IsEditable()
    {
        assertTrue( StringValueEditorUtils.isEditable( "a\nb\r\u00e4\t\u5047".getBytes( StandardCharsets.UTF_8 ) ) );
    }


    @Test
    public void testIso88591IsNotEditable()
    {
        assertFalse(
            StringValueEditorUtils.isEditable( "\u00e4\u00f6\u00fc".getBytes( StandardCharsets.ISO_8859_1 ) ) );
    }


    @Test
    public void testPngIsNotEditable()
    {
        assertFalse( StringValueEditorUtils.isEditable( new byte[]
            { ( byte ) 0x89, 0x50, 0x4E, 0x47 } ) );
    }

}
