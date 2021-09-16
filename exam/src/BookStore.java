import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book implements Serializable {
    private int code;
    private String title;
    private String author;
    private Long price;

    public Book(int code, String title, String author, Long price) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}

public class BookStore {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        File bookFile = new File("C:\\Users\\quan0\\Desktop\\Book.txt");
        if(!bookFile.exists()) {
            if (bookFile.createNewFile()) {
                System.out.println("Created Book file");
            }
        }
        List<Book> bookList = new ArrayList<>();
        boolean flag = true;
        int choose, index;
        while(flag) {
            System.out.println("=============Menu===============");
            System.out.println("1. Create new Book");
            System.out.println("2. Show Book list");
            System.out.println("0. Exit");
            choose = sc.nextInt();
            switch (choose) {
                case 1 -> {
                    FileOutputStream f = new FileOutputStream(bookFile);
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    Book newBook = new Book();
                    System.out.println("Book Info");
                    System.out.println("Code: ");
                    newBook.setCode(sc.nextInt());
                    System.out.println("Title: ");
                    sc.nextLine();
                    newBook.setTitle(sc.nextLine());
                    System.out.println("Author: ");
                    newBook.setAuthor(sc.nextLine());
                    System.out.println("Price: ");
                    newBook.setPrice(sc.nextLong());
                    bookList.add(newBook);
                    o.writeObject(bookList);
                    o.close();
                }
                case 2 -> {
                    if (bookFile.length() == 0) {
                        System.out.println("Empty");
                    } else {
                        FileInputStream fi = new FileInputStream(bookFile);
                        ObjectInputStream oi = new ObjectInputStream(fi);
                        List<Book> bookInputList = (ArrayList<Book>) oi.readObject();
                        index = 1;
                        for (Book book : bookInputList) {
                            System.out.println("List Of Book: ");
                            System.out.println(index++ + ".");
                            System.out.println("Code : " + book.getCode());
                            System.out.println("Title : " + book.getTitle());
                            System.out.println("Author : " + book.getAuthor());
                            System.out.println("Price : " + book.getPrice());
                        }
                        oi.close();
                    }
                }
                case 3 -> flag = false;
                default -> System.out.println("Wrong syntax");
            }
        }
    }
}
