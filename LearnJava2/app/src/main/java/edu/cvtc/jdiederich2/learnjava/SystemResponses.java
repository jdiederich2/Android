package edu.cvtc.jdiederich2.learnjava;

public class SystemResponses {
    private String hello = "Hello";
    private String question = "What is your name";
    String loginName;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int calculateFunction(int num1, int num2) {
        int total = num1 + num2;
        return total;
    }

    public String setLoginName(String firstName, String lastName) {
        loginName = (firstName.subSequence(0, 3) + lastName).toLowerCase();
        return loginName;
    }
}
