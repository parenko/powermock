/*
 *   Copyright 2020 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package samples.powermockito.junit4.bugs.github840;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.PrepareOnlyThisForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FinalEquals.class)
public class GitHub840Test {

    @Test
    public void should_mock_final_equals_which_calls_method_on_same_instance() {
        FinalEquals mockedFinalEquals = PowerMockito.mock(FinalEquals.class);

        PowerMockito
                .when(mockedFinalEquals.doSomething())
                .thenReturn(7);

        assertThat(mockedFinalEquals.doSomething())
                .isEqualTo(7);
    }
}
