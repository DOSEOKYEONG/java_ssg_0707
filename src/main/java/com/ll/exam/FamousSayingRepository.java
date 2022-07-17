package com.ll.exam;

import java.util.List;

public class FamousSayingRepository {
    private FamousSayingTable famousSayingTable;

    public FamousSayingRepository() {
        famousSayingTable = new FamousSayingTable();
    }

    public FamousSaying add(String writer, String content) {
        return famousSayingTable.save(writer, content);
    }

    public List<FamousSaying> findAll() {
        return famousSayingTable.findAll();
    }

    public FamousSaying findById(int objectId) {
        return famousSayingTable.findById(objectId);
    }

    public boolean update(int objectId, String writer, String content) {
       return famousSayingTable.save(objectId, writer, content);
    }

    public boolean remove(int objectId) {
        return famousSayingTable.removeById(objectId);
    }

    public void dumpToJson() {
        famousSayingTable.dumpToJson();
    }
}
