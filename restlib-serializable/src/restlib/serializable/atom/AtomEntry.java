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


package restlib.serializable.atom;

import restlib.net.IRI;

import com.google.common.base.Optional;


public interface AtomEntry<T> {
    public Iterable<AtomPerson> getAuthors();
    public Iterable<AtomCategory> getCategories();
    public Optional<T> getContent();
    public Iterable<AtomPerson> getContributors();
    public IRI getId();
    public Iterable<AtomLink> getLinks();
    public Optional<AtomDate> getPublished();
    public Optional<String> getRights();   
    public Optional<AtomFeed<?>> getSource();
    public Optional<String> getSummary();
    public String getTitle();
    public AtomDate getUpdated(); 
}
