package com.thinkbiganalytics.metadata.api.template;

/*-
 * #%L
 * thinkbig-metadata-api
 * %%
 * Copyright (C) 2017 ThinkBig Analytics
 * %%
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
 * #L%
 */

import java.io.Serializable;
import java.util.List;

import com.thinkbiganalytics.metadata.api.Auditable;
import com.thinkbiganalytics.metadata.api.Iconable;
import com.thinkbiganalytics.metadata.api.SystemEntity;
import com.thinkbiganalytics.metadata.api.Taggable;
import com.thinkbiganalytics.metadata.api.feed.Feed;
import com.thinkbiganalytics.metadata.api.security.AccessControlled;
import org.joda.time.DateTime;

/**
 */
public interface FeedManagerTemplate extends AccessControlled, Auditable, Iconable, SystemEntity, Taggable {

    List<Feed> getFeeds();

    boolean addFeed(Feed feed);

    boolean removeFeed(Feed feed);

    ID getId();

    String getName();

    void setName(String name);

    String getNifiTemplateId();

    void setNifiTemplateId(String nifiTemplateId);

    boolean isDefineTable();

    void setDefineTable(boolean defineTable);

    boolean isDataTransformation();

    void setDataTransformation(boolean dataTransformation);

    boolean isAllowPreconditions();

    void setAllowPreconditions(boolean allowedPreconditions);

    String getJson();

    void setJson(String json);

    State getState();

    void setState(State state);

    Long getOrder();

    void setOrder(Long order);

    boolean isStream();

    void setStream(boolean stream);

    String getTemplateTableOption();

    List<ChangeComment> getChangeComments();

    ChangeComment addChangeComment(String comment, DateTime dateTime);

    void clearChangeComments();

    void setTemplateTableOption(String templateTableOption);

    enum State {
        ENABLED, DISABLED
    }

    interface ID extends Serializable {

    }

}
