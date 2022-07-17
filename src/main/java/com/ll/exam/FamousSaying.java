package com.ll.exam;

public class FamousSaying {
    private int id;
    private String writer;
    private String content;

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public FamousSaying(int id, String writer, String content) {
        this.id = id;
        this.writer = writer;
        this.content = content;
    }

    @Override
    public String toString() {
        return "FamousSaying{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

    public String toJson() {
        return """
                {
                    "id": %d,
                    "content": "%s",
                    "writer": "%s"
                }
                """.stripIndent().formatted(id, content, writer);
    }
}
