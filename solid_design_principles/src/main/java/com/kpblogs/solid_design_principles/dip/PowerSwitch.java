package com.kpblogs.solid_design_principles.dip;

public class PowerSwitch  implements Switch {
    public Switchable client;
    public boolean on;
    public PowerSwitch(Switchable client) {
        this.client = client;
        this.on = false;
    }
    public boolean isOn() {
        return this.on;
    }
   public void press(){
       boolean checkOn = isOn();
       if (checkOn) {
           client.turnOff();
           this.on = false;
       } else {
             client.turnOn();
             this.on = true;
       }
 
   }
}