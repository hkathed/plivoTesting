import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.*;



public class CreateChannel{

    CommanMethods commanMethods = new CommanMethods();

    public String  createNewChannel(String newChannel) throws IOException {

        URL slackUrl = new URL(Constants.URLS.url+"/"+Constants.apis.CREATECHANNEL);

        HttpURLConnection conn = (HttpURLConnection) slackUrl.openConnection();

        StringBuilder createChannelreq =  new StringBuilder("token={0}&name={1}".replace("{0}",
                Constants.URLS.token).replace("{1}",newChannel));
        JsonObject jsonObject ;
        try {
            String strcreateChannelreq = commanMethods.setPOSTReqProperties(createChannelreq, conn);
            commanMethods.getResp(conn.getOutputStream(), strcreateChannelreq);
            StringBuilder resp = commanMethods.printResponse(conn.getInputStream());
            jsonObject = new JsonParser().parse(resp.toString()).getAsJsonObject();
        }
        catch (Exception ex) {
            System.out.println("Creating of conversation is failed due to  " + ex.getMessage());
            throw ex;
        }
        return jsonObject.get("channel").getAsJsonObject().get("id").toString();

    }

    public static void main(String [] args){
        CreateChannel createChannel = new CreateChannel();
        try {
            if(createChannel.createNewChannel("tryingTwelev")!= null){
                System.out.println("New channel got created successfully");
            }
        }
        catch (IOException ex){
            System.out.println("The exception is  :"+ex);
        }
    }

}
