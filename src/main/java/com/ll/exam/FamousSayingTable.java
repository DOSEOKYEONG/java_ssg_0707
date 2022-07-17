package com.ll.exam;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FamousSayingTable {

//    private String baseDir;
//
//    public FamousSayingTable(String baseDir) {
//        this.baseDir = baseDir;
//    }


    public FamousSayingTable() {
    }

    public static String getTableDataDumpFilePath() {
        return getTableDirPath() + "/data.json";
    }

    private void saveLastId(int id) {
        Util.file.saveNoToFile(getTableLastIdFilePath(), id);
    }

    public static String getTableLastIdFilePath() {
        return getTableDirPath() + "/last_id.txt";
    }

    public static String getTableDataFilePath(int id) {
        return getTableDirPath() + "/" + id + ".json";
    }

    public static String getTableDirPath() {
        return App.getDataBaseDir() + "/famous_saying";
    }

    public int getLastId() {
        return Util.file.readNoFromFile(getTableLastIdFilePath(), 0);
    }

    public void save(FamousSaying famousSaying) {
        Util.file.mkdir(getTableDirPath());
        String body = famousSaying.toJson();
        Util.file.saveToFile(getTableDataFilePath(famousSaying.getId()) ,body);

    }

    public FamousSaying save(String writer, String content) {
        int id = getLastId() + 1;

        FamousSaying famousSaying = new FamousSaying(id, writer, content);

        save(famousSaying);

        saveLastId(id);

        return famousSaying;
    }

    public boolean save(int id, String writer, String content) {
        FamousSaying famousSaying = new FamousSaying(id, writer, content);

        save(famousSaying);

        return true;
    }

    public FamousSaying findById(int id) {
        String path = getTableDataFilePath(id);

        if (new File(path).exists() == false){
            return null;
        }

        Map<String, Object> map = Util.json.jsonToMapFromFile(path);

        if (map == null){
            return null;
        }

        return new FamousSaying((int) map.get("id"), (String) map.get("writer"), (String) map.get("content"));
    }

    public List<FamousSaying> findAll() {
        List<Integer> fileIds = getFileIds();

        return fileIds
                .stream()
                .map(id -> findById(id))
                .collect(Collectors.toList());
    }

    private List<Integer> getFileIds() {
        String path = getTableDirPath();
        List<String> fileNames = Util.file.getFileNamesFromDir(path);

//        return fileNames
//                .stream()
//                .filter(fileName -> !fileName.equals("last_id.txt"))
//                .map(fileName -> fileName.replace(".json", ""))
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .collect(Collectors.toList());
        return fileNames
                .stream()
                .filter(fileName -> !fileName.equals("last_id.txt"))
                .filter(fileName -> !fileName.equals("data.json")) // 영상에는 이 부분이 빠져있습니다. 꼭 추가해주세요.
                .filter(fileName -> fileName.endsWith(".json"))
                .map(fileName -> fileName.replace(".json", ""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

    }

    public boolean removeById(int id) {
        String path = getTableDataFilePath(id);

        File file = new File(path);

        if(file.exists()==false){
            return false;
        }

        file.delete();
        return true;
    }

    public void dumpToJson() {
        List<FamousSaying> famousSayingList = findAll();

        String json = "[" + famousSayingList
                .stream()
                .map(FamousSaying -> FamousSaying.toJson())
                .collect(Collectors.joining(",")) + "]";
        Util.file.saveToFile(FamousSayingTable.getTableDataDumpFilePath(), json);
    }
}
