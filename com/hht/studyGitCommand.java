package com.hht;

import java.util.Arrays;

public class studyGitCommand {
    public static void main(String[] args) {
        int[] a = {1,2,46,23,2};
        studyGitCommand command = new studyGitCommand();
        System.out.println(Arrays.toString(command.sort(a)));
    }

    public int[] sort(int[] a){
        Arrays.sort(a);
        return a;
    }
}
