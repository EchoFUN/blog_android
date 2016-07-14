package net.botobe.android.volley;

import android.content.Context;

import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;

import java.io.File;

public class SelfVolley {

    private static RequestQueue mRequestQueue;

    private SelfVolley() {

    }

    public static void init(Context context) {
        File cacheDir = new File(context.getCacheDir(), "volley");
        HttpStack stack = new HurlStack();
        Network network = new BasicNetwork(stack);
        mRequestQueue = new RequestQueue(new DiskBasedCache(cacheDir, 10 * 1024 * 1024), network);
        mRequestQueue.start();
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        }
    }


    public static void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null && tag !=null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    /*
    public static void addRequest(BaseRequest<ResponseData> request, String tag) {
        request.setTag(tag);
        getRequestQueue().add(request);
    }

    public static void addRequest(BaseRequest<ResponseData> request) {
        getRequestQueue().add(request);
    }
    */
}
