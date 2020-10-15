import bookmark.BookmarkCategory;
import bookmark.BookmarkUi;
import bookmark.commands.AddLinkCommand;
import bookmark.commands.BackCommand;
import bookmark.commands.BookmarkCommand;
import bookmark.commands.ChangeModeCommand;
import bookmark.commands.ListCommand;
import bookmark.commands.RemoveLinkCommand;
import bookmark.InvalidBookmarkCommandException;

public class BookmarkParser extends CommandParser {
    private static int chosenCategory;

    public BookmarkParser() {
    }

    public BookmarkCommand evaluateInput(String command) throws InvalidBookmarkCommandException {
        if (command == null) {
            throw new InvalidBookmarkCommandException();
        }
        String commandModified = CommandParser.standardizeCommand(command);
        if (commandModified.startsWith("bm")) {
            getChosenCategory(command);
            return new ChangeModeCommand(chosenCategory);
        } else if (commandModified.startsWith("add")) {
            return new AddLinkCommand(command, chosenCategory);
        } else if (commandModified.startsWith("rm")) {
            return new RemoveLinkCommand(command, chosenCategory);
        } else if (commandModified.startsWith("list")) {
            return new ListCommand(chosenCategory);
        } else if (commandModified.startsWith("back")) {
            String backCommand = updateChosenCategory();
            return new BackCommand(backCommand);
        } else {
            throw new InvalidBookmarkCommandException();
        }
    }

    private String updateChosenCategory() {
        if (chosenCategory == 0) {
            return "Goodbye";
        } else {
            resetBookmarkCategory();
            return "Category";
        }
    }

    public static void resetBookmarkCategory() {
        chosenCategory = 0;
    }

    private void getChosenCategory(String line) {
        chosenCategory = Integer.parseInt(line.substring(2).trim());
    }

}