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
package com.jaritimonen.jdave.service;

import com.jaritimonen.jdave.client.MmlClient;
import com.jaritimonen.jdave.domain.CustomerDTO;
import com.jaritimonen.jdave.infrastructure.MmlCreator;
import jdave.Specification;
import jdave.junit4.JDaveRunner;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;

@RunWith(JDaveRunner.class)
public class MmlOneLinerServiceSpec extends Specification<MmlOneLinerService> {

    private final MmlClient mmlClient = Mockito.mock(MmlClient.class);
    private final MmlCreator mmlCreator = Mockito.mock(MmlCreator.class);

    public class WhenSendingMmlMessage {

        public MmlOneLinerService create() {
            return new MmlOneLinerService(mmlClient) {
                protected MmlCreator createMmlCreator() {
                    return mmlCreator;
                }
            };
        }

        public void thenMessageIsSentUnmodified() {
            String message = "This is a test message";
            Mockito.when(mmlCreator.createFrom(Matchers.any(CustomerDTO.class))).thenReturn(message);
            context.send(new CustomerDTO());
            Mockito.verify(mmlClient).sendMessage(message);

        }
    }
}
