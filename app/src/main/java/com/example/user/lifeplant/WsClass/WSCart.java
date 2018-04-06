package com.example.user.lifeplant.WsClass;
import android.content.Context;
import com.example.user.lifeplant.Models.ResCartModel;
import com.google.gson.Gson;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class WSCart {
    private Context context;

    public WSCart(final Context context) {
        this.context = context;
    }

    private ResCartModel parseResponse(final String response) {
        ResCartModel  resCartModel = new ResCartModel();

        if (response != null && response.trim().length() > 0) {
            try {
                final Gson gson = new Gson();
                resCartModel = gson.fromJson(response, ResCartModel.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resCartModel;
    }

    public ResCartModel executeService(final String user_id, final String pro_id, final String qnty) {
        final String url = WSConstants.BASE_URL + WSConstants.METHOD_CART;
        final String response = new WSUtil().callServiceHttpPost(url, generateCartRequest(user_id, pro_id,qnty));
        return parseResponse(response);
    }

    private RequestBody generateCartRequest(final String user_id, final String pro_id,final String qnty) {
        final WSConstants wsConstants = new WSConstants();
        final FormBody.Builder formEncodingBuilder = new FormBody.Builder();
        formEncodingBuilder.add(wsConstants.PARAMS_USERID, user_id);
        formEncodingBuilder.add(wsConstants.PARAMS_PROID, pro_id);
        formEncodingBuilder.add(wsConstants.PARAMS_QNTY, qnty);

        return formEncodingBuilder.build();
    }
}
