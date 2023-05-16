package com.runion.laserbox.gcode.sender.ui;


import com.runion.laserbox.gcode.sender.events.CutStopRequestedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.swing.*;


@Component
class EndButton extends JButton {
    public EndButton(ApplicationEventPublisher publisher) {
        setText("Stop Cut");
        addActionListener(event -> publisher.publishEvent(new CutStopRequestedEvent(this)));
    }
}
