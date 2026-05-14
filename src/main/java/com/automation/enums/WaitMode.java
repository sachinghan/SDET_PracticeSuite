package com.automation.enums;

public enum WaitMode {
    CLICKABLE("Clickable"),
    VISIBLE("Visible"),
    PRESENT("Present"),
    INVISIBLE("Invisible"),
    SELECTABLE("Selectable");
    private String mode;
    WaitMode(String mode){
        this.mode = mode;
    }
    public String getMode(){
        return mode;
    }
}
