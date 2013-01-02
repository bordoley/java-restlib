/*
 * Copyright (C) 2012 David Bordoley
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


package restlib.example.blog.bio;

import restlib.example.blog.serializable.MessageFeed;
import restlib.server.Resource;
import restlib.server.Resources;
import restlib.server.bio.BioConnegResourceDecorator;
import restlib.server.bio.InputStreamDeserializerSupplier;
import restlib.server.bio.OutputStreamSerializerSupplier;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public final class BioMessageFeedResource extends BioConnegResourceDecorator<MessageFeed> {
    public static final class Builder {
        private final ImmutableList.Builder<InputStreamDeserializerSupplier<MessageFeed>> deserializerSuppliers = ImmutableList.builder();
        private Resource resource = Resources.NOT_FOUND;
        private final ImmutableList.Builder<OutputStreamSerializerSupplier> serializerSuppliers = ImmutableList.builder();
        
        private Builder(){}
        
        public Builder addDeserializerSupplier(final InputStreamDeserializerSupplier<MessageFeed> deserializerSupplier) {
            Preconditions.checkNotNull(deserializerSupplier);
            this.deserializerSuppliers.add(deserializerSupplier);
            return this;
        }
        
        public Builder addSerializerSupplier(final OutputStreamSerializerSupplier serializerSupplier) {
            Preconditions.checkNotNull(serializerSupplier);
            this.serializerSuppliers.add(serializerSupplier);
            return this;
        }
        
        public BioMessageFeedResource build() {
            return new BioMessageFeedResource(this);
        }
        
        public Builder setResource(final Resource resource) {
            Preconditions.checkNotNull(resource);
            this.resource = resource;
            return this;
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    private final Iterable<InputStreamDeserializerSupplier<MessageFeed>> deserializerSuppliers;
    private final Iterable<OutputStreamSerializerSupplier> serializerSuppliers;
    
    private BioMessageFeedResource(final Builder builder) {
        super(builder.resource);
        this.deserializerSuppliers = builder.deserializerSuppliers.build();
        this.serializerSuppliers = builder.serializerSuppliers.build();
    }

    @Override
    protected Iterable<InputStreamDeserializerSupplier<MessageFeed>> inputStreamDeserializerSuppliers() {
        return this.deserializerSuppliers;
    }

    @Override
    protected Iterable<OutputStreamSerializerSupplier> outputStreamSerializerSuppliers() {
        return this.serializerSuppliers;
    }
}
