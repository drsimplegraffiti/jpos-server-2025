package com.drsimple.jposspringboot.service;

import org.jpos.iso.ISOComponent;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class NetworkManagement {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(NetworkManagement.class);

    public ISOMsg process(ISOMsg reqMsg) throws ISOException{
        logger.info("Received request: {}", reqMsg);

        ISOMsg field48 = (ISOMsg) reqMsg.getComponent(48);
        String v0012 = field48.getString(1);

        logger.info("0012: {}", v0012);

        reqMsg.setResponseMTI();
        reqMsg.set(39, "00");
        return reqMsg;
    }
}
