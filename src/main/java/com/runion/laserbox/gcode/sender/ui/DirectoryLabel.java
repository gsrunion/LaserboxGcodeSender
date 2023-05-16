package com.runion.laserbox.gcode.sender.ui;

import com.runion.laserbox.gcode.sender.events.DirectoryWatchRequestedEvent;
import com.runion.laserbox.gcode.sender.events.DirectoryWatchStopRequestedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.*;

import static java.lang.String.format;

@Component
class DirectoryLabel extends JLabel {
    @EventListener
    public void onWatchStart(DirectoryWatchRequestedEvent directoryWatchRequestedEvent) {
        setText(format("Watching directory %s", directoryWatchRequestedEvent.getFile().toString()));
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @EventListener
    public void onWatchStop(DirectoryWatchStopRequestedEvent directoryWatchStopRequestedEvent) {
        setText("");
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
