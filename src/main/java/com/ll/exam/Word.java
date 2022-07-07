package com.ll.exam;

public class Word {
    String author;
    String word;
    int id;

    public Word(int id, String author, String word) {
        this.author = author;
        this.word = word;
        this.id = id;
        System.out.println("명언: " + word);
        System.out.println("작가: " + author);
    }
}
