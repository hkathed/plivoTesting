import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;



public class ListChannel {

    CommanMethods commanMethods = new CommanMethods();

        public void listConverstion() throws IOException {

            URL slackurl = new URL(Constants.URLS.url +"/"+ Constants.apis.LISTCHANNEL);

            HttpURLConnection connection = (HttpURLConnection) slackurl.openConnection();
            StringBuilder conversationListReq = new StringBuilder("token={0}".replace("{0}",
                    Constants.URLS.token));
            try {
                String strConversationListReq = commanMethods.setPOSTReqProperties(conversationListReq, connection);
                commanMethods.getResp(connection.getOutputStream(), strConversationListReq);
                commanMethods.printResponse(connection.getInputStream());
            }
            catch (Exception ex) {
                System.out.println("Lists conversation failed due to  " + ex.getMessage());
                throw ex;
            }

        }
        public static void main(String [] args){

            ListChannel listChannel = new ListChannel();

            try {
                listChannel.listConverstion();
            }
            catch (IOException ex){
                System.out.println("The exception is  :"+ex);
            }
        }
}


