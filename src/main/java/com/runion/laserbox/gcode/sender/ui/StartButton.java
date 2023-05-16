package com.runion.laserbox.gcode.sender.ui;

import com.runion.laserbox.gcode.sender.events.DirectorySelectRequested;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.swing.*;


@Component
class StartButton extends JButton {

    public StartButton(ApplicationEventPublisher publisher) {
        setText("Start Monitoring");
        addActionListener(event -> publisher.publishEvent(new DirectorySelectRequested(this)));
    }
}
