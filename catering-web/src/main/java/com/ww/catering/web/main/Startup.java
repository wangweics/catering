package com.ww.catering.web.main;

public class Startup extends AbstractServer {

    public Startup(String[] anArgs) {
        super(anArgs);
    }

    public static void main(String... anArgs) throws Exception {
        try {
            new Startup(anArgs).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(Config config) {
    }

}
