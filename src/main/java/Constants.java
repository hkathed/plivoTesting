public class Constants {

    public interface URLS{
        String url = "https://slack.com/api/";
        String token ="xoxp-1000278673808-999822936500-1005863654086-6009f15da788179ca9b809598cc37247";

    }

    public interface apis{
        String CREATECHANNEL ="channels.create";
        String JOINCHANNEL = "conversations.join";
        String RENAMECHANNEL = "conversations.rename";
        String LISTCHANNEL = "conversations.list";
        String ARCHIVECHANNEL = "conversations.archive";
    }

    public interface RequestParam {
        String CONTENTTYPE = "Content-Type";
        String CONTENTTYPEVALUE = "application/x-www-form-urlencoded";
        String CHARSET = "charset";
        String CONTENTLENGTH = "Content-Length";
        String UTf = "utf-8";
        String RESPONSEFORMATVALUE = "application/json";

    }
}



