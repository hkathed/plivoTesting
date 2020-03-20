import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class RenameChannel {
    CommanMethods commanMethods = new CommanMethods();

    public void renameConverstion(String channelId, String newName) throws IOException {

        URL slackurl = new URL(Constants.URLS.url +"/"+ Constants.apis.RENAMECHANNEL);

        HttpURLConnection connection = (HttpURLConnection) slackurl.openConnection();

        StringBuilder conversationsRenameReq = new StringBuilder("token={0}&channel={1}&name={2}".replace("{0}",
                Constants.URLS.token).replace("{1}",channelId).replace("{2}",newName));
        try {
            String strConversationsRenameReq = commanMethods.setPOSTReqProperties(conversationsRenameReq, connection);
            commanMethods.getResp(connection.getOutputStream(), strConversationsRenameReq);
            commanMethods.printResponse(connection.getInputStream());
        }
        catch (Exception ex) {
            System.out.println("Renaming of conversation failed due to  " + ex.getMessage());
            throw ex;
        }

    }
    public static void main(String [] args){

        RenameChannel renameChannel = new RenameChannel();

        try {
            String channelId = "CVA91D3TM";
            renameChannel.renameConverstion(channelId, "renamefive");
        }
        catch (IOException ex){
            System.out.println("The exception is  :"+ex);
        }
    }


}


