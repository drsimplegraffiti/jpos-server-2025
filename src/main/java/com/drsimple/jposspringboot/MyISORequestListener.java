package com.drsimple.jposspringboot;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;

public class MyISORequestListener implements ISORequestListener {

    @Override
    public boolean process(ISOSource source, ISOMsg msg) {
        System.out.println("I am HERE==========================");
        System.out.println(msg);
        return true;
    }

}
