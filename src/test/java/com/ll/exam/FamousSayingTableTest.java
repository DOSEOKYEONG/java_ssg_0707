package com.ll.exam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamousSayingTableTest {
    private FamousSayingTable famousSayingTable;

    @BeforeAll
    public void beforeAll(){
        App.setMode("test");
        famousSayingTable = new FamousSayingTable();
    }

    @BeforeEach
    public void BeforeEach(){
        Util.file.deleteDir(App.getDataBaseDir());

        famousSayingTable.save("123", "123");
        famousSayingTable.save("456", "456");
    }

    @Test
    public void 저장(){
        int newId = famousSayingTable.getLastId() + 1;
        famousSayingTable.save("asdasd", "asdada");

        assertTrue(new File(FamousSayingTable.getTableDataFilePath(newId)).exists());
    }

    @Test
    public void 조회(){
        FamousSaying famousSaying = famousSayingTable.findById(1);

        assertEquals(1, famousSaying.getId());
    }

    @Test
    public void 전체조회(){
        List<FamousSaying> famousSayingList = famousSayingTable.findAll();

        for (FamousSaying famousSaying : famousSayingList){
            System.out.println(famousSaying.toString());
        }

        assertEquals(2, famousSayingList.size());
        assertEquals(1, famousSayingList.get(0).getId());
        assertEquals("123", famousSayingList.get(0).getContent());
        assertEquals("123", famousSayingList.get(0).getWriter());
    }

    @Test
    public void 삭제(){
        famousSayingTable.removeById(1);

        FamousSaying famousSaying = famousSayingTable.findById(1);

        assertEquals(null, famousSaying);
    }
}