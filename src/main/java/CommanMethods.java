import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.nio.charset.StandardCharsets;

public class CommanMethods {

    public StringBuilder printResponse(InputStream inputStreamResp) throws IOException {
        StringBuilder resp = new StringBuilder();
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(inputStreamResp, "utf-8"))){

            String responses = null;
            while((responses =  br.readLine() )!= null){
                resp.append(responses.trim());
                System.out.println(resp);
            }

        }
        return resp;
    }

    public void getResp(OutputStream outputStreamReq , String strReq) throws IOException{
        DataOutputStream ds = new DataOutputStream(outputStreamReq);
        ds.writeBytes(strReq);
        ds.flush();
        ds.close();
    }

    public String setPOSTReqProperties (StringBuilder stringBuilderReq , HttpURLConnection connection)
            throws ProtocolException {

        String strCreateReq = stringBuilderReq.toString();
        byte[] req = strCreateReq.getBytes(StandardCharsets.UTF_8);
        connection.setRequestMethod("POST");
        connection.setRequestProperty(Constants.RequestParam.CONTENTTYPE , Constants.RequestParam.CONTENTTYPEVALUE);
        connection.setRequestProperty(Constants.RequestParam.CONTENTLENGTH , ""+Integer.toString(strCreateReq.getBytes()
                .length));
        connection.setRequestProperty("Content-Language", "en-US");

        connection.setDoOutput(true);

        return strCreateReq;
    }
}
