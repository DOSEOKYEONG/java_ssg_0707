package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class FamousSayingRepository {
    private int LastId;
    private List<FamousSaying> famousSayingList;

    public FamousSayingRepository() {
        famousSayingList = new ArrayList<>();
        LastId = 1;
    }

    public FamousSaying add(String writer, String content) {
        FamousSaying famousSaying = new FamousSaying(LastId, writer, content);

        famousSayingList.add(famousSaying);

        LastId++;

        return famousSaying;
    }

    public List<FamousSaying> findAll() {
        return famousSayingList;
    }

    public FamousSaying findById(int objectId) {
        for (FamousSaying fs : famousSayingList){
            if(fs.getId() == objectId){
                return fs;
            }
        }
        System.out.println("해당 게시글이 존재하지 않습니다.");
        return null;
    }

    public boolean update(int objectId, String writer, String content) {
        FamousSaying famousSaying = findById(objectId);

        if ( famousSaying == null){
            return false;
        }
        famousSaying.setContent(content);
        famousSaying.setWriter(writer);

        return true;
    }

    public boolean remove(int objectId) {
        FamousSaying famousSaying = findById(objectId);

        if ( famousSaying == null){
            return false;
        }
        famousSayingList.remove(famousSaying);

        return true;
    }
}
