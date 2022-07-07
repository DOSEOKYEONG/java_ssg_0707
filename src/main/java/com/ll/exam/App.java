package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        String author;
        String word;
        List<Word> wordList = new ArrayList<>();
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);
        Word word1;

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "종료":
                    break outer;
                case "등록":
                    System.out.println("명언: ");
                    word = sc.nextLine().trim();
                    System.out.println("작가: ");
                    author = sc.nextLine().trim();
                    word1 = new Word(author, word);
                    wordList.add(word1);
                    System.out.println(wordList.size() + "번 명언이 등록되었습니다.");
            }
        }

        sc.close();
    }
}

