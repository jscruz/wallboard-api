/**
 * 
 */
package org.jscruz.wallboard.resources;


import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.jscruz.wallboard.core.Saying;
import java.util.concurrent.atomic.AtomicLong;
/**
 * 
 * <ul>
 * <li><b>Title</b> : WallboardApiResource.java</li>
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
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class WallboardApiResource
{
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public WallboardApiResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
