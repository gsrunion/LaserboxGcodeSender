package com.runion.laserbox.gcode.sender.ui;

import com.runion.laserbox.gcode.sender.events.DirectoryWatchStopRequestedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.swing.*;


@Component
class StopButton extends JButton {
    public StopButton(ApplicationEventPublisher publisher) {
        setText("Stop Monitoring");
        addActionListener(event -> publisher.publishEvent(new DirectoryWatchStopRequestedEvent(this)));
    }
}
