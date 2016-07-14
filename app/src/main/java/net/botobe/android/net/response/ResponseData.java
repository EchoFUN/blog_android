package net.botobe.android.net.response;

import org.json.JSONArray;


public class ResponseData {

    public boolean isUserLockedError;

    public int code;
    public String msg;
    public Object data;


    public JSONArray remindArray;

    public ResponseData() {
    }

    public ResponseData(boolean isUserLockedError) {
        this.isUserLockedError = isUserLockedError;
    }

}
