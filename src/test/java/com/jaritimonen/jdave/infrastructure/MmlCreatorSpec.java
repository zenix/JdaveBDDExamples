/**
 *  Copyright 2012 Jari Timonen
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.jaritimonen.jdave.infrastructure;

import com.jaritimonen.jdave.domain.CustomerDTO;
import jdave.Block;
import jdave.Specification;
import jdave.junit4.JDaveRunner;
import org.junit.runner.RunWith;

@RunWith(JDaveRunner.class)
public class MmlCreatorSpec extends Specification<MmlCreator> {

    private CustomerDTO customerDTO = CustomerDTO.newInstance(23, "Jari", "Timonen", "Perfect Software Ltd.");

    private class Any {

        public MmlCreator create() {
            return new MmlCreator();
        }
    }

    public class WhenCreatingMllMessageWithInvalidData extends Any {

        public void thenNullValueThrowsRuntimeException() {
            specify(new Block() {

                public void run() throws Throwable {
                    context.createFrom(null);
                }
            }, must.raise(RuntimeException.class));
        }
    }

    public class WhenCreatingMllMessageWithValidData extends Any {

        public void thenMessageIsGeneratedCorrectly() {
            specify(context.createFrom(customerDTO), must.equal("id:23:firstName:Jari:lastName:Timonen:company:Perfect Software Ltd."));
        }
    }
}
