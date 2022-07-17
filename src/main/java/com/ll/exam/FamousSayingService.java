package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class FamousSayingService {


    private FamousSayingRepository famousSayingRepository;

    public FamousSayingService() {
        famousSayingRepository = new FamousSayingRepository();
    }

    public FamousSaying write(String writer, String content) {
        return famousSayingRepository.add(writer, content);
    }

    public List<FamousSaying> findAll() {
        return famousSayingRepository.findAll();
    }

    public FamousSaying findById(int objectId) {
        return famousSayingRepository.findById(objectId);
    }

    public boolean update(int objectId, String writer, String content) {

        return famousSayingRepository.update(objectId, writer, content);
    }

    public boolean remove(int objectId) {
        return famousSayingRepository.remove(objectId);
    }
}
