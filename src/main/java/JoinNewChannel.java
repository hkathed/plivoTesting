import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;



public class JoinNewChannel {
    CommanMethods commanMethods = new CommanMethods();

    public void conversationsJoin(String channelId) throws IOException{
        URL slackUrl = new URL(Constants.URLS.url + "/" + Constants.apis.JOINCHANNEL);

        HttpURLConnection connection =  (HttpURLConnection) slackUrl.openConnection();
        connection.setRequestMethod("POST");

        StringBuilder conversationsJoinReq = new StringBuilder("token={0}&channel={1}".replace("{0}",
                Constants.URLS.token).replace("{1}",channelId));
        try {
            String strConversationsJoinReq = commanMethods.setPOSTReqProperties(conversationsJoinReq, connection);
            commanMethods.getResp(connection.getOutputStream(), strConversationsJoinReq);
            commanMethods.printResponse(connection.getInputStream());
        }
        catch (Exception ex) {
            System.out.println("Join to conversation failed due to  " + ex.getMessage());
            throw ex;
        }

    }

    public static void main(String [] args){

        JoinNewChannel joinNewChannel = new JoinNewChannel();

        try {
            String channelId = "CVA91D3TM";
            if(channelId!= null){
                joinNewChannel.conversationsJoin(channelId);
            }
        }
        catch (IOException ex){
            System.out.println("The exception is  :"+ex);
        }
    }

}
