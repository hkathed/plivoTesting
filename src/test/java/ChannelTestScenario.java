import org.junit.Test;

import java.io.IOException;

public class ChannelTestScenario {

    @Test
    private void testChannel() throws IOException {
        CreateChannel createChannel = new CreateChannel();
        JoinNewChannel joinNewChannel = new JoinNewChannel();
        RenameChannel renameChannel = new RenameChannel();
        ListChannel listChannel = new ListChannel();
        ArchiveChannel archiveChannel = new ArchiveChannel();
        String channelId = "";
        channelId =  createChannel.createNewChannel("NewTestChannel");
        joinNewChannel.conversationsJoin(channelId);
        renameChannel.renameConverstion(channelId, "newtestacc");
        listChannel.listConverstion();
        archiveChannel.isArchivedChannel(channelId);

    }
}

