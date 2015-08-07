/**
 * 
 */
package org.jscruz.wallboard.health;

import com.codahale.metrics.health.HealthCheck;


/**
 * 
 * <ul>
 * <li><b>Title</b> : TemplateHealthCheck.java</li>
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
public class TemplateHealthCheck extends HealthCheck
{
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
