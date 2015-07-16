/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.broker.transport.protocol;

/**
 *
 *
 */
public class MqttProtocolVerifier implements ProtocolVerifier {

    /* (non-Javadoc)
     * @see org.apache.activemq.broker.transport.protocol.ProtocolVerifier#isProtocol(byte[])
     */
    @Override
    public boolean isProtocol(byte[] value) {
        boolean mqtt311 = value[4] == 77 && // M
                value[5] == 81 && // Q
                value[6] == 84 && // T
                value[7] == 84;   // T

        boolean mqtt31  = value[4] == 77  && // M
                        value[5] == 81  && // Q
                        value[6] == 73  && // I
                        value[7] == 115;   // s

        return mqtt311 || mqtt31;
    }



}