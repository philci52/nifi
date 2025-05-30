/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.web.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.flow.FlowBreadcrumbDTO;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * A serialized representation of this class can be placed in the entity body of a request or response to or from the API. This particular entity holds a reference to a FlowBreadcrumbDTO.
 */
@XmlRootElement(name = "flowEntity")
public class FlowBreadcrumbEntity extends Entity {

    private String id;
    private PermissionsDTO permissions;
    private String versionedFlowState;
    private FlowBreadcrumbDTO breadcrumb;
    private FlowBreadcrumbEntity parentBreadcrumb;

    /**
     * The id for this ancestor ProcessGroup.
     *
     * @return The id
     */
    @Schema(description = "The id of this ancestor ProcessGroup."
    )
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * The permissions for this ancestor ProcessGroup.
     *
     * @return The permissions
     */
    @Schema(description = "The permissions for this ancestor ProcessGroup."
    )
    public PermissionsDTO getPermissions() {
        return permissions;
    }

    public void setPermissions(PermissionsDTO permissions) {
        this.permissions = permissions;
    }

    /**
     * The FlowBreadcrumbDTO that is being serialized.
     *
     * @return The FlowBreadcrumbDTO object
     */
    @Schema(description = "This breadcrumb."
    )
    public FlowBreadcrumbDTO getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(FlowBreadcrumbDTO breadcrumb) {
        this.breadcrumb = breadcrumb;
    }

    /**
     * The parent breadcrumb for this breadcrumb.
     *
     * @return The parent breadcrumb for this breadcrumb
     */
    @Schema(description = "The parent breadcrumb for this breadcrumb."
    )
    public FlowBreadcrumbEntity getParentBreadcrumb() {
        return parentBreadcrumb;
    }

    public void setParentBreadcrumb(FlowBreadcrumbEntity parentBreadcrumb) {
        this.parentBreadcrumb = parentBreadcrumb;
    }

    @Schema(
            description = "The current state of the Process Group, as it relates to the Versioned Flow",
            allowableValues = {"LOCALLY_MODIFIED", "STALE", "LOCALLY_MODIFIED_AND_STALE", "UP_TO_DATE", "SYNC_FAILURE"},
            accessMode = Schema.AccessMode.READ_ONLY
    )
    public String getVersionedFlowState() {
        return versionedFlowState;
    }

    public void setVersionedFlowState(String versionedFlowState) {
        this.versionedFlowState = versionedFlowState;
    }
}
