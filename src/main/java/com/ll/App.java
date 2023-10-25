package com.ll;

import java.util.Scanner;

class App {
    void run() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print("명언) ");

            Scanner sc = new Scanner(System.in);
            String cmd = sc.nextLine();

            if(cmd.equals("종료")) {
                break;
            }
        }
    }
}