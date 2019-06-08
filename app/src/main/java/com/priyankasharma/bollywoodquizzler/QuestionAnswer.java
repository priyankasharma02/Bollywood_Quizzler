package com.priyankasharma.bollywoodquizzler;

public class QuestionAnswer {

    int questionId,correctOption,A,B,C,D;

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    public QuestionAnswer(int questionId, int A, int B, int C, int D, int correctOption)
    {
        this.questionId = questionId;
        this.correctOption = correctOption;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }
}
