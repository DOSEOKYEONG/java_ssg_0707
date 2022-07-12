package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    private Scanner sc;
    private List<FamousSaying> famousSayingList;
    private int LastId;

    public App() {
        sc = new Scanner(System.in);
        famousSayingList = new ArrayList<>();
        LastId = 1;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    write(rq);
                    break;
                case "삭제":
                    remove(rq);
                    break;
                case "목록":
                    listing(rq);
                    break;
                case "수정":
                    update(rq);
                    break;
                case "빌드":
                    break;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }

    private void update(Rq rq) {
        int ObjectId = rq.ObjectId;
        System.out.println("작가 : ");
        String writer = sc.nextLine().trim();
        System.out.println("명언 : ");
        String content = sc.nextLine().trim();
        FamousSaying updateObject = findById(ObjectId);
        updateObject.setContent(content);
        updateObject.setWriter(writer);
        System.out.println(ObjectId + "번의 게시글이 수정되었습니다.");
    }

    private void listing(Rq rq) {
        System.out.println("번호 / 작가 / 명언\n" +
                "----------------------");
        for (FamousSaying fs : famousSayingList){
            System.out.println(fs.getId() + "/" + fs.getWriter() + "/" + fs.getContent());
        }
    }

    private void remove(Rq rq) {
        int ObjectId = rq.ObjectId;
        FamousSaying famousSaying = findById(ObjectId);
        famousSayingList.remove(famousSaying);
    }

    private FamousSaying findById(int objectId) {
        for (FamousSaying fs : famousSayingList){
            if(fs.getId() == objectId){
                return fs;
            }
        }
        System.out.println("해당 게시글이 존재하지 않습니다.");
        return null;
    }

    private void write(Rq rq) {
        System.out.println("작가 : ");
        String writer = sc.nextLine().trim();
        System.out.println("명언 : ");
        String content = sc.nextLine().trim();
        FamousSaying famousSaying = new FamousSaying(LastId, writer, content);
        famousSayingList.add(famousSaying);
        System.out.println(LastId + "번 명언이 등록되었습니다.");
        LastId++;
    }
}