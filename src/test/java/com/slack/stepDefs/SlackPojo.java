package com.slack.stepDefs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SlackPojo {
    private String channel;
    private String ts;
    private String text;

}
