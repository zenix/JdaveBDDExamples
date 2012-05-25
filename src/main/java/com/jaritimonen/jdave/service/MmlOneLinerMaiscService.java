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

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.jaritimonen.jdave.client.MmlClient;
import com.jaritimonen.jdave.domain.CustomerDTO;
import com.jaritimonen.jdave.infrastructure.MmlCreator;
import com.jaritimonen.jdave.infrastructure.di.MmlModule;

public class MmlOneLinerMaiscService implements MmlService {

    @Inject
    @Named("telnet")
    private MmlClient telnetClient;
    @Inject
    private MmlCreator mmlCreator;

    public void send(final CustomerDTO customerDTO) {
        telnetClient.sendMessage(mmlCreator.createFrom(customerDTO));
    }

    public static void main(String... args) {
        Injector injector = Guice.createInjector(new MmlModule());
        injector.getInstance(MmlService.class).send(CustomerDTO.newInstance(23, "Jari", "Timonen", "Perfect Software Ltd."));
    }
}
