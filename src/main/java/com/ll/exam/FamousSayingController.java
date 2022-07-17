package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FamousSayingController {
    private Scanner sc;

    private FamousSayingService famousSayingService;

    public FamousSayingController(Scanner sc) {
        this.sc = sc;
        famousSayingService = new FamousSayingService();
    }

    public void remove(Rq rq) {
        int ObjectId = rq.ObjectId;
        famousSayingService.remove(ObjectId);

        System.out.println(ObjectId + "번 글이 삭제 되었습니다.");
    }

    public void update(Rq rq) {
        int ObjectId = rq.ObjectId;
        System.out.println("작가 : ");
        String writer = sc.nextLine().trim();
        System.out.println("명언 : ");
        String content = sc.nextLine().trim();
        famousSayingService.update(ObjectId, writer, content);

        System.out.println(ObjectId + "번의 게시글이 수정되었습니다.");
    }

    public void listing(Rq rq) {

        List<FamousSaying>famousSayingList = famousSayingService.findAll();

        System.out.println("번호 / 작가 / 명언\n" +
                "----------------------");
        for (FamousSaying fs : famousSayingList){
            System.out.println(fs.getId() + "/" + fs.getWriter() + "/" + fs.getContent());
        }
    }

    public void write(Rq rq) {
        System.out.println("작가 : ");
        String writer = sc.nextLine().trim();
        System.out.println("명언 : ");
        String content = sc.nextLine().trim();
        FamousSaying famousSaying = famousSayingService.write(writer, content);
        System.out.println(famousSaying.getId() + "번 명언이 등록되었습니다.");
    }
}
