/*
 * Copyright 2015 floragunn UG (haftungsbeschränkt)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.floragunn.searchguard.action.configupdate;

import java.io.IOException;

import org.elasticsearch.action.ActionRequestValidationException;
import org.elasticsearch.action.support.nodes.BaseNodesRequest;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;

public class ConfigUpdateRequest extends BaseNodesRequest<ConfigUpdateRequest> {

    private String[] configTypes;

    ConfigUpdateRequest() {
        super();
    }

    public ConfigUpdateRequest(final String[] configTypes) {
        super();
        this.configTypes = configTypes;
    }

    @Override
    public void readFrom(final StreamInput in) throws IOException {
        super.readFrom(in);
        this.configTypes = in.readStringArray();
    }

    @Override
    public void writeTo(final StreamOutput out) throws IOException {
        super.writeTo(out);
        out.writeStringArray(configTypes);
    }

    public String[] getConfigTypes() {
        return configTypes;
    }

    public void setConfigTypes(final String[] configTypes) {
        this.configTypes = configTypes;
    }

    @Override
    public ActionRequestValidationException validate() {
        if (configTypes == null || configTypes.length == 0) {
            return new ActionRequestValidationException();
        }
        return null;
    }
}
