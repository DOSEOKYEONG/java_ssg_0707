package com.ll.exam;

public class Rq {

    String Path;
    int ObjectId;
    public Rq(String cmd) {
        String[] rqList = cmd.split("\\?");
        this.Path = rqList[0];
        if(rqList.length > 1){
            this.ObjectId = Integer.parseInt((rqList[1].split("="))[1]);
        }
    }

    public String getPath() {
        return Path;
    }
}
