package com.ll.exam;

public class Word {
    String author;
    String word;

    public Word(String author, String word) {
        this.author = author;
        this.word = word;
        System.out.println("명언: " + word);
        System.out.println("작가: " + author);
    }
}
