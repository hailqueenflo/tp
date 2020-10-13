package seedu.duke.Bookmark;

import java.util.ArrayList;
import java.util.Scanner;

public class BookmarkUi {
    public static final String LINE = "========================================================";
    private Scanner in;

    public BookmarkUi(){
        this.in = new Scanner(System.in);
    }

    public void printWelcomeBookmarkMessage(){
        System.out.println("Welcome to B00KMARK!");
        System.out.println("Choose your categories!");
    }

    public void printLine() {
        System.out.println(LINE);
    }

    public String readInput(){
        return this.in.nextLine();
    }

    public void showBookmarkCategoryList(ArrayList<BookmarkCategory> categories){
        System.out.println("Printing bookmark categories");
        int i = 1;
        for (BookmarkCategory category: categories){
            System.out.println(i +"." + category.getName());
            i++;
        }
    }

    public void showBookmarkLinkList(ArrayList<BookmarkList> links){
        System.out.println("Printing bookmark list");
        int i = 1;
        for (BookmarkList link: links){
            System.out.println(i +"." + link.getLink());
            i++;
        }
    }

    public void printGoodbyeMessage(){
        System.out.println("EXITED from bookmark");
    }

    public void showBookmarkList(ArrayList<BookmarkCategory> categories){
        System.out.println("Here is the list");
        for (int i = 0; i < categories.size() ;i++){
            System.out.println(categories.get(i));
            showBookmarkLinkList(categories.get(i).getLinks());
        }
    }

}
