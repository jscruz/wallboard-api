/**
 * 
 */
package org.jscruz.wallboard.core;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 * <ul>
 * <li><b>Title</b> : Saying.java</li>
 * <li><b>Description</b> :</li>
 * <li><b>Copyright</b> : Copyright (c) 2015</li>
 * <li><b>Company</b> : Siemens Traffic</li>
 * <li><b>Project</b> : wallboard-api--0.0.1-SNAPSHOT</li>
 * <li><b>Author</b> : Jorge.Cruz-Lambert</li>
 * </ul>
 * <p>
 * Copyright (c) Siemens plc 2015. This is an unpublished work, the copyright in which vests in Siemens plc. All
 * rights reserved. <br/>
 * The information contained herein is the property of Siemens plc and is supplied without liability for any errors or
 * omissions and no part may be copied,<br>
 * reproduced, used or disclosed except as authorised by contract or other prior written permission. <br/>
 * The copyright and the foregoing restriction on reproduction, use and disclosure extend to all the media in which this
 * information may be embodied. <br/>
 * Where any information is the responsibility of individual authors, the views contained within said documents do not
 * necessarily represent the views of Siemens plc.
 * </p>
 */
public class Saying
{
    private long id;

    @Length(max = 3)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

}
