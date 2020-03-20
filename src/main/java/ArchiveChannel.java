import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class ArchiveChannel {

    CommanMethods commanMethods = new CommanMethods();

    public String archiveConversation (String channelId) throws IOException{
        URL slackurl = new URL(Constants.URLS.url +"/"+ Constants.apis.ARCHIVECHANNEL);

        HttpURLConnection connection = (HttpURLConnection) slackurl.openConnection();

        StringBuilder conversationsArchiveReq = new StringBuilder("token={0}&channel={1}".replace("{0}",
                Constants.URLS.token).replace("{1}",channelId));
        JsonObject jsonObject ;
        try {
            String strConversationArchiveReq = commanMethods.setPOSTReqProperties(conversationsArchiveReq, connection);
            commanMethods.getResp(connection.getOutputStream(), strConversationArchiveReq);
            StringBuilder resp = commanMethods.printResponse(connection.getInputStream());
            jsonObject = new JsonParser().parse(resp.toString()).getAsJsonObject();
        }
        catch (Exception ex) {
            System.out.println("Archive conversation failed due to  " + ex.getMessage());
            throw ex;
        }

        return jsonObject.get("ok").toString();
    }

    public boolean isArchivedChannel(String channelId) throws IOException{

        if(archiveConversation(channelId) == "true"){
            System.out.println("Status true ");
            return true;
        }
        return  false;
    }
    public static void main(String [] args){

        ArchiveChannel archiveChannel = new ArchiveChannel();

        try {
            archiveChannel.isArchivedChannel("C010GC9QLEA");
        }
        catch (IOException ex){
            System.out.println("The exception is  :"+ex);
        }
    }
}
