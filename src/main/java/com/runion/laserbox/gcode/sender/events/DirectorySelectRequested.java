package com.runion.laserbox.gcode.sender.events;

import org.springframework.context.ApplicationEvent;

public class DirectorySelectRequested extends ApplicationEvent {
    public DirectorySelectRequested(Object source) {
        super(source);
    }
}
