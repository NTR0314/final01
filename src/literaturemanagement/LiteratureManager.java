package literaturemanagement;

import edu.kit.informatik.Terminal;
import literaturemanagement.commands.CommandArray;

import java.util.ArrayList;

public class LiteratureManager {
    private boolean programmFlow = true;

    private AuthorList authorList;

    public LiteratureManager(AuthorList authorList) {
        this.authorList = authorList;
    }

    public static void main(String[] args) {

        LiteratureManager literatureManager = new LiteratureManager(new AuthorList());
        while (literatureManager.programmFlow) {
            literatureManager.runCommands(Terminal.readFile("C:\\Users\\Bosswald\\Desktop\\hehexd.txt"));
        }
    }

    public void runCommands(String[] commands) {
        for (int i = 0; i < commands.length; i++) {
            for (int j = 0; j < CommandArray.COMMAND_ARRAY.length; j++) {
                if (commands[i].matches(CommandArray.COMMAND_ARRAY[j].getRegex())) {
                    CommandArray.COMMAND_ARRAY[j].execute(this, commands[i]);
                }

            }
        }


    }

    public void setProgrammFlow(boolean programmFlow) {
        this.programmFlow = programmFlow;
    }

    public AuthorList getAuthorList() {
        return authorList;
    }
}
