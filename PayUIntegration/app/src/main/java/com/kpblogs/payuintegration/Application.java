package com.kpblogs.payuintegration;

/**
 * Created by khushvinder
 */
public class Application extends android.app.Application {

    Environment environment;

    @Override
    public void onCreate() {
        super.onCreate();
        environment = Environment.TEST;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
