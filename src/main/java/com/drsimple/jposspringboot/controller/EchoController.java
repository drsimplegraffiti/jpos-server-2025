package com.drsimple.jposspringboot.controller;


import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.MUX;
import org.jpos.q2.iso.QMUX;
import org.jpos.util.NameRegistrar;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class EchoController {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(EchoController.class);

    @PostMapping("/echo")
    public String echo() throws NameRegistrar.NotFoundException, ISOException {
        MUX mux = QMUX.getMUX("s-mux");
        ISOMsg msg = new ISOMsg();
        msg.setMTI("0800");
        msg.set(11, generateUniqueSTAN());
        msg.set(70, "301");
        ISOMsg resMsg = mux.request(msg, 2000);
        System.out.println("Received response: " + resMsg);
        if (resMsg != null) {
            System.out.println("Received response: " + resMsg);
            logger.info("Received response: {}", resMsg);
            return resMsg.toString();
        } else {
            logger.warn("No response received from MUX within the timeout.");
            return "No response received from MUX within the timeout.";
        }

    }

    private static AtomicInteger stan = new AtomicInteger(1);
    private static String generateUniqueSTAN() {
        return String.format("%06d", stan.getAndIncrement() % 1000000);
    }
}
