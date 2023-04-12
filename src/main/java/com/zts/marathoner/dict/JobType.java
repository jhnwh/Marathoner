package com.zts.marathoner.dict;

public enum JobType {

    PRO("PRO"),
    JOB("JOB"),
    ftp("ftp");

    private final String typeString;

    JobType(String typeString) {
        this.typeString = typeString;
    }

    public String getTypeString(){
        return this.typeString;
    }

    public static JobType getObjectByString(String env){
        for (JobType value : JobType.values()) {
            if(value.getTypeString().equals(env)){
                return value;
            }
        }
        return null;
    }
}
