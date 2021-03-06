/*
 * Copyright 2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kotlinx.serialization

import kotlinx.serialization.json.JSON
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class StrictJSONTest {
    @Test
    fun nonStrictJSONCanSkipValues() {
        assertEquals(JSON.nonstrict.parse<OptionalTests.Data>("{strangeField: 100500, a:0}"), OptionalTests.Data())
    }

    @Test
    fun nonStrictJSONCanSkipComplexValues() {
        assertEquals(JSON.nonstrict.parse<OptionalTests.Data>("{strangeField: {a: b, c: {d: e}, f: [g,h,j] }, a:0}"), OptionalTests.Data())
    }

    @Test
    fun strictJSONCanNotSkipValues() {
        assertFailsWith(SerializationException::class) {
            JSON.parse<OptionalTests.Data>("{strangeField: 100500, a:0}")
        }
    }
}