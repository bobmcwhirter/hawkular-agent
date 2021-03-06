/*
 * Copyright 2015-2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.agent.monitor.extension;

import org.hawkular.agent.monitor.protocol.ProtocolServices;
import org.hawkular.agent.monitor.scheduler.SchedulerConfiguration;
import org.jboss.as.controller.AttributeDefinition;
import org.jboss.as.controller.SimpleAttributeDefinition;
import org.jboss.as.controller.SimpleAttributeDefinitionBuilder;
import org.jboss.as.controller.operations.validation.StringLengthValidator;
import org.jboss.as.controller.registry.AttributeAccess;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.ModelType;

public interface SubsystemAttributes {

    SimpleAttributeDefinition ENABLED = new SimpleAttributeDefinitionBuilder("enabled",
            ModelType.BOOLEAN)
                    .setAllowNull(true)
                    .setDefaultValue(new ModelNode(true))
                    .setAllowExpression(true)
                    .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
                    .build();

    SimpleAttributeDefinition API_JNDI = new SimpleAttributeDefinitionBuilder("apiJndiName",
            ModelType.STRING)
                    .setAllowNull(true)
                    .setValidator(new StringLengthValidator(0, Integer.MAX_VALUE, true, true))
                    .setDefaultValue(new ModelNode("java:global/hawkular/agent/api"))
                    .setAllowExpression(true)
                    .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
                    .build();

    SimpleAttributeDefinition AUTO_DISCOVERY_SCAN_PERIOD_SECS = new SimpleAttributeDefinitionBuilder(
            "autoDiscoveryScanPeriodSecs", ModelType.INT)
                    .setAllowNull(true)
                    .setDefaultValue(new ModelNode(ProtocolServices.DEFAULT_AUTO_DISCOVERY_SCAN_PERIOD_SECS))
                    .setAllowExpression(true)
                    .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
                    .build();

    SimpleAttributeDefinition NUM_DMR_SCHEDULER_THREADS = new SimpleAttributeDefinitionBuilder(
            "numDmrSchedulerThreads", ModelType.INT)
                    .setAllowNull(true)
                    .setDefaultValue(new ModelNode(4))
                    .setAllowExpression(true)
                    .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
                    .build();

    SimpleAttributeDefinition METRIC_DISPATCHER_BUFFER_SIZE = new SimpleAttributeDefinitionBuilder(
            "metricDispatcherBufferSize", ModelType.INT)
                    .setAllowNull(true)
                    .setDefaultValue(new ModelNode(SchedulerConfiguration.DEFAULT_METRIC_DISPATCHER_BUFFER_SIZE))
                    .setAllowExpression(true)
                    .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
                    .build();

    SimpleAttributeDefinition METRIC_DISPATCHER_MAX_BATCH_SIZE = new SimpleAttributeDefinitionBuilder(
            "metricDispatcherMaxBatchSize", ModelType.INT)
                    .setAllowNull(true)
                    .setDefaultValue(new ModelNode(SchedulerConfiguration.DEFAULT_METRIC_DISPATCHER_MAX_BATCH_SIZE))
                    .setAllowExpression(true)
                    .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
                    .build();

    SimpleAttributeDefinition AVAIL_DISPATCHER_BUFFER_SIZE = new SimpleAttributeDefinitionBuilder(
            "availDispatcherBufferSize", ModelType.INT)
                    .setAllowNull(true)
                    .setDefaultValue(new ModelNode(SchedulerConfiguration.DEFAULT_AVAIL_DISPATCHER_BUFFER_SIZE))
                    .setAllowExpression(true)
                    .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
                    .build();

    SimpleAttributeDefinition AVAIL_DISPATCHER_MAX_BATCH_SIZE = new SimpleAttributeDefinitionBuilder(
            "availDispatcherMaxBatchSize", ModelType.INT)
                    .setAllowNull(true)
                    .setDefaultValue(new ModelNode(SchedulerConfiguration.DEFAULT_AVAIL_DISPATCHER_MAX_BATCH_SIZE))
                    .setAllowExpression(true)
                    .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
                    .build();

    AttributeDefinition[] ATTRIBUTES = {
            ENABLED,
            API_JNDI,
            AUTO_DISCOVERY_SCAN_PERIOD_SECS,
            NUM_DMR_SCHEDULER_THREADS,
            METRIC_DISPATCHER_BUFFER_SIZE,
            METRIC_DISPATCHER_MAX_BATCH_SIZE,
            AVAIL_DISPATCHER_BUFFER_SIZE,
            AVAIL_DISPATCHER_MAX_BATCH_SIZE
    };
}